package com.brunotot.webshop.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfiguration {

	@Bean
	public static DataSource getDataSource() {
		DriverManagerDataSource ds = null;
		try {
			Properties properties = new Properties();
			InputStream inputStream = new DatabaseConfiguration()
					.getClass()
					.getClassLoader()
					.getResourceAsStream("application.properties");
			properties.load(inputStream);
			ds = new DriverManagerDataSource();
			
			ds.setDriverClassName(properties.getProperty("jdbcdriverclass"));
			ds.setUrl(properties.getProperty("jdbcurl"));
			ds.setUsername(properties.getProperty("jdbcusername"));
			ds.setPassword(properties.getProperty("jdbcpassword"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
}
