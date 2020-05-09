package com.brunotot.webshop.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Web initializer class.
 * 
 * @author Bruno
 *
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * AbstractAnnotationConfigDispatcherServletInitializer override.
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	/**
	 * AbstractAnnotationConfigDispatcherServletInitializer override.
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	/**
	 * AbstractAnnotationConfigDispatcherServletInitializer override.
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}