package com.brunotot.webshop.content;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	public ShoppingCart() {}
	
	private List<ShoppingCartItem> items;
	
	//@Bean
	public void setItems() { 
		this.items = new ArrayList<ShoppingCartItem>(); 
	}
	
	public void removeAll() { 
		this.items.clear(); 
	}
	
	public boolean removeOne(ShoppingCartItem item) {
		for (ShoppingCartItem it : this.items) {
			if (it.equals(item)) {
				this.items.remove(item);
				return true;
			}
		}
		return false;
	}
	
	public boolean update(ShoppingCartItem item, int count) {
		for (int i = 0; i < this.items.size(); i++) {
			ShoppingCartItem it = this.items.get(i);
			if (it.equals(item)) {
				item.setCount(count);
				this.items.remove(item);
				this.items.add(i, item);
				return true;
			}
		}
		return false;
	}
	
	public void add(ShoppingCartItem item) { 
		this.items.add(item); 
	}
	
}
