package com.brunotot.webshop.content;

import java.sql.Date;

/**
 * Purchased shopping cart item class.
 * 
 * @author Bruno
 *
 */
public class PurchasedShoppingCartItem {

	/**
	 * Item id. Can be used to show additional info of the item from the database.
	 */
	private int id;
	
	/**
	 * Quantity of purchased item.
	 */
	private int count;
	
	/**
	 * Date when purchased.
	 */
	private Date date;
	
	/**
	 * Item name.
	 */
	private String name;
	
	/**
	 * Item image URL.
	 */
	private String imageUrl;

	/**
	 * Item price.
	 */
	private int price;
	
	/**
	 * Empty constructor to acquire an instance.
	 */
	public PurchasedShoppingCartItem() {
		
	}
	
	/**
	 * 
	 * @param id Item id
	 * @param count Item count
	 * @param date Item date of purchase
	 * @param name Item name
	 * @param imageUrl Item image URL
	 * @param price Item price
	 */
	public PurchasedShoppingCartItem(int id, int count, Date date, String name, String imageUrl, int price) {
		super();
		this.id = id;
		this.count = count;
		this.date = date;
		this.name = name;
		this.imageUrl = imageUrl;
		this.price = price;
	}

	/**
	 * Getter method for id.
	 * 
	 * @return Item id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter method for item quantity.
	 * 
	 * @return Item quantity
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Getter method for item date of buying.
	 * 
	 * @return Item date of buying.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Getter method for item name.
	 * 
	 * @return Item name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter method for item image URL.
	 * 
	 * @return Item image URL
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Setter method for item id.
	 * 
	 * @param id New item id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Setter method for item count.
	 * 
	 * @param count New item count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Setter method for item date of buying.
	 * 
	 * @param date New item date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Setter for item name.
	 * 
	 * @param name New item name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter method for item image URL.
	 * 
	 * @param imageUrl New item image URL
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * Getter method for item price.
	 * 
	 * @return Item price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Setter method for item price.
	 * 
	 * @param price New item price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
}
