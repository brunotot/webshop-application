package com.brunotot.webshop.content;

/**
 * Shopping cart item class.
 * 
 * @author Bruno
 *
 */
public class ShoppingCartItem {
	
	/**
	 * Shopping cart item.
	 */
	private Item item;
	
	/**
	 * Item quantity.
	 */
	private int count;

	/**
	 * Constructor for shopping cart item.
	 * 
	 * @param item New item
	 * @param count New item quantity
	 */
	public ShoppingCartItem(Item item, int count) {
		super();
		this.item = item;
		this.count = count;
	}
	
	/**
	 * Getter method for item.
	 * 
	 * @return Item
	 */
	public Item getItem() {
		return item;
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
	 * Setter method for item.
	 * 
	 * @param item New item
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * Setter method for item quantity.
	 * 
	 * @param count New quantity
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
}
