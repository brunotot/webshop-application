package com.brunotot.webshop.content;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brunotot.webshop.merchandise.Laptop;

@Component
public class HtmlLaptops {

	@Autowired
	DataSource dataSource;
	
	private Statement getConnectionStatement() throws SQLException {
		return dataSource.getConnection().createStatement();
	}
	
	private static String addLine(String line) {
		return line + "\n";
	}
	
	public static Laptop getTestLaptop() {
		return new Laptop("Lenovo K120", "Lenovo", "Geforce GTX 720", "AMD FX-7300 6-cores", "8", "256", "1000", "https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/8/a/8ac00es_4.jpg", "1000euro");
	}
	
	public static String getSingleLaptopDiv(Laptop laptop) {
		String div = "";

		div += addLine("<div class='item-wrapper'>");
		div += addLine("<div class='container item'>");
		div += addLine("<img id='image' src='" + laptop.getImageUrl() + "'>");
		div += addLine("<p>" + laptop.getName() + "</p>");
		div += addLine("<p>" + laptop.getPrice() + "</p>");
		div += addLine("<button id='submitBtn' onclick='window.location.href='http://www.google.hr');>" + "BUTTON" + "</button>");
		div += addLine("</div>");
		div += addLine("</div>");
		
		return div;
	}
}
