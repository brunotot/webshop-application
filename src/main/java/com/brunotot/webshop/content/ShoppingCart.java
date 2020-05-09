package com.brunotot.webshop.content;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Shopping cart class.
 * 
 * @author Bruno
 *
 */
@Component
public class ShoppingCart {
	
	/**
	 * Items of shopping cart.
	 */
	private List<ShoppingCartItem> items;
	
	/**
	 * Shopping cart bean. 
	 * 
	 * @return Instance of the shopping cart
	 */
	@Bean
	public ShoppingCart cart() { 
		ShoppingCart cart = new ShoppingCart();
		cart.setItems(new ArrayList<ShoppingCartItem>());
		return cart;
	}
	
	/**
	 * Getter method for all shopping cart items.
	 * 
	 * @return List of all shopping cart items.
	 */
	public List<ShoppingCartItem> getItems() {
		return this.items;
	}
	
	/**
	 * Setter method for all items.
	 * 
	 * @param items New items
	 */
	private void setItems(ArrayList<ShoppingCartItem> items) {
		this.items = items;
	}

	/**
	 * Removes all items from the list.
	 */
	public void removeAll() { 
		this.items.clear(); 
	}
	
	/**
	 * Removes an item from the list by item id.
	 * 
	 * @param id Item id
	 * @return True if successful removal
	 */
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
	
	/**
	 * Updates items list.
	 * 
	 * @param id Item id
	 * @param count Item quantity
	 * @return True if successful update
	 */
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
	
	/**
	 * Adds new item to the list.
	 * 
	 * @param item New item
	 */
	public void add(ShoppingCartItem item) { 
		this.items.add(item); 
	}
	
	/**
	 * Gets shopping cart item instance by id.
	 * 
	 * @param id Item id
	 * @return ShoppingCartItem object by id if found
	 */
	public ShoppingCartItem getItemById(int id) {
		for (ShoppingCartItem shoppingCartItem : this.getItems()) {
			if (shoppingCartItem.getItem().getId() == id) {
				return shoppingCartItem;
			}
		}
		return null;
	}

	/**
	 * Adds single quantity of an item by id.
	 * 
	 * @param id Item id
	 */
	public void addOne(int id) {
		ShoppingCartItem shoppingCartItem = this.getItemById(id);
		shoppingCartItem.setCount(shoppingCartItem.getCount() + 1);
	}

	/**
	 * Checks if item exists by id.
	 * 
	 * @param id Item id
	 * @return True if exists
	 */
	public boolean exists(int id) {
		for (ShoppingCartItem shoppingCartItem : this.getItems()) {
			if (shoppingCartItem.getItem().getId() == id) {
				return true;
			}
		}
		return false;
	}
}
