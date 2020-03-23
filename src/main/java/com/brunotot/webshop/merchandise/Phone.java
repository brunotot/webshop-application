package com.brunotot.webshop.merchandise;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.brunotot.webshop.content.HtmlHelper;
import com.brunotot.webshop.content.Item;

public class Phone implements Item {
	private int id;
	private String name;
	private String imageUrl;
	private int price;
	private String category = "phones";
	private int maxInStock;
	public Phone() {}
	public Phone(int id, String name, String imageUrl, int price, String category, int maxInStock) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.price = price;
		this.category = category;
		this.maxInStock = maxInStock;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public int getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}
	public int getMaxInStock() {
		return maxInStock;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setMaxInStock(int maxInStock) {
		this.maxInStock = maxInStock;
	}
	
	@Override
	public String getDivElement() {
		return HtmlHelper.getItemDiv(this.getId(), this.getName(), this.getPrice(), this.getImageUrl(), this.category);
	}
	@Override
	public String getTableRowElement(int count) {
		return HtmlHelper.getTableRow(this.getId(), this.getName(), this.getPrice(), this.getImageUrl(), count, this.category, this.maxInStock);
	}
	@Override
	public void setAllDataFromResultSet(ResultSet tableRowData) {
		try {
			this.id = tableRowData.getInt("id");
			this.name = tableRowData.getString("name");
			this.imageUrl = tableRowData.getString("image");
			this.price = tableRowData.getInt("price");
			this.maxInStock = tableRowData.getInt("stock");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
