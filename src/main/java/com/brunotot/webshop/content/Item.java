package com.brunotot.webshop.content;

import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface Item {

	void setAllDataFromResultSet(ResultSet rs);

	void setMaxInStock(int stock);

	void setId(int id);

	int getPrice();

	int getId();
	
	String getDivElement();

	String getTableRowElement(int count, boolean inPayment);

	String getCategory();

	String getFullName();
	
	String getFilterElements(HttpServletRequest request, String category, Map<String, String[]> filteredMap);
	
	String getAllItemInformation(HttpServletRequest request);

	String getTableRowElement(PurchasedShoppingCartItem purchasedShoppingCartItemObject);

	String getImageUrl();

}
