package com.brunotot.webshop.content;

public class ShoppingCartItem {
	
	private Item item;
	
	private int count;

	public ShoppingCartItem(Item item, int count) {
		super();
		this.item = item;
		this.count = count;
	}
	
	public Item getItem() {
		return item;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
}
