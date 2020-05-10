package com.brunotot.webshop.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.brunotot.webshop.content.ShoppingCart;
import com.brunotot.webshop.service.UserService;
import com.brunotot.webshop.util.Constants;
import com.brunotot.webshop.util.Helper;

/**
 * User controller class.
 * 
 * @author Bruno
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * Autowired userService bean.
	 */
	@Autowired
	UserService userService;

	/**
	 * Maps to shoppolis/user/signup.
	 * 
	 * @param request Servlet request
	 * @return Model for user signup
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.addObject("msg", request.getAttribute("msg"));
		model.setViewName("/user/signup");
		return model;
	}

	/**
	 * Maps to shoppolis/user/settings.
	 * 
	 * @param request Servlet request
	 * @return Model for user settings
	 */	
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public ModelAndView settings(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.addObject("msg", request.getAttribute("msg"));
		model.setViewName("/user/settings");
		return model;
	}

	/**
	 * Maps to shoppolis/user/register.
	 * 
	 * @param username Input username
	 * @param password Input password
	 * @param confirmPassword Input confirm password
	 * @return Model for login or signup based on errors
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {
		String errorMessage = "";
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
	    Matcher m = p.matcher(username);
	    if (m.find()) {
			errorMessage += "Invalid username!\\n";
	    }
	    
		if (userService.userExists(username)) {
			errorMessage += "Username already exists!\\n";
		}
		
		if (!password.equals(confirmPassword)) {
			errorMessage += "Passwords do not match!\\n";
		}

		ModelAndView model = new ModelAndView();
		if (errorMessage.length() > 0) {
			model.addObject("msg", "Errors:\\n\\n" + errorMessage);
			model.setViewName("/user/signup");
		} else {
			userService.add(username, password);
			model.addObject("msg", "Your account has been created successfully!");
			model.setViewName("/login/login");
		}
		return model;
	}

	/**
	 * Maps to shoppolis/user/payment
	 * 
	 * @param request Servlet request
	 * @return Model for payment or shoppingcart based on shopping cart size
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public ModelAndView payment(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("/user/payment");
		
		ShoppingCart cart = (ShoppingCart) Helper.getBeanFromRequest(request, Constants.BEAN_SHOPPING_CART);
		if (cart.getItems() == null || cart.getItems().size() == 0) {
			model.setViewName("/home/shoppingcart");
		}
		
		return model;
	}
	
	/**
	 * Maps to shoppolis/user/purchaseditems.
	 * 
	 * @param request Servlet request
	 * @return Model for user purchased items
	 */
	@RequestMapping(value = "/purchaseditems", method = RequestMethod.GET)
	public ModelAndView purchasedItems(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("/user/purchased-items");
		return model;
	}

}
