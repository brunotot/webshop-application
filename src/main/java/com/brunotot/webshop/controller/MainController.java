package com.brunotot.webshop.controller;

import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

	@Autowired
	DataSource dataSource;
	
	private Statement getConnectionStatement() throws SQLException {
		return dataSource.getConnection().createStatement();
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getUserPrincipal());
		ModelAndView model = new ModelAndView();
		model.setViewName("home/a-home");
		return model;
	}

	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
	public ModelAndView shoppingCart() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home/a-shoppingcart");
		
		String userCredentials = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		if (userCredentials != null && userCredentials != "anonymousUser") {
			model.setViewName("home/shoppingcart");
		}
		
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
		
		String userCredentials = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		if (userCredentials != null && userCredentials == "anonymousUser") {
			model.setViewName("home/a-home");
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
		model.setViewName("home/a-home");
		return model;
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("errors/access_denied");
		return model;
	}
	
	@GetMapping("/user")
	public ModelAndView user() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home/home");
		return model;
	}
}
