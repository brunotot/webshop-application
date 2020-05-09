package com.brunotot.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Admin controller class.
 * 
 * @author Bruno
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	/**
	 * Maps to shoppolis/admin/panel.
	 *  
	 * @return Model for admin panel
	 */
	@RequestMapping(value = "/panel", method = RequestMethod.GET)
	public ModelAndView panel() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/panel");
		return model;
	}

	/**
	 * Maps to shoppolis/admin/users.
	 * 
	 * @return Model for user panel.
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView visits() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/users");
		return model;
	}
	
}
