package com.brunotot.webshop.content;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
	
	private List<ShoppingCartItem> items;
	
	@Bean
	public ShoppingCart cart() { 
		ShoppingCart cart = new ShoppingCart();
		cart.setItems(new ArrayList<ShoppingCartItem>());
		return cart;
	}
	
	public List<ShoppingCartItem> getItems() {
		return this.items;
	}
	
	private void setItems(ArrayList<ShoppingCartItem> items) {
		this.items = items;
	}

	public void removeAll() { 
		this.items.clear(); 
	}
	
	public boolean remove(int id) {
		for (ShoppingCartItem it : this.items) {
			Item item = it.getItem();
			if (item.getId() == id) {
				this.items.remove(it);
				return true;
			}
		}
		return false;
	}
	
	public boolean update(int id, int count) {
		for (int i = 0; i < this.items.size(); i++) {
			ShoppingCartItem it = this.items.get(i);
			if (it.getItem().getId() == id) {
				it.setCount(count);
				return true;
			}
		}
		return false;
	}
	
	public void add(ShoppingCartItem item) { 
		this.items.add(item); 
	}
	
	public ShoppingCartItem getItemById(int id) {
		for (ShoppingCartItem shoppingCartItem : this.getItems()) {
			if (shoppingCartItem.getItem().getId() == id) {
				return shoppingCartItem;
			}
		}
		return null;
	}

	public void addOne(int id) {
		ShoppingCartItem shoppingCartItem = this.getItemById(id);
		shoppingCartItem.setCount(shoppingCartItem.getCount() + 1);
	}

	public boolean exists(int id) {
		for (ShoppingCartItem shoppingCartItem : this.getItems()) {
			if (shoppingCartItem.getItem().getId() == id) {
				return true;
			}
		}
		return false;
	}
}
