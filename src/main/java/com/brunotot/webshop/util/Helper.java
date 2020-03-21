package com.brunotot.webshop.util;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.UrlPathHelper;

import com.brunotot.webshop.content.Item;
import com.brunotot.webshop.content.ShoppingCart;
import com.brunotot.webshop.merchandise.Laptop;

/**
 * NOTE: Refactor...
 * 
 * @author Bruno
 *
 */
public class Helper {
	
	public static final String LAPTOP_UNIQUE_IDENTIFIER = "1234";

	public static final String ROOT_DIRECTORY = "../../../../../../../../../../../../";
	
	public static final String JSP_PATH = Helper.ROOT_DIRECTORY + "WEB-INF/jsp/";
	
	public static final int JSP_PATH_DELIMITER = 4;
	
	public static final int COOKIE_EXPIRATION_SECONDS = 30 * 7 * 24 * 60 * 60;
	
	public static ResultSet getTableRowData(Statement st, int id, String dbName) {
		String sql = "select * from " + dbName + ";";
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				if (id == rs.getInt("id")) {
					return rs;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getJspRootPath(HttpServletRequest request) {
		String requestUri = new UrlPathHelper().getRequestUri(request);
		int slashCounter = StringUtils.countOccurrencesOf(requestUri, "/");
		int backwardsIterationCount = slashCounter - Helper.JSP_PATH_DELIMITER;
		
		String jspRootPath = "";
		for(int i = 0; i < backwardsIterationCount; i++) {
			jspRootPath += "../";
		}
		
		return jspRootPath;
	}
	
	public static boolean isUserAuthenticated(HttpServletRequest request) {
		boolean result = false;
		
		if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
			result = true;
		}
		
		return result;
	}
	
	public static String getHeaderPath(HttpServletRequest request) {
		String result = "";
		
		String jspRootPath = Helper.getJspRootPath(request);
		
		if (Helper.isUserAuthenticated(request)) {
			result += jspRootPath + "static/header.jsp"; 
		} else {
			result += jspRootPath + "static/a-header.jsp";
		}
		
		return result;
	}
	
	public static String getFooterPath(HttpServletRequest request) {
		String result = "";
		
		String jspRootPath = Helper.getJspRootPath(request);
		
		result += jspRootPath + "static/footer.jsp";
		
		return result;
	}

	public static Object getBeanFromRequest(HttpServletRequest request, String bean) {
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		return context.getBean(bean);
	}
	
	public static String getFormattedName(String name) {
		String formattedName = "";
		if (name.length() >= Constants.ITEM_NAME_MAX_CHARACTERS) {
			formattedName = name.substring(0, Constants.ITEM_NAME_MAX_CHARACTERS-3) + "...";
		} else {
			formattedName = name;
		}
		return formattedName;
	}

	public static Item getCategoryItemFromTableRowData(String category, ResultSet tableRowData) {
		Item item = null;
		if (category.equals(Constants.TABLE_LAPTOP)) {
			Laptop laptop = Laptop.getInstance();
			laptop.setAllDataFromResultSet(tableRowData);
			item = laptop;
		}
		return item;
	}

}
