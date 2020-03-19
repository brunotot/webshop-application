package com.brunotot.webshop.util;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatabaseUtil {
	
	public static DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/shoppolis");
		ds.setUsername("root");
		ds.setPassword("");
	
		return ds;
	}
}
