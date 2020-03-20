package com.brunotot.webshop.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfiguration {

	DriverManagerDataSource dmds;
	
	public DatabaseConfiguration() {
		this.dmds = new DriverManagerDataSource();
		this.dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		this.dmds.setUrl("jdbc:mysql://localhost/shoppolis");
		this.dmds.setUsername("root");
		this.dmds.setPassword("");
	}
}
