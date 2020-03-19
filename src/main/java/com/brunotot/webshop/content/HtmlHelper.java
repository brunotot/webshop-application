package com.brunotot.webshop.content;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.brunotot.webshop.merchandise.Laptop;
import com.brunotot.webshop.util.Constants;
import com.brunotot.webshop.util.DatabaseUtil;

public class HtmlHelper {
	
	private static String addLine(String line) {
		return line + "\n";
	}
	
	public static HtmlHelper getInstance() {
		return new HtmlHelper();
	}
	
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
					String imageUrl = rs.getString("image");
					String manufacturer = rs.getString("manufacturer");
					String gpu = rs.getString("gpu");
					String cpu = rs.getString("cpu");
					String ram = rs.getString("ram");
					String hdd = rs.getString("hdd");
					String ssd = rs.getString("ssd");
					Laptop laptop = new Laptop(
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
	
	public static String getItemDiv (String name, int price, String imageUrl) {
		String formattedName = "";
		if (name.length() >= Constants.ITEM_NAME_MAX_CHARACTERS) {
			formattedName = name.substring(0, Constants.ITEM_NAME_MAX_CHARACTERS-3) + "...";
		} else {
			formattedName = name;
		}
		
		String div = "";
		
		div += addLine("<div class='item-wrapper'>");
		div += addLine("<div class='item-content'>");
		div += addLine("<img id='image' src='" + imageUrl + "'>");
		div += addLine("<div class='parent-vertical'><p class='child-vertical-middle'>" + formattedName + "</p></div>");
		div += addLine("<div class='parent-vertical'><p id='price-paragraph' class='child-vertical-middle'>" + price + " &euro;</p></div>");
		div += addLine("<div class='parent-vertical button-wrapper'><button class='child-vertical-middle my-button' type='submit'>" + Constants.ADD_TO_CART + "</button></div>");
		div += addLine("</div>");
		div += addLine("</div>");
		div += addLine("<span class='item-wrapper-padding'></span>");
		
		return div;
	}
}
