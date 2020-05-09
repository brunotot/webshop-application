package com.brunotot.webshop.dao;

import java.util.List;

import com.brunotot.webshop.model.UserInfo;

/**
 * User data access class.
 * 
 * @author Bruno
 *
 */
public interface UserDao {
 
	/**
	 * List of users.
	 * 
	 * @return List of users
	 */
	public List<?> list();
 
	/**
	 * Finds user object by their username.
	 * 
	 * @param username Client's username
	 * @return User object based on username
	 */
	public UserInfo findUserByUsername(String username);
 
	/**
	 * Updates users.
	 * 
	 * @param username New client's username
	 * @param password New client's password
	 */
	public void update(String username, String password);
 
	/**
	 * Adds new user.
	 * 
	 * @param username New client username
	 * @param password New client password
	 */
	public void add(String username, String password);
 
	/**
	 * Calculates whether the given username exists in user database.
	 * 
	 * @param username Client's username
	 * @return True if user exists
	 */
	public boolean userExists(String username);
 
}