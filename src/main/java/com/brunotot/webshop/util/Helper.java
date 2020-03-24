package com.brunotot.webshop.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.UrlPathHelper;

import com.brunotot.webshop.content.Item;
import com.brunotot.webshop.content.ShoppingCart;
import com.brunotot.webshop.content.ShoppingCartItem;
import com.brunotot.webshop.merchandise.Laptop;
import com.brunotot.webshop.merchandise.Phone;

public class Helper {
	
	public static ResultSet getResultSetById(Statement st, int id, String dbName) {
		String sql = "select * from `" + Helper.getEscapedQueryVariable(dbName) + "`;";
		try {
			ResultSet rs = Helper.getResultSetByPreparedQuery(st.getConnection(), sql); 
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
		int backwardsIterationCount = slashCounter - Constants.JSP_PATH_DELIMITER;
		
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
			@SuppressWarnings("unchecked")
			Class<Item> clazz = (Class<Item>) Class.forName(Constants.PACKAGE_NAME_MERCHANDISE + classCategoryName);
			item = clazz.getDeclaredConstructor().newInstance();
			item.setAllDataFromResultSet(tableRowData);
			
			String sql = "select * from `" + Helper.getEscapedQueryVariable(category) + "` where id=?";
			ResultSet rs = Helper.getResultSetByPreparedQuery(st.getConnection(), sql, item.getId());
			rs.first();
			int stock = rs.getInt("stock");
			item.setMaxInStock(stock);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public static int getShoppingCartItemCountViaId(int id, HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) Helper.getBeanFromRequest(request, Constants.BEAN_SHOPPING_CART);
		List<ShoppingCartItem> shoppingCartItems = cart.getItems();
		for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
			Item item = shoppingCartItem.getItem();
			/* PROBLEM KADA SE DODAJU LAPTOP I PC U ISTO VRIJEME */
			if (item != null) {
				if (shoppingCartItem.getItem().getId() == id) {
					return shoppingCartItem.getCount();
				}
			}
		}
		return 0;
	}
	

	public static void updateCookies(HttpServletResponse response, String newCookieValue) {
		Cookie cookie = new Cookie(Constants.BEAN_SHOPPING_CART, newCookieValue);
		cookie.setPath("/shoppolis");
		cookie.setMaxAge(Constants.COOKIE_EXPIRATION_SECONDS);
		response.addCookie(cookie);		
	}

	public static String getEscapedQueryVariable(String category) {
		String escapedQueryVariable = "";
		escapedQueryVariable = category.replaceAll("`", "``");
		escapedQueryVariable = category.replaceAll("'", "''");
		return escapedQueryVariable;
	}

	public static Statement getStatement(DataSource dataSource) {
		try {
			return dataSource.getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet getResultSetByPreparedQuery(Connection conn, String preparedQuery, Object... params) throws Exception {
		int variableQuantity = StringUtils.countOccurrencesOf(preparedQuery, "?");
		if (variableQuantity != params.length) {
			throw new Exception("Number of variables (?) does not match number of parameters");
		}
		
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(preparedQuery);
			
			for (int i = 0; i < params.length; i++) {
				Object param = params[i];
				if (param instanceof Integer) {
					stmt.setInt(i + 1, (Integer) param);
				} else if (param instanceof String) {
					stmt.setString(i + 1, (String) param);
				} else {
					stmt.close();
					throw new Exception("Wrong parameter type. Check syntax!");
				}
			}
			return stmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static String escapeSql(String category) {
		if (category == null) {
			return null;
		}
		return category.replaceAll("'", "''");
	}
	
	public static String[] getAntMatchersForUserRole() {
		String[] allowed = new String[3];

		allowed[0] = "/user";
		allowed[1] = "/user/settings";
		allowed[2] = "/user/payment";
		
		return allowed;
	}

	public static String[] getAntMatchersForAdminRole() {
		String[] allowed = new String[1];

		allowed[0] = "/admin";
		
		return allowed;
	}

	public static String[] getAntMatchersForAllRoles() {
		String[] allowed = new String[1];

		allowed[0] = "/";
		
		return allowed;
	}

	public static Item getItemInstanceByCategory(String category) {
		if (category.equals(Constants.TABLE_LAPTOPS)) {
			return new Laptop();
		} else if (category.equals(Constants.TABLE_PHONES)) {
			return new Phone();
		}
		
		return null;
	}
	
	public static int getLowestFromCategory(HttpServletRequest request, String category, String tableColumn) {
		if (tableColumn.equals("ram")) return 4;
		try {
			String preparedQuery = "SELECT MIN(" + tableColumn + ") AS smallestPrice FROM `" + Helper.escapeSql(category) + "`;"; 
			
			DataSource ds = (DataSource) Helper.getBeanFromRequest(request, "getDataSource");
			ResultSet rs = Helper.getResultSetByPreparedQuery(ds.getConnection(), preparedQuery);
			rs.first();
			return rs.getInt("smallestPrice");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int getHighestFromCategory(HttpServletRequest request, String category, String tableColumn) {
		if (tableColumn.equals("ram")) return 32;
		try {
			String preparedQuery = "SELECT MAX(" + tableColumn + ") AS largestPrice FROM `" + Helper.escapeSql(category) + "`;"; 
			
			DataSource ds = (DataSource) Helper.getBeanFromRequest(request, "getDataSource");
			Connection conn = ds.getConnection();
			ResultSet rs = Helper.getResultSetByPreparedQuery(conn, preparedQuery);
			rs.first();
			return rs.getInt("largestPrice");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
