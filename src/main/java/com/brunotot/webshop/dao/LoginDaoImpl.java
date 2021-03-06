package com.brunotot.webshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.brunotot.webshop.model.UserInfo;

/**
 * Login data access repository implementation.
 * 
 * @author Bruno
 *
 */
@Repository
public class LoginDaoImpl implements LoginDao {

	/**
	 * Named parameter jdbc template.
	 */
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * Setter method for parameter jdbc template bean.
	 * 
	 * @param namedParameterJdbcTemplate New named parameter jdbc template
	 */
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


	@Override
	public UserInfo findUserInfo(String username) {
		String sql = "select username,password from users where username = :username";
		UserInfo userInfo = null;
		try {
			userInfo = (UserInfo) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterSource(username, ""), new UserInfoMapper());
		} catch (Exception e) {
			System.err.println("Username not found!");
		}

		return userInfo;
	}

	/**
	 * User info mapper class.
	 * 
	 * @author Bruno
	 *
	 */
	private static final class UserInfoMapper implements RowMapper<Object> {
		
		@Override
		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			String username = rs.getString("username");
			String password = rs.getString("password");
			return new UserInfo(username, password);
		}
		
	}

	/**
	 * Private getter method for SQL source parameter.
	 * 
	 * @param username Client's username
	 * @param password Client's password
	 * @return SQL source parameter
	 */
	private SqlParameterSource getSqlParameterSource(String username, String password) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("username", username);
		parameterSource.addValue("password", password);
		return parameterSource;
	}

	@Override
	public List<String> getUserRoles(String username) {
		String sql = "select role from user_roles where username = :username";
		List<String> roles = namedParameterJdbcTemplate.queryForList(sql, getSqlParameterSource(username, ""), String.class);
		return roles;
	}

}