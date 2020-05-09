package com.brunotot.webshop.model;

/**
 * User information class.
 * 
 * @author Bruno
 *
 */
public class UserInfo {
	
	/**
	 * Client's username.
	 */
	private String username;
	
	/**
	 * Client's password.
	 */
	private String password;

	/**
	 * Constructor for UserInfo.
	 */
	public UserInfo() {
		super();
	}

	/**
	 * Constructor for UserInfo.
	 * 
	 * @param username New client's username
	 * @param password New client's password
	 */
	public UserInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * Getter method for client's username.
	 * 
	 * @return Client's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter method for client's username.
	 * 
	 * @param username New client's username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter method for client's password.
	 * 
	 * @return Client's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method for client's password.
	 * 
	 * @param password New client's password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}