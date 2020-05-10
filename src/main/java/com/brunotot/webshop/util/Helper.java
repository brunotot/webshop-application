package com.brunotot.webshop.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.UrlPathHelper;

import com.brunotot.webshop.content.Item;
import com.brunotot.webshop.content.ShoppingCart;
import com.brunotot.webshop.content.ShoppingCartItem;

/**
 * Helper class.
 * 
 * @author Bruno
 *
 */
public class Helper {
	
	/**
	 * Finds result set object by given item id.
	 * 
	 * @param st Statement object
	 * @param id Item id
	 * @param dbName Database name
	 * @return Result set by id.
	 */
	public static ResultSet getResultSetById(Statement st, int id, String dbName) {
		String sql = "select * from `info_" + Helper.getEscapedQueryVariable(dbName) + "`;";
		try {
			ResultSet rs = Helper.executePreparedQuery(st.getConnection(), sql); 
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
	
	/**
	 * Formats JSP root path from request.
	 * 
	 * @param request Servlet request
	 * @return JSP root path
	 */
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
	
	/**
	 * Formats JSP header path from request.
	 * 
	 * @param request Servlet request
	 * @return Header path
	 */
	public static String getHeaderPath(HttpServletRequest request) {
		String jspRootPath = Helper.getJspRootPath(request);
		if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
			return jspRootPath + "static/header.jsp"; 
		} else {
			return jspRootPath + "static/a-header.jsp";
		}
	}
	
	/**
	 * Formats JSP footer path from request.
	 * 
	 * @param request Servlet request
	 * @return Footer path
	 */
	public static String getFooterPath(HttpServletRequest request) {
		return Helper.getJspRootPath(request) + "static/footer.jsp";
	}

	/**
	 * Finds wanted bean from servlet request.
	 * 
	 * @param request Servlet request
	 * @param beanName Bean name
	 * @return Bean from request (beanName) if found
	 */
	public static Object getBeanFromRequest(HttpServletRequest request, String beanName) {
		return WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext())
				.getBean(beanName);
	}
	
	/**
	 * Finds item from given table row data information.
	 * 
	 * @param category Item category
	 * @param tableRowData Table row data information
	 * @param st Statement
	 * @return Category item from table row data
	 */
	public static Item getCategoryItemFromTableRowData(String category, ResultSet tableRowData, Statement st) {
		if (category.equals(Constants.CATEGORY_LAPTOPS)) {
			return Helper.getResultItemByClass(Constants.CLASS_NAME_LAPTOP, category, tableRowData, st);
		} else if (category.equals(Constants.CATEGORY_PHONES)) {
			return Helper.getResultItemByClass(Constants.CLASS_NAME_PHONE, category, tableRowData, st);
		} else if (category.equals(Constants.CATEGORY_DESKTOPS)) {
			return Helper.getResultItemByClass(Constants.CLASS_NAME_DESKTOP, category, tableRowData, st);
		}
		return null;
	}

