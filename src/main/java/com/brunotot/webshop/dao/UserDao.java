package com.brunotot.webshop.dao;

import java.util.List;

import com.brunotot.webshop.model.UserInfo;

public interface UserDao {
 
 public List list();
 
 public UserInfo findUserByUsername(String username);
 
 public void update(String username, String password);
 
 public void add(String username, String password);
 
 public boolean userExists(String username);
 
}