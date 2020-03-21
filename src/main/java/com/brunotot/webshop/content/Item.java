package com.brunotot.webshop.content;

import java.sql.ResultSet;

public interface Item {
	
	int getId();
	
	String getDivElement();

	String getTableRowElement(int count);

	String getCategory();
	
	void setAllDataFromResultSet(ResultSet rs);
	
}
