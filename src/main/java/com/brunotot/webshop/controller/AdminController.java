package com.brunotot.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value = "/panel", method = RequestMethod.GET)
	public ModelAndView panel() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/panel");
		return model;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView visits() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/users");
		return model;
	}
	
}
