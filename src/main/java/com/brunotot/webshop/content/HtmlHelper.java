package com.brunotot.webshop.content;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.brunotot.webshop.util.Constants;
import com.brunotot.webshop.util.Helper;

public class HtmlHelper {
	
	private static String addLine(String line) {
		return line + "\n";
	}
	
	public static String getAllItemsFromCategory(String category, HttpServletRequest request) {
		String result = "";
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ((DataSource) Helper.getBeanFromRequest(request, "getDataSource")).getConnection();
			String preparedQuery = "select * from `" + Helper.escapeSql(category) + "`;";
			rs = Helper.getResultSetByPreparedQuery(conn, preparedQuery);
			
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
		div += addLine("<div class='parent-vertical'><p class='child-vertical-middle'><a href='#'>" + formattedName + "</a></p></div>");
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
	
}
