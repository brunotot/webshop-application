package com.brunotot.webshop.service;

import java.util.List;

import com.brunotot.webshop.model.UserInfo;

/**
 * User service interface.
 * 
 * @author Bruno
 *
 */
public interface UserService {

	/**
	 * Getter method for list of users.
	 * 
	 * @return List of users
	 */
	public List<?> list();

	/**
	 * Finds user by username.
	 * 
	 * @param username Client's username
	 * @return UserInfo object if username was found
	 */
	public UserInfo findUserByUsername(String username);

	/**
	 * Updates users.
	 * 
	 * @param username Client's username
	 * @param password Client's password
	 */
	public void update(String username, String password);

	/**
	 * Adds new user.
	 * 
	 * @param username Client's username
	 * @param password Client's password
	 */
	public void add(String username, String password);

	/**
	 * Checks if user exists by their username.
	 * 
	 * @param username Client's username
	 * @return True if user exists
	 */
	public boolean userExists(String username);
	
}