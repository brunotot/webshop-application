package com.brunotot.webshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brunotot.webshop.dao.LoginDao;
import com.brunotot.webshop.model.UserInfo;

/**
 * Login service implementation class.
 * 
 * @author Bruno
 *
 */
@Service
public class LoginServiceImpl implements UserDetailsService {

	/**
	 * Login data access.
	 */
	LoginDao loginDao;

	/**
	 * Autowired method for setting login data access bean.
	 *
	 * @param loginDao Login data access bean.
	 */
	@Autowired
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = loginDao.findUserInfo(username);

		if (userInfo == null) {
			throw new UsernameNotFoundException("Username was not found in the database");
		}

		List<String> roles = loginDao.getUserRoles(username);

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

		if (roles != null) {
			for (String role : roles) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}

		UserDetails userDetails = new User(userInfo.getUsername(), userInfo.getPassword(), grantList);
		
		return userDetails;
	}

}