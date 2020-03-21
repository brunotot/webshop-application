package com.brunotot.webshop.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	@PostMapping("/additem") 
	public ModelAndView appendNewItem(@RequestParam(value = "id") int id, @RequestParam(value = "category") String category, HttpServletRequest request) throws SQLException {
		ModelAndView model = new ModelAndView();
		model.setViewName("home/home");
		
		
		List<ShoppingCartItem> shoppingCartItems = cart.getItems();
		for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
			Item item = shoppingCartItem.getItem();
			if (item.getId() == id) {
				shoppingCartItem.setCount(shoppingCartItem.getCount() + 1);
				return model;
			}
		}
		
		Statement st = dataSource.getConnection().createStatement();
		ResultSet tableRowData = Helper.getTableRowData(st, id, category);
		Item item = Helper.getCategoryItemFromTableRowData(category, tableRowData);
		cart.add(new ShoppingCartItem(item, 1));
		return model;
	}
	
	@RequestMapping(value = "shoppingcart/clearall", method = RequestMethod.GET)
	public ModelAndView clearAllItems(HttpServletRequest request, HttpServletResponse response) {
		// Remove cookies
		Cookie cookie = new Cookie("cart", null);
		cookie.setPath("/shoppolis");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		// Remove from shopping cart
		cart.getItems().clear();
		
		ModelAndView model = new ModelAndView();
		model.setViewName("home/shoppingcart");
		
		// Problems with counter not refreshing after 'return model;'
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
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home/home");
		
		/* Adds cookie for shopping cart */
		/*if (cartJson.compareTo("null") == 0) {
			String ids = "laptops:12340001~";
			Cookie cookie = new Cookie("cart", ids);
			cookie.setMaxAge(Helper.COOKIE_EXPIRATION_SECONDS);
			response.addCookie(cookie);
			model.addObject("cart", ids);
		}HttpServletResponse response, @CookieValue(value = "cart", defaultValue = "null") String cartJson*/
		
		
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		/* Remove user's persistent login on logout */
		String query = "delete from persistent_logins where username='" + auth.getName() + "'";
		try {
			this.dataSource.getConnection().createStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		ModelAndView model = new ModelAndView();
		model.setViewName("home/home");
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
}
