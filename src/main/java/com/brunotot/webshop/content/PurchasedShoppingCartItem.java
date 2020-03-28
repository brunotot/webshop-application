package com.brunotot.webshop.content;

import java.sql.Date;

public class PurchasedShoppingCartItem {

	/**
	 * Item id. Can be used to show additional info of the item from the database.
	 */
	private int id;
	
	private int count;
	
	private Date date;
	
	private String name;
	
	private String imageUrl;

	private int price;
	
	public PurchasedShoppingCartItem() {
		
	}
	
	public PurchasedShoppingCartItem(int id, int count, Date date, String name, String imageUrl, int price) {
		super();
		this.id = id;
		this.count = count;
		this.date = date;
		this.name = name;
		this.imageUrl = imageUrl;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public int getCount() {
		return count;
	}

	public Date getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
