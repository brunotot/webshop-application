package com.brunotot.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brunotot.webshop.form.UserForm;
import com.brunotot.webshop.model.UserInfo;
import com.brunotot.webshop.service.UserService;
import com.brunotot.webshop.validator.SignupValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	SignupValidator signupValidator;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView("user/signup");
		model.addObject("userForm", new UserForm());

		return model;
	}
	
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public ModelAndView settings() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/user/settings");
		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userForm") UserForm userForm, BindingResult result,
			RedirectAttributes redirectAttributes) {

		signupValidator.validate(userForm, result);

		if (result.hasErrors()) {
			return "/user/signup";
		} else {
			userService.add(userForm.getUsername(), userForm.getPassword());
			redirectAttributes.addFlashAttribute("msg", "Your account has been created successfully!");

			return "redirect:/login";
		}
	}

}
