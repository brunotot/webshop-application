package com.brunotot.webshop.controller;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.brunotot.webshop.content.ShoppingCart;
import com.brunotot.webshop.util.Helper;
import com.google.gson.Gson;

@RestController
public class MainController {

	@Autowired
	DataSource dataSource;
	
	private Statement getConnectionStatement() throws SQLException {
		return dataSource.getConnection().createStatement();
	}
	
	/*@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
	public ModelAndView shoppingCart() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home/shoppingcart");
		
		return model;
	}*/
	
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
	public ModelAndView home(HttpServletResponse response, @CookieValue(value = "cartitems", defaultValue = "null") String cartJson) {
		ModelAndView model = new ModelAndView();
		model.setViewName("home/home");
		
		if (cartJson == "null") {
			ShoppingCart cart = new ShoppingCart();
			Cookie cookie = new Cookie("cart", new Gson().toJson(cart));
			cookie.setMaxAge(Helper.COOKIE_EXPIRATION_SECONDS);
			response.addCookie(cookie);
			model.addObject("cart", cart);
		}
		
		
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String query = "delete from persistent_logins where username='" + auth.getName() + "'";
		try {
			this.getConnectionStatement().execute(query);
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
	
	
	
	@GetMapping("/shoppingcart") 
	public ModelAndView getCookie (@CookieValue(value = "color", defaultValue = "#fff") String color, @CookieValue(value = "cartitems", defaultValue = "{}") String cartJson, HttpServletRequest request, @RequestParam("color") Optional<String> colorChosen){
		ModelAndView model = new ModelAndView();
		model.addObject("color", color);
		model.setViewName("home/shoppingcart");
		return model;
	}
	
	@PostMapping("/shoppingcart")
	public ModelAndView setCookie(HttpServletResponse response, @RequestParam("color") Optional<String> colorChosen) {
		String color = "#fff";
		if (colorChosen.get() != null) {
			color = colorChosen.get();
			response.addCookie(new Cookie("color", color));
		}
		ModelAndView model = new ModelAndView();
		model.addObject("color", color);
		model.setViewName("home/shoppingcart");
		return model;
	}
	
}
