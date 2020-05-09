package com.brunotot.webshop.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.brunotot.webshop.content.Item;
import com.brunotot.webshop.util.Helper;

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
	 * @return Model for additem panel.
	 */
	@RequestMapping(value = "/additem", method = RequestMethod.GET)
	public ModelAndView addItem() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/add-item");
		return model;
	}

	/**
	 * Maps to shoppolis/admin/additem.
	 * 
	 * @return Post model for additem panel.
	 */
	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public ModelAndView postAddItem(HttpServletRequest request) {
		Map<String, String[]> inputs = request.getParameterMap();
		List<Object> queryVariablesList = new ArrayList<>();
		String category = "";
		boolean flag = true;
		for (Map.Entry<String, String[]> entry : inputs.entrySet()) {
			String[] split = entry.getKey().split("_");
			if (flag) {
				flag = false;
				category = split[0];
			}
			String value = entry.getValue()[0];
			String variableType = split[1];
			Object object = Helper.getFormattedObjectByVariableType(variableType, value);
			queryVariablesList.add(object);
		}
		Object[] queryVariables = queryVariablesList.toArray(new Object[0]);
		try {
			Connection conn = dataSource.getConnection().createStatement().getConnection();
			Item item = Helper.getItemInstanceByCategory(category);
			String preparedQuery = item.getInsertQuery();
			Helper.executePreparedQuery(conn, preparedQuery, queryVariables);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/add-item");
		return model;
	}
	
}
