package com.brunotot.webshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brunotot.webshop.merchandise.Desktop;
import com.brunotot.webshop.merchandise.Laptop;
import com.brunotot.webshop.merchandise.Phone;

/**
 * Admin controller class.
 * 
 * @author Bruno
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	DataSource dataSource;
	
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

	/**
	 * Maps to shoppolis/admin/additem.
	 * 
	 * @param success True or false whether new item was added successfully
	 * @return Model for additem panel.
	 */
	@RequestMapping(value = "/additem", method = RequestMethod.GET)
	public ModelAndView addItem(@RequestParam(value = "success", defaultValue = "") String success) {
		ModelAndView model = new ModelAndView();
		model.addObject("success", success);
		model.addObject("item", new Laptop());
		model.setViewName("admin/add-item");
		return model;
	}

	/**
	 * Maps to shoppolis/admin/additem.
	 * 
	 * @param request Servlet request
	 * @param laptop Laptop to add
	 * @param bindingResult Binding result
	 * @param model Current model
	 * @param redirectAttributes Redirect attributes
	 * @return Redirection URL
	 */
	@RequestMapping(value = "/addlaptop", method = RequestMethod.POST)
	public String postAddLaptopItem(HttpServletRequest request, @ModelAttribute("laptopitem") Laptop laptop, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		try {
			laptop.insertIntoDatabase(request);
			return "redirect:additem?success=true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:additem?success=false";
	}

	/**
	 * Maps to shoppolis/admin/additem.
	 * 
	 * @param request Servlet request
	 * @param desktop Desktop to add
	 * @param bindingResult Binding result
	 * @param model Current model
	 * @param redirectAttributes Redirect attributes
	 * @return Redirection URL
	 */
	@RequestMapping(value = "/adddesktop", method = RequestMethod.POST)
	public String postAddDesktopItem(HttpServletRequest request, @ModelAttribute("desktopitem") Desktop desktop, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		try {
			desktop.insertIntoDatabase(request);
			return "redirect:additem?success=true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:additem?success=false";
	}

	/**
	 * Maps to shoppolis/admin/additem.
	 * 
	 * @param request Servlet request
	 * @param phone Phone to add
	 * @param bindingResult Binding result
	 * @param model Current model
	 * @param redirectAttributes Redirect attributes
	 * @return Redirection URL
	 */
	@RequestMapping(value = "/addphone", method = RequestMethod.POST)
	public String postAddPhoneItem(HttpServletRequest request, @ModelAttribute("phoneitem") Phone phone, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		try {
			phone.insertIntoDatabase(request);
			return "redirect:additem?success=true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:additem?success=false";
	}
	
}
