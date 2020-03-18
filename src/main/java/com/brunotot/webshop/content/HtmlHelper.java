package com.brunotot.webshop.content;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.brunotot.webshop.merchandise.Laptop;
import com.brunotot.webshop.util.Constants;

@Component
public class HtmlHelper {

	@Autowired
	DataSource dataSource;
	
	private Statement getConnectionStatement() throws SQLException {
		return dataSource.getConnection().createStatement();
	}
	
	private static String addLine(String line) {
		return line + "\n";
	}
	
	public static String test(String category) {
		String result = "";
		try {
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost/shoppolis");
			ds.setUsername("root");
			ds.setPassword("");
			Statement st = ds.getConnection().createStatement();
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
					
					result += addLine(laptop.getDivElement());		
				}
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "fail";
	}
	
	public static String getItemDiv (String name, int price, String imageUrl) {
		String div = "";
		
		div += addLine("<div class='item-wrapper'>");
		div += addLine("<div class='item-content'>");
		div += addLine("<img id='image' src='" + imageUrl + "'>");
		div += addLine("<div class='parent-vertical'><p class='child-vertical-middle'>" + name + "</p></div>");
		div += addLine("<div class='parent-vertical'><p class='child-vertical-middle'>" + price + "&euro;</p></div>");
		div += addLine("<div class='parent-vertical button-wrapper'><button id='submit' class='child-vertical-middle' type='submit'>" + Constants.MORE_INFO + "</button></div>");
		div += addLine("</div>");
		div += addLine("</div>");
		div += addLine("<span class='item-wrapper-padding'></span>");
		
		return div;
	}
	
	public static Laptop getTestLaptop() {
		return new Laptop("Lenovo K120", "Lenovo", "Geforce GTX 720", "AMD FX-7300 6-cores", "8", "256", "1000", "https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/8/a/8ac00es_4.jpg", 1000);
	}
}
