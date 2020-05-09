package com.brunotot.webshop.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Web configuration class.
 * 
 * @author Bruno
 *
 */
@SuppressWarnings("deprecation")
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.brunotot.webshop" })
public class WebConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * Autowired datasource connection bean.
	 */
	@Autowired
	DataSource dataSource;

	/**
	 * Named parameter jdbc template bean.
	 * 
	 * @return Jdbc Template parameter from data source.
	 */
	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	/**
	 * Resource bean for resolving views (jsp files and directories).
	 * 
	 * @return Internal resolver bean
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}