package com.brunotot.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.brunotot.webshop.dao.UserDao;
import com.brunotot.webshop.model.UserInfo;

@Service
public class UserServiceImpl implements UserService {

	/**
	 * User data access.
	 */
	UserDao userDao;

	/**
	 * Autowired bean for password encoder.
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Autowired method for setting user data access.
	 * 
	 * @param userDao New user data access
	 */
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<?> list() {
		return userDao.list();
	}

	@Override
	public UserInfo findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

	@Override
	public void update(String username, String password) {
		userDao.update(username, passwordEncoder.encode(password));
	}

	@Override
	public void add(String username, String password) {
		userDao.add(username, passwordEncoder.encode(password));
	}

	@Override
	public boolean userExists(String username) {
		return userDao.userExists(username);
	}

}