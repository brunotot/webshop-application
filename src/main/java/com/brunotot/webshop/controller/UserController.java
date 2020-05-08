package com.brunotot.webshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brunotot.webshop.content.ShoppingCart;
import com.brunotot.webshop.form.UserForm;
import com.brunotot.webshop.service.UserService;
import com.brunotot.webshop.util.Constants;
import com.brunotot.webshop.util.Helper;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.addObject("msg", request.getAttribute("msg"));
		model.addObject("userForm", new UserForm());
		model.setViewName("/user/signup");
		return model;
	}
	
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public ModelAndView settings(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.addObject("msg", request.getAttribute("msg"));
		model.setViewName("/user/settings");
		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("userForm") UserForm userForm, BindingResult result, RedirectAttributes redirectAttributes) {
		String errorMessage = "";
		String username = userForm.getUsername();
		if (!Helper.isValid(username)) {
			errorMessage += "Invalid username!\\n";
		}
		
		if (userService.userExists(userForm.getUsername())) {
			errorMessage += "Username already exists!\\n";
		}
		
		if (!userForm.getPassword().equals(userForm.getConfirmPassword())) {
			errorMessage += "Passwords do not match!\\n";
		}

		ModelAndView model = new ModelAndView();
		if (errorMessage.length() != 0) {
			model.addObject("msg", "Errors:\\n\\n" + errorMessage);
			model.setViewName("/user/signup");
		} else {
			userService.add(userForm.getUsername(), userForm.getPassword());
			model.addObject("msg", "Your account has been created successfully!");
			model.setViewName("/login/login");
		}
		return model;
	}

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
	
	@RequestMapping(value = "/purchaseditems", method = RequestMethod.GET)
	public ModelAndView purchasedItems(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("/user/purchased-items");
		return model;
	}

}
