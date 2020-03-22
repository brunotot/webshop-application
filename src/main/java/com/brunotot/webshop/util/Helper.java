package com.brunotot.webshop.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.UrlPathHelper;

import com.brunotot.webshop.content.Item;
import com.brunotot.webshop.content.ShoppingCart;
import com.brunotot.webshop.content.ShoppingCartItem;
import com.brunotot.webshop.merchandise.Laptop;

public class Helper {
	
	public static final String LAPTOP_UNIQUE_IDENTIFIER = "1234";
	
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
		if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String getHeaderPath(HttpServletRequest request) {
		String jspRootPath = Helper.getJspRootPath(request);
		if (Helper.isUserAuthenticated(request)) {
			return jspRootPath + "static/header.jsp"; 
		} else {
			return jspRootPath + "static/a-header.jsp";
		}
	}
	
	public static String getFooterPath(HttpServletRequest request) {
		return Helper.getJspRootPath(request) + "static/footer.jsp";
	}

	public static Object getBeanFromRequest(HttpServletRequest request, String beanName) {
		return WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext())
				.getBean(beanName);
	}
	
	public static String getFormattedName(String name) {
		if (name.length() >= Constants.ITEM_NAME_MAX_CHARACTERS) {
			return name.substring(0, Constants.ITEM_NAME_MAX_CHARACTERS-3) + "...";
		} else {
			return name;
		}
	}

	public static Item getCategoryItemFromTableRowData(String category, ResultSet tableRowData, Statement st) {
		if (category.equals(Constants.CATEGORY_LAPTOPS)) {
			return Helper.getResultItemByClass(Constants.CLASS_NAME_LAPTOP, category, tableRowData, st);
		}
		return null;
	}

	public static Item getResultItemByClass(String classCategoryName, String category, ResultSet tableRowData, Statement st) {
		Item item = null;
		try {
			Class<Item> clazz = (Class<Item>) Class.forName(Constants.PACKAGE_NAME_MERCHANDISE + classCategoryName);
			item = clazz.getDeclaredConstructor().newInstance();
			item.setAllDataFromResultSet(tableRowData);
			
			ResultSet rs = st.executeQuery("select * from `" + category + "` where id=" + item.getId());
			rs.first();
			int stock = rs.getInt("stock");
			item.setMaxInStock(stock);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public static int getShoppingCartItemCountViaId(int id, HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) Helper.getBeanFromRequest(request, Constants.BEAN_SHOPPING_CART);
		List<ShoppingCartItem> shoppingCartItems = cart.getItems();
		for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
			if (shoppingCartItem.getItem().getId() == id) {
				return shoppingCartItem.getCount();
			}
		}
		return 0;
	}

}
