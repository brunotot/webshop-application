package com.brunotot.webshop.dao;

import java.util.List;

import com.brunotot.webshop.model.UserInfo;

/**
 * Login data access interface.
 * 
 * @author Bruno
 *
 */
public interface LoginDao {

	/**
	 * Finds user info by username.
	 * 
	 * @param username Client's username
	 * @return User info
	 */
	UserInfo findUserInfo(String username);

	/**
	 * Finds all user roles by Client's username
	 * 
	 * @param username Client's username
	 * @return List of user roles
	 */
	List<String> getUserRoles(String username);
	
}