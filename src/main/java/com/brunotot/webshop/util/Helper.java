package com.brunotot.webshop.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UrlPathHelper;

/**
 * NOTE: Refactor...
 * 
 * @author Bruno
 *
 */
public class Helper {
	
	public static final String LAPTOP_UNIQUE_IDENTIFIER = "1234";
	
	public static final int JSP_PATH_DELIMITER = 4;
	
	public static String getJspRootPath(HttpServletRequest request) {
		String requestUri = new UrlPathHelper().getRequestUri(request);
		int slashCounter = StringUtils.countOccurrencesOf(requestUri, "/");
		int backwardsIterationCount = slashCounter - Helper.JSP_PATH_DELIMITER;
		
		String jspRootPath = "";
		for(int i = 0; i < backwardsIterationCount; i++) {
			jspRootPath += "../";
		}
		
		return jspRootPath;
	}
	
	public static final String ROOT_DIRECTORY = "../../../../../../../../../../../../";
	
	public static final String JSP_PATH = Helper.ROOT_DIRECTORY + "WEB-INF/jsp/";

	public static final int COOKIE_EXPIRATION_SECONDS = 30 * 7 * 24 * 60 * 60;
	
	public static boolean isUserAuthenticated(HttpServletRequest request) {
		boolean result = false;
		
		if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
			result = true;
		}
		
		return result;
	}
	
	public static String getHeaderPath(HttpServletRequest request) {
		String result = "";
		
		String jspRootPath = Helper.getJspRootPath(request);
		
		if (Helper.isUserAuthenticated(request)) {
			result += jspRootPath + "static/header.jsp"; 
		} else {
			result += jspRootPath + "static/a-header.jsp";
		}
		
		return result;
	}
	
	public static String getFooterPath(HttpServletRequest request) {
		String result = "";
		
		String jspRootPath = Helper.getJspRootPath(request);
		
		result += jspRootPath + "static/footer.jsp";
		
		return result;
	}

	public static String getFormattedName(String name) {
		String formattedName = "";
		if (name.length() >= Constants.ITEM_NAME_MAX_CHARACTERS) {
			formattedName = name.substring(0, Constants.ITEM_NAME_MAX_CHARACTERS-3) + "...";
		} else {
			formattedName = name;
		}
		return formattedName;
	}

}