	/**
	 * Finds item by category class name.
	 * 
	 * @param classCategoryName Class category name
	 * @param category Item category
	 * @param tableRowData Table row data information
	 * @param st Statement
	 * @return Item by class
	 */
	public static Item getResultItemByClass(String classCategoryName, String category, ResultSet tableRowData, Statement st) {
		Item item = null;
		try {
			@SuppressWarnings("unchecked")
			Class<Item> clazz = (Class<Item>) Class.forName(Constants.PACKAGE_NAME_MERCHANDISE + classCategoryName);
			item = clazz.getDeclaredConstructor().newInstance();
			item.setAllDataFromResultSet(tableRowData);
			
			String sql = "select * from `info_" + Helper.getEscapedQueryVariable(category) + "` where id=?";
			ResultSet rs = Helper.executePreparedQuery(st.getConnection(), sql, item.getId());
			if (rs != null) {
				rs.first();
				int stock = rs.getInt("stock");
				item.setStock(stock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}
	
	/**
	 * Finds shopping cart item count from given id.
	 * 
	 * @param id Item id
	 * @param request Servlet request
	 * @return Shopping cart item quantity
	 */
	public static int getShoppingCartItemCountViaId(int id, HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) Helper.getBeanFromRequest(request, Constants.BEAN_SHOPPING_CART);
		List<ShoppingCartItem> shoppingCartItems = cart.getItems();
		for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
			Item item = shoppingCartItem.getItem();
			if (item != null) {
				if (shoppingCartItem.getItem().getId() == id) {
					return shoppingCartItem.getCount();
				}
			}
		}
		return 0;
	}
	
	/**
	 * Updates cart cookies with new value.
	 * 
	 * @param response Servlet response
	 * @param newCookieValue New cookie value
	 */
	public static void updateCookies(HttpServletResponse response, String newCookieValue) {
		Cookie cookie = new Cookie(Constants.BEAN_SHOPPING_CART, newCookieValue);
		cookie.setPath("/shoppolis");
		cookie.setMaxAge(Constants.COOKIE_EXPIRATION_SECONDS);
		response.addCookie(cookie);		
	}

	/**
	 * Escapes ` and '.
	 * 
	 * @param queryVar Query variable
	 * @return Escaped query variable
	 */
	public static String getEscapedQueryVariable(String queryVar) {
		String escapedQueryVariable = "";
		escapedQueryVariable = queryVar.replaceAll("`", "``");
		escapedQueryVariable = queryVar.replaceAll("'", "''");
		return escapedQueryVariable;
	}

	/**
	 * Executes prepared query.
	 * 
	 * @param conn Connection
	 * @param preparedQuery Prepared query
	 * @param params Variable parameters (example: (?,?))
	 * @return Result of prepared query execution
	 * @throws Exception If error occurs.
	 */
	public static ResultSet executePreparedQuery(Connection conn, String preparedQuery, Object... params) throws Exception {
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
				} else if (param instanceof Date) {
					stmt.setDate(i + 1, (Date) param);
				} else if (param instanceof Float) {
					stmt.setFloat(i + 1, (Float) param);
				} else {
					stmt.close();
					throw new Exception("Wrong parameter type. Check syntax!");
				}
				if (i == params.length - 1) {
					stmt.execute();
					stmt.close();
					return null;
				}
			}
			return stmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Finds lowest value from database by category and table column.
	 * 
	 * @param request Servlet request
	 * @param category Item category
	 * @param tableColumn Table column
	 * @return Lowest value from category
	 */
	public static int getLowestFromCategory(HttpServletRequest request, String category, String tableColumn) {
		try {
			String preparedQuery = "SELECT MIN(" + tableColumn + ") AS smallest FROM `info_" + Helper.getEscapedQueryVariable(category) + "`;"; 
			
			ResultSet rs = Helper.executePreparedQuery(((DataSource) Helper.getBeanFromRequest(request, Constants.BEAN_DATA_SOURCE)).getConnection(), preparedQuery);
			rs.next();
			int smallest = rs.getInt("smallest");
			rs.close();
			return smallest;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Finds highest value from database by category and table column.
	 * 
	 * @param request Servlet request
	 * @param category Item category
	 * @param tableColumn Table column
	 * @return Highest value from category
	 */
	public static int getHighestFromCategory(HttpServletRequest request, String category, String tableColumn) {
		try {
			String preparedQuery = "SELECT MAX(" + tableColumn + ") AS largest FROM `info_" + Helper.getEscapedQueryVariable(category) + "`;"; 
			
			ResultSet rs = Helper.executePreparedQuery(((DataSource) Helper.getBeanFromRequest(request, "getDataSource")).getConnection(), preparedQuery);
			rs.next();
			int largest = rs.getInt("largest");
			rs.close();
			return largest;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Finds submit form query from map by category.
	 * 
	 * @param category Item category
	 * @param map Whole map
	 * @return Submit form query as string
	 */
	public static String getSubmitFormQuery(String category, Map<String, String[]> map) {
		String preparedQuery = "select * from `info_" + Helper.getEscapedQueryVariable(category) + "` where ";
		Map<String, List<String>> checkboxes = getCheckboxesMap(map);
		String checkboxesConditions = getCheckboxesConditions(checkboxes);
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			String key = entry.getKey();
			if (key.equals("category") || key.contains("~")) {
				continue;
			}

			String[] val = entry.getValue();
			String currentValue = val[0];
			if (NumberUtils.isCreatable(currentValue)) {
				if (key.charAt(key.length() - 1) == '1') {
					if (key.startsWith("ram")) {
						preparedQuery += key.substring(0, key.length() - 1) + ">=" + (int)Math.pow(2, Integer.parseInt(currentValue)) + " AND ";
					} else {
						preparedQuery += key.substring(0, key.length() - 1) + ">=" + currentValue + " AND ";
					}
				} else if (key.charAt(key.length() - 1) == '2') {
					if (key.startsWith("ram")) {
						preparedQuery += key.substring(0, key.length() - 1) + "<=" + (int)Math.pow(2, Integer.parseInt(currentValue)) + " AND ";
					} else {
						preparedQuery += key.substring(0, key.length() - 1) + "<=" + currentValue + " AND ";
					}
				} else {
					preparedQuery += key + "=" + currentValue + " AND ";
				}
			} else {
				preparedQuery += key + "='" + currentValue + "' AND ";
			}
		}
		
		if (checkboxesConditions == "") {
			return preparedQuery.substring(0, preparedQuery.length() - 5);
		} else {
			return preparedQuery + checkboxesConditions;
		}
	}
	
	/**
	 * Finds checkboxes conditions.
	 * 
	 * @param checkboxes All checkboxes
	 * @return Checkboxes conditions
	 */
	private static String getCheckboxesConditions(Map<String, List<String>> checkboxes) {
		String checkboxesConditions = "";
		boolean flagg = false;
		for (Map.Entry<String, List<String>> entry : checkboxes.entrySet()) {
			if (flagg) {
				checkboxesConditions += " AND ";
			}
			checkboxesConditions += "(";
			String key = entry.getKey();
			List<String> val = entry.getValue();
			boolean flag = false;
			for (String sqlVal : val) {
				if (flag) {
					checkboxesConditions += " OR ";
				}
				if (NumberUtils.isCreatable(sqlVal)) {
					checkboxesConditions += key + "=" + sqlVal + " ";
				} else {
					checkboxesConditions += key + "='" + sqlVal + "'";
				}
				flag = true;
			}
			checkboxesConditions += ")";
			flagg = true;
		}
		return checkboxesConditions;
	}

	/**
	 * Finds checkboxes from whole map.
	 * 
	 * @param map Whole map
	 * @return Map of checkboxes
	 */
	public static Map<String, List<String>> getCheckboxesMap(Map<String, String[]> map) {
		Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			String key = entry.getKey();
			if (!key.contains("~")) {
				continue;
			}
			
			String val = entry.getValue()[0];
			
			if (val.equals("on")) {
				String sqlKey = key.substring(0, key.indexOf('~'));
				String sqlValue = key.substring(key.indexOf('~') + 1);
				addCheckbox(resultMap, sqlKey, sqlValue);
			}
		}
		return resultMap;
	}

	/**
	 * Adds new checkbox to map.
	 * 
	 * @param resultMap Map to add new checkbox
	 * @param sqlKey Checkbox key
	 * @param sqlValue Checkbox value
	 */
	public static void addCheckbox(Map<String, List<String>> resultMap, String sqlKey, String sqlValue) {
		List<String> getVal = resultMap.get(sqlKey);
		if (getVal != null) {
			getVal.add(sqlValue);
			resultMap.put(sqlKey, getVal);
		} else {
			List<String> listVal = new ArrayList<String>();
			listVal.add(sqlValue);
			resultMap.put(sqlKey, listVal);
		}
	}

	/**
	 * Finds category by id.
	 * 
	 * @param id Item id
	 * @return Category by id
	 */
	public static String getCategoryById(String id) {
		if (id.startsWith(Constants.UNIQUE_IDENTIFIER_LAPTOP)) {
			return Constants.CATEGORY_LAPTOPS;
		} else if (id.startsWith(Constants.UNIQUE_IDENTIFIER_PHONE)) {
			return Constants.CATEGORY_PHONES;
		} else if (id.startsWith(Constants.UNIQUE_IDENTIFIER_DESKTOP)) {
			return Constants.CATEGORY_DESKTOPS;
		}
		return null;
	}

	/**
	 * Checks if given input is marked as mandatory.
	 * 
	 * @param input Input element
	 * @return True if input is mandatory
	 */
	public static boolean isInputRequired(String input) {
		if (input.equals("image") || input.equals("hardDrive") ||
				input.equals("price") || input.equals("stock") ||
				input.equals("ramSize") || input.equals("gpuBrand") ||
				input.equals("gpuType") || input.equals("processorCores") ||
				input.equals("processorBrand") || input.equals("processorType") ||
				input.equals("name") || input.equals("brand")) {
			return true;
		}
			
		
		return false;
	}

	/**
	 * Checks if user is admin.
	 * 
	 * @param request Servlet request
	 * @return True if user is admin
	 */
	public static boolean isUserInRole(HttpServletRequest request) {
		return request.isUserInRole("ROLE_ADMIN");
	}
	
}
