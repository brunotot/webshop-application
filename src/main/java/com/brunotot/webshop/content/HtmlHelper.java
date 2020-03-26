package com.brunotot.webshop.content;

import java.sql.Connection;
import java.sql.ResultSet;
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
		Connection conn = null;
		ResultSet rs = null;
		try {
			boolean flag = false;
			if (filter == null || filter.length == 0) {
				flag = true;
			} else {
				if (filter[0] == null) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (flag) {
				conn = ((DataSource) Helper.getBeanFromRequest(request, "getDataSource")).getConnection();
				String preparedQuery = "select * from `" + Helper.escapeSql(category) + "`;";
				rs = Helper.getResultSetByPreparedQuery(conn, preparedQuery);
			} else {
				rs = filter[0];
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
		return "fail";
	}
	
	public static String getAllShoppingCartItems(HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) Helper.getBeanFromRequest(request, Constants.BEAN_SHOPPING_CART);
		List<ShoppingCartItem> shoppingCartItems = cart.getItems();
		String result = "";
		
		for (ShoppingCartItem shoppingCartItemObject : shoppingCartItems) {
			Item item = shoppingCartItemObject.getItem();
			result += item.getTableRowElement(shoppingCartItemObject.getCount());
		}
		
		return result;
	}
	
	public static String getItemDiv (int id, String name, int price, String imageUrl, String category) {
		String formattedName = Helper.getFormattedName(name);
		
		String div = "";
		
		div += addLine("<div class='item-wrapper'>");
		div += addLine("<div class='item-content'>");
		div += addLine("<img id='image' src='" + imageUrl + "'>");
		div += addLine("<div class='parent-vertical'><p class='child-vertical-middle'><a href='item?id=" + id + "'>" + formattedName + "</a></p></div>");
		div += addLine("<div class='button-wrapper'>");
		div += addLine("<div class='parent-vertical'><p id='price-paragraph' class='child-vertical-middle'>" + price + " &euro;</p></div>");
		div += addLine("<div><button class='my-button' onclick=\"addItem(" + id + ", '" + category + "')\">" + Constants.ADD_TO_CART + "</button></div>");
		div += addLine("</div>");
		div += addLine("</div>");
		div += addLine("</div>");
		div += addLine("<span class='item-wrapper-padding'></span>");
		
		return div;
	}
	
	public static String getTableRow(int id, String name, int price, String imageUrl, int count, String category, int maxInStock) {
		String tableRow = "";
		
		tableRow += addLine("<tr>");
		tableRow += addLine("<td class='img-table'><img src='" + imageUrl + "'></td>");
		tableRow += addLine("<td class='name-table'><div>" + name + "</div></td>");
		tableRow += addLine("<td class='quantity-table'><input type='number' id='quantity" + id + "' min='0' max='" + maxInStock + "' value='" + count + "'></td>");
		tableRow += addLine("<td class='buttons-table btns'>");
		tableRow += addLine("<div class='buttons-group-table btn-group'>");
		tableRow += addLine("<button type='button' class='my-button' onclick=\"addItem(" + id + ", '" + category + "')\"><i class='fas fa-sync'></i></button>");
		tableRow += addLine("<button type='button' class='my-button' onclick=\"removeItem(" + id + ", '" + category + "')\"><i class='fas fa-times'></i></button>");
		tableRow += addLine("</div>");
		tableRow += addLine("</td>");
		tableRow += addLine("<td class='price-table'>" + (count*price) + "&euro;</td>");
		tableRow += addLine("</tr>");
		
		return tableRow;
	}

	public static String getCheckboxRow(HttpServletRequest request, String category, String element, Map<String, String[]> filteredMap) {
		String tableRow = "";
		
		Map<String, String> map = new HashMap<>();
		try {
			Connection conn = ((DataSource) Helper.getBeanFromRequest(request, "getDataSource")).getConnection();
			String preparedQuery = "select * from `" + Helper.getEscapedQueryVariable(category) + "`;";
			ResultSet rs = Helper.getResultSetByPreparedQuery(conn, preparedQuery);
			while (rs.next()) {
				String elem = rs.getString(element);
				map.put(elem, elem);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		String filterElements = "";
				
		Item item = Helper.getItemInstanceByCategory(category);
		filterElements += item.getFilterElements(request, category, filteredMap);
		
		return filterElements;
	}

	public static String getItemInfo(String id, HttpServletRequest request) {
		String itemInfo = "";
		
		String category = Helper.getCategoryById(id);
		Item item = Helper.getItemInstanceByCategory(category);
		itemInfo += item.getAllItemInformation();
		
		return itemInfo;
	}

	public static String getItemInfoRow(String valueLeft, String valueRight) {
		String itemInfoRow = "";
		
		itemInfoRow += addLine("<tr>");
		itemInfoRow += addLine("<td style='width: 40%; background; grey; padding: 4px;'>" + valueLeft + "</td>");
		itemInfoRow += addLine("<td style='width: 60%; padding: 4px;'>" + valueRight + "</td>");
		itemInfoRow += addLine("</tr>");
		
		return itemInfoRow;
	}
	
}
