package com.brunotot.webshop.content;

import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface Item {
	
	int getId();
	
	String getDivElement();

	String getTableRowElement(int count);

	String getCategory();
	
	void setAllDataFromResultSet(ResultSet rs);

	void setMaxInStock(int stock);
	
	String getFullName();
	
	String getFilterElements(HttpServletRequest request, String category, Map<String, String[]> filteredMap);

	String[] getParameterNames();
}
