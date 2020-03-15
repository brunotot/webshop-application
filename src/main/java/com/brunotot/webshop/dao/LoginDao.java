package com.brunotot.webshop.dao;

import java.util.List;

import com.brunotot.webshop.model.UserInfo;

public interface LoginDao {

	UserInfo findUserInfo(String username);

	List getUserRoles(String username);
}