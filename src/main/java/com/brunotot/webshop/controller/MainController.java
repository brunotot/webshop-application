package com.brunotot.webshop.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.brunotot.webshop.content.Item;
import com.brunotot.webshop.content.ShoppingCart;
import com.brunotot.webshop.content.ShoppingCartItem;
import com.brunotot.webshop.util.Constants;
import com.brunotot.webshop.util.Helper;

@RestController
public class MainController {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	ShoppingCart cart;
	
	@PostMapping("/instock") 
	public boolean isInStock(@RequestParam(value = "id") int id, 
							 @RequestParam(value = "category") String category, 
							 @RequestParam(value = "wantedamount") int wantedAmount,
							 @RequestParam(value = "start") String start,
							 HttpServletRequest request) {
		boolean exists = false;
		
		try {
			ResultSet rs = Helper.getResultSetById(dataSource.getConnection().createStatement(), id, category);
			
			int totalInStock = rs.getInt("stock");
			int itemCountInCart = Helper.getShoppingCartItemCountViaId(id, request);
		
			int currentTotalLeftInStock;
		
			if (start.equals("home")) {
				currentTotalLeftInStock = totalInStock - itemCountInCart;
			} else {
				currentTotalLeftInStock = totalInStock; 
			}
			
			if (currentTotalLeftInStock >= wantedAmount) {
				exists = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exists;
	}
	
	@PostMapping("/removeitem")
	public ModelAndView removeItem(@RequestParam(value = "id") int id, 
								   @RequestParam(value = "category") String category, 
								   @CookieValue(value = "cart", defaultValue = "") String cartCookie, 
								   HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("home/shoppingcart");
		
		cart.remove(id);

		String currentCookieName = id + ":" + category + "~";
		String newCookieValue = cartCookie.replace(currentCookieName, "");
		Helper.updateCookies(response, newCookieValue);
		
		return model;
	}
	
	@PostMapping("/additem") 
	public ModelAndView appendNewItem(@RequestParam(value = "id") int id, 
									  @RequestParam(value = "category") String category,
									  @RequestParam(value = "quantity") int quantity,
									  @RequestParam(value = "start") String start,
									  @CookieValue(value = "cart", defaultValue = "") String cartCookie,
									  HttpServletRequest request,
									  HttpServletResponse response) throws SQLException {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("home/home");
		request.setAttribute("category", category);
		
		String newCookieValue = "";
		String selectedItemCookieName = id + ":" + category + "~";
		if (cart.exists(id)) {
			if (start.equals("home")) {
				cart.addOne(id);
				newCookieValue = cartCookie + selectedItemCookieName;
			} else {
				cart.update(id, quantity);
				newCookieValue = cartCookie.replace(selectedItemCookieName, "");
				for (int i = 0; i < quantity; i++) {
					newCookieValue += selectedItemCookieName;
				}
				model.setViewName("home/shoppingcart");
			}
			Helper.updateCookies(response, newCookieValue);
			return model;
		}
		
		Statement st = dataSource.getConnection().createStatement();
		Item item = Helper.getCategoryItemFromTableRowData(category, Helper.getResultSetById(st, id, category), st);
		st.close();
		cart.add(new ShoppingCartItem(item, 1));
		
		newCookieValue = cartCookie + selectedItemCookieName;
		Helper.updateCookies(response, newCookieValue);
		
		return model;
	}
	
	@RequestMapping(value = "shoppingcart/clearall", method = RequestMethod.GET)
	public ModelAndView clearAllItems(HttpServletRequest request, HttpServletResponse response) {
		Helper.updateCookies(response, null);
		
		cart.getItems().clear();
		
		ModelAndView model = new ModelAndView();
		model.setViewName("home/shoppingcart");
		
		try {
			response.sendRedirect("/shoppolis/shoppingcart");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addObject(Constants.BEAN_SHOPPING_CART, "");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView model = new ModelAndView();
		
		if (error != null) {
			model.addObject("msg", "The username or password is incorrect!");
		}
		
		model.setViewName("login/login");
		String userCredentials = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		if (userCredentials != null && userCredentials != "anonymousUser") {
			model.setViewName("home/home");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/category")
	public ModelAndView category(@RequestParam(value = "category", defaultValue = "") String category, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("home/home");
		request.setAttribute("category",  category);
		return model;
	}
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home/index");
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String query = "delete from " + Constants.TABLE_PERSISTENT_LOGINS + " where username='" + Helper.getEscapedQueryVariable(auth.getName()) + "'";
		try {
			this.dataSource.getConnection().createStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		ModelAndView model = new ModelAndView();
		model.setViewName("home/index");
		return model;
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("errors/access_denied");
		return model;
	}
	
	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET) 
	public ModelAndView shoppingCart (){
		ModelAndView model = new ModelAndView();
		model.setViewName("home/shoppingcart");
		return model;
	}
	
	@PostMapping("/filter") 
	public ModelAndView submitFilter(@RequestParam(value = "category") String category, HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		String preparedQuery = Helper.getSubmitFormQuery(category, map);
		ResultSet rs = null;
		try {
			rs = Helper.executePreparedQuery(((DataSource) Helper.getBeanFromRequest(request, Constants.BEAN_DATA_SOURCE)).getConnection(), preparedQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView model = new ModelAndView();
		model.addObject("category", category);
		model.addObject("filteredResultSet", rs);
		model.addObject("filteredMap", map);
		model.setViewName("home/home");
		
		return model;
	}

	@GetMapping("/item") 
	public ModelAndView visitItem(@RequestParam(value = "id") String id, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.addObject("category", Helper.getCategoryById(id));
		model.setViewName("home/item");
		model.addObject("id", id);
		return model;
	}
	
	@PostMapping("/user/purchase") 
	public void purchase(HttpServletRequest request) throws SQLException {
		try {
			String username = request.getUserPrincipal().getName();
			Connection conn = ((DataSource) Helper.getBeanFromRequest(request, Constants.BEAN_DATA_SOURCE)).getConnection();
			ShoppingCart cart = ((ShoppingCart) Helper.getBeanFromRequest(request, Constants.BEAN_SHOPPING_CART));
			List<ShoppingCartItem> list = cart.getItems();
			String preparedQuery = "INSERT INTO `purchased`(`username`,`id`, `count`, `date`, `name`, `image`, `price`) VALUES (?,?,?,?,?,?,?);";
			Date date = new Date(Calendar.getInstance().getTimeInMillis());
			for (ShoppingCartItem item : list) {
				int id = item.getItem().getId();
				int count = item.getCount();
				String name = item.getItem().getFullName();
				String image = item.getItem().getImageUrl();
				int price = item.getItem().getPrice();
				Helper.executePreparedQuery(conn, preparedQuery, username, id, count, date, name, image, price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
