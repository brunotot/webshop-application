package com.brunotot.webshop.content;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.brunotot.webshop.util.Constants;
import com.brunotot.webshop.util.Helper;

public class HtmlHelper {
	
	private static String addLine(String line) {
		return line + "\n";
	}
	
	public static String getAllItemsFromCategory(String category, HttpServletRequest request, ResultSet... filter) {
		String result = "";
		ResultSet rs = null;
		String preparedQuery = "select * from `" + Helper.getEscapedQueryVariable(category) + "`;";
		try {
			if (filter == null || filter.length == 0) {
				rs = Helper.executePreparedQuery(((DataSource) Helper.getBeanFromRequest(request, Constants.BEAN_DATA_SOURCE)).getConnection(), preparedQuery);
			} else {
				if (filter[0] == null) {
					rs = Helper.executePreparedQuery(((DataSource) Helper.getBeanFromRequest(request, Constants.BEAN_DATA_SOURCE)).getConnection(), preparedQuery);
				} else {
					rs = filter[0];
				}
			}
			
			if (rs != null) {
				while (rs.next()) {
					Item item = Helper.getItemInstanceByCategory(category);
					item.setAllDataFromResultSet(rs);
					result += HtmlHelper.addLine(item.getDivElement());		
				}
			}

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error";
	}
	
	public static String getAllShoppingCartItems(HttpServletRequest request, boolean inPayment) {
		ShoppingCart cart = (ShoppingCart) Helper.getBeanFromRequest(request, Constants.BEAN_SHOPPING_CART);
		String result = "";

		List<ShoppingCartItem> shoppingCartItems = cart.getItems();
		for (ShoppingCartItem shoppingCartItemObject : shoppingCartItems) {
			Item item = shoppingCartItemObject.getItem();
			result += item.getTableRowElement(shoppingCartItemObject.getCount(), inPayment);
		}
		
		return result;
	}
	
	public static String getItemDiv (int id, String name, int price, String imageUrl, String category) {
		String formattedName = name;
		if (name.length() >= Constants.ITEM_NAME_MAX_CHARACTERS) {
			formattedName = name.substring(0, Constants.ITEM_NAME_MAX_CHARACTERS-3) + "...";
		}
		
		String div = "";
		
		div += addLine("<div class='item-wrapper'>");
		div += addLine("<div class='item-content'>");
		div += addLine("<img id='image' src='" + imageUrl + "'>");
		div += addLine("<div class='parent-vertical'><p class='child-vertical-middle'><a href='item?id=" + id + "'>" + formattedName + "</a></p></div>");
		div += addLine("<div class='button-wrapper'>");
		div += addLine("<div class='parent-vertical'><p id='price-paragraph' class='child-vertical-middle'>" + price + " " + Constants.EURO + "</p></div>");
		div += addLine("<div><button class='my-button' onclick=\"addItem(" + id + ", '" + category + "')\">" + Constants.ADD_TO_CART + "</button></div>");
		div += addLine("</div>");
		div += addLine("</div>");
		div += addLine("</div>");
		div += addLine("<span class='item-wrapper-padding'></span>");
		
		return div;
	}
	
	public static String getTableRow(int id, String name, int price, String imageUrl, int count, String category, int maxInStock, boolean inPayment, Date date) {
		String tableRow = "";
		
		tableRow += addLine("<tr>");
		tableRow += addLine("<td class='img-table'><img src='" + imageUrl + "'></td>");
		tableRow += addLine("<td class='name-table'><div>" + name + "</div></td>");
		tableRow += addLine("<td class='quantity-table'><input type='number' id='quantity" + id + "' min='0' max='" + maxInStock + "' value='" + count + "' " + (inPayment == true ? "disabled" : "") + "></td>");
		tableRow += addLine("<td class='buttons-table btns'>");
		tableRow += addLine("<div class='buttons-group-table btn-group'>");
		if (id != -1) {
			tableRow += addLine("<button type='button' class='my-button' onclick=\"addItem(" + id + ", '" + category + "')\"><i class='fas fa-sync'></i></button>");
			tableRow += addLine("<button type='button' class='my-button' onclick=\"removeItem(" + id + ", '" + category + "')\"><i class='fas fa-times'></i></button>");
		} else {
			tableRow += addLine(date + "");
		}
		tableRow += addLine("</div>");
		tableRow += addLine("</td>");
		tableRow += addLine("<td class='price-table'>" + (count*price) + Constants.EURO + "</td>");
		tableRow += addLine("</tr>");
		
		return tableRow;
	}

	public static String getCheckboxRow(HttpServletRequest request, String category, String element, Map<String, String[]> filteredMap) {
		Map<String, String> map = new HashMap<>();
		ResultSet rs = null;
		try {
			String preparedQuery = "select * from `" + Helper.getEscapedQueryVariable(category) + "`;";
			rs = Helper.executePreparedQuery(((DataSource) Helper.getBeanFromRequest(request, "getDataSource")).getConnection(), preparedQuery);
			while (rs.next()) {
				String elem = rs.getString(element);
				map.put(elem, elem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String tableRow = "";
		tableRow += addLine("<tr>");
		tableRow += addLine("<td id='left-col'>" + Helper.getLeftColName(element) + ":</td>");
		tableRow += addLine("<td id='right-col'>");
		tableRow += addLine("<div class='multiselect'>");
		tableRow += addLine("<div class='selectBox' onclick=\"showCheckboxes('" + element + "')\">");
		tableRow += addLine("<select>");
		tableRow += addLine("<option>" + Helper.getOptionDescription(element) + "</option>");
		tableRow += addLine("</select>");
		tableRow += addLine("<div class='overSelect'></div>");
		tableRow += addLine("</div>");
		tableRow += addLine("<div id='" + element + "'>");
		tableRow += addLine("<div class='checkboxes'>");
		for (Map.Entry<String, String> key : map.entrySet()) {
			String elem = key.getKey();
			
			String checked = "";
			if (filteredMap != null) {
				String[] values = filteredMap.get(element + "~" + elem.toLowerCase());
				if (values != null && values.length > 0) {
					if (values[0].equals("on")) {
						checked = "checked";
					}
				}
			}
			
			tableRow += addLine("<label for='" + elem.toLowerCase() + "'>");
			tableRow += addLine("<input type='checkbox' name='" + element + "~" + elem.toLowerCase() + "' id='" + elem.toLowerCase() + "'" + checked + "/>" + elem + "</label>");
		}
		tableRow += addLine("</div>");
		tableRow += addLine("</div>");
		tableRow += addLine("</div>");
		tableRow += addLine("</td>");
		tableRow += addLine("</tr>");
		
		return tableRow;
	}
	
	public static String getSlider(HttpServletRequest request, String category, String element, String valute, int currentLow, int currentHigh) {
		String tableRow = "";
	
		int low = Helper.getLowestFromCategory(request, category, element);
		int high = Helper.getHighestFromCategory(request, category, element);
		
		if (element.equals("ram")) {
			low = (int) (Math.log(low) / Math.log(2));
			high = (int) (Math.log(high) / Math.log(2));
		}
		
		tableRow += addLine("<tr>");
		tableRow += addLine("<td id='left-col'>" + Helper.getLeftColName(element) + ":</td>");
		tableRow += addLine("<td id='right-col-slider'>");
		tableRow += addLine("<section class='range-slider'>");
		tableRow += addLine("<span class='rangeValues1'></span><span id='valute'>" + valute + "</span>");
		tableRow += addLine("<input value='" + (currentLow == -1 ? low : currentLow) + "' min='" + low + "' max='" + high + "' step='1' type='range' name='" + element + "1" + "'>");
		tableRow += addLine("<input value='" +  (currentHigh == -1 ? high : currentHigh) + "' min='" + low + "' max='" + high + "' step='1' type='range' name='" + element + "2" + "'>");
		tableRow += addLine("<span id='last-span'>" + valute + "</span><span class='rangeValues2'></span>");
		tableRow += addLine("</section>");
		tableRow += addLine("</td>");
		tableRow += addLine("</tr>");
		
		return tableRow;
	}

	public static String getAllFilterElementsFromCategory(HttpServletRequest request, String category, Map<String, String[]> filteredMap) {
		return Helper
				.getItemInstanceByCategory(category)
				.getFilterElements(request, category, filteredMap);
	}

	public static String getItemInfo(String id, HttpServletRequest request) {
		String category = Helper.getCategoryById(id);
		Item item = Helper.getItemInstanceByCategory(category);
		item.setId(Integer.parseInt(id));
		return item.getAllItemInformation(request);
	}

	public static String getAllItemInformation(int id, HttpServletRequest request) {
		String allItemInformation = "";
		ResultSetMetaData rsmd = null;
		ResultSet rs = null;
		try {			
			String preparedQuery = "select * from `" + Constants.TABLE_INFO + "` where id=" + Helper.getEscapedQueryVariable(String.valueOf(id)) + ";";
			rs = Helper.executePreparedQuery(((DataSource) Helper.getBeanFromRequest(request, Constants.BEAN_DATA_SOURCE)).getConnection(), preparedQuery);

			@SuppressWarnings("unchecked")
			Map<String, String> infoColumnValues = (Map<String, String>) Helper.getBeanFromRequest(request, Constants.BEAN_INFO_COLUMN_VALUES);
			
			rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			rs.next();
			for (int i = 2; i < columnsNumber; i++) {
		        String valueRight = rs.getString(i);
		        if (valueRight == null) {
		        	valueRight = "";
		        }
		        
		        String columnName = rsmd.getColumnName(i);
		        String valueLeft = infoColumnValues.get(columnName);
		        allItemInformation += HtmlHelper.getItemInfoRow(valueLeft, valueRight);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return allItemInformation;
	}
	
	public static String getItemInfoRow(String valueLeft, String valueRight) {
		String itemInfoRow = "";
		
		itemInfoRow += addLine("<tr>");
		itemInfoRow += addLine("<td bgcolor='lightgrey' class='left-col-item-info'>" + valueLeft + "</td>");
		itemInfoRow += addLine("<td class='right-col-item-info'>" + valueRight + "</td>");
		itemInfoRow += addLine("</tr>");
		
		return itemInfoRow;
	}
	
	public static String getPurchasedShoppingCartItems(HttpServletRequest request) {
		String username = request.getUserPrincipal().getName();
		PurchasedShoppingCart cart = PurchasedShoppingCart.getInstance(username, request);
		List<PurchasedShoppingCartItem> purchasedShoppingCartItems = cart.getPurchasedItemsList();
		
		String result = "";
		for (PurchasedShoppingCartItem purchasedShoppingCartItemObject : purchasedShoppingCartItems) {
			String category = Helper.getCategoryById(String.valueOf(purchasedShoppingCartItemObject.getId()));
			Item item = Helper.getItemInstanceByCategory(category);
			result += item.getTableRowElement(purchasedShoppingCartItemObject);
		}
		
		return result;
	}

}
