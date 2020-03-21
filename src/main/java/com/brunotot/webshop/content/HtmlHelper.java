package com.brunotot.webshop.content;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.brunotot.webshop.merchandise.Laptop;
import com.brunotot.webshop.util.Constants;
import com.brunotot.webshop.util.DatabaseUtil;
import com.brunotot.webshop.util.Helper;

@Controller
public class HtmlHelper {
	
	private static String addLine(String line) {
		return line + "\n";
	}
	
	public static HtmlHelper getInstance() {
		return new HtmlHelper();
	}
	
	/**
	 * NEEDS REFACTOR!!!
	 */
	public String test(String category) {
		String result = "";
		try {
			Statement st = DatabaseUtil.getDataSource().getConnection().createStatement();
			String sql = "select * from " + category + ";";
			ResultSet rs = st.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					String name = rs.getString("name");
					int price = rs.getInt("price");
					int id = rs.getInt("id");
					String imageUrl = rs.getString("image");
					String manufacturer = rs.getString("manufacturer");
					String gpu = rs.getString("gpu");
					String cpu = rs.getString("cpu");
					String ram = rs.getString("ram");
					String hdd = rs.getString("hdd");
					String ssd = rs.getString("ssd");
					Laptop laptop = new Laptop(
							id,
							name, 
							manufacturer, 
							gpu, 
							cpu,
							ram, 
							ssd, 
							hdd,
							imageUrl, 
							price);
					
					result += HtmlHelper.addLine(laptop.getDivElement());		
				}
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "fail";
	}
	
	public static String test2(HttpServletRequest request) {
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
	
	public static String getTableRow(int id, String name, int price, String imageUrl, int count, String category) {
		String tableRow = "";
		
		tableRow += addLine("<tr>");
		tableRow += addLine("<td class='img-table'><img src='" + imageUrl + "'></td>");
		tableRow += addLine("<td class='name-table'><div>" + name + "</div></td>");
		tableRow += addLine("<td class='quantity-table'><input type='text' value='" + count + "'></td>");
		tableRow += addLine("<td class='buttons-table btns'>");
		tableRow += addLine("<div class='buttons-group-table btn-group'>");
		tableRow += addLine("<button type='button' class='my-button'><i class='fas fa-sync'></i></button>");
		tableRow += addLine("<button type='button' class='my-button'><i class='fas fa-times'></i></button>");
		tableRow += addLine("</div>");
		tableRow += addLine("</td>");
		tableRow += addLine("<td class='price-table'>" + price + "&euro;</td>");
		tableRow += addLine("</tr>");
		
		return tableRow;
	}
}
