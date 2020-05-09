package com.brunotot.webshop.content;

import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Item interface (Desktop, Laptop, Phone).
 * 
 * @author Bruno
 *
 */
public interface Item {

	/**
	 * Sets all data to item from result set.
	 * 
	 * @param rs Data for item
	 */
	void setAllDataFromResultSet(ResultSet rs);

	/**
	 * Setter method for max in stock.
	 * 
	 * @param stock Stock amount
	 */
	void setMaxInStock(int stock);

	/**
	 * Setter method for item id.
	 * 
	 * @param id Item id
	 */
	void setId(int id);

	/**
	 * Getter method for item price.
	 * 
	 * @return Item price
	 */
	int getPrice();

	/**
	 * Getter method for item id.
	 * 
	 * @return Item id
	 */
	int getId();
	
	/**
	 * Calculates div for specific item.
	 * 
	 * @return Div element for item as HTML string
	 */
	String getDivElement();

	/**
	 * Calculates table row (tr) element of a table for specific item.
	 * 
	 * @param count Quantity of specific item.
	 * @param inPayment indication whether the client is in payment, false by default
	 * @return Table row element as HTML string
	 */
	String getTableRowElement(int count, boolean inPayment);

	/**
	 * Getter method for item category.
	 * 
	 * @return Item category
	 */
	String getCategory();

	/**
	 * Formats item's full name.
	 * 
	 * @return Item's full name
	 */
	String getFullName();
	
	/**
	 * Gets filter elements for specific item.
	 * 
	 * @param request Servlet request
	 * @param category Item's category
	 * @param filteredMap Filtered map
	 * @return Filter elements
	 */
	String getFilterElements(HttpServletRequest request, String category, Map<String, String[]> filteredMap);
	
	/**
	 * Formats all information of the item.
	 * 
	 * @param request Servlet request
	 * @return Formatted information of the item
	 */
	String getAllItemInformation(HttpServletRequest request);

	/**
	 * Formats table row (tr) element of purchased item.
	 * 
	 * @param purchasedShoppingCartItemObject Purchased item
	 * @return Table row (tr) element of purchased item object
	 */
	String getTableRowElement(PurchasedShoppingCartItem purchasedShoppingCartItemObject);

	/**
	 * Getter method for item image URL.
	 * 
	 * @return Item image URL
	 */
	String getImageUrl();

	String getInsertQuery();
	
}
