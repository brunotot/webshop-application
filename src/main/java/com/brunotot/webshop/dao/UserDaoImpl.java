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

@Repository
public class UserDaoImpl implements UserDao {

	/**
	 * Named parameter jdbc template.
	 */
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<?> list() {
		String sql = "select username from users";
		List<?> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(null, null), new UserMapper());
		return list;
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
		if (username != null) {
			parameterSource.addValue("username", username);
		}
		if (password != null) {
			parameterSource.addValue("password", password);
		}

		return parameterSource;
	}
	/**
	 * User info mapper class.
	 * 
	 * @author Bruno
	 *
	 */
	private static final class UserMapper implements RowMapper<Object> {
		
		@Override
		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserInfo user = new UserInfo();
			user.setUsername(rs.getString("username"));
			return user;
		}
		
	}

	@Override
	public UserInfo findUserByUsername(String username) {
		String sql = "select username from users where username = :username";
		List<?> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(username, null), new UserMapper());
		UserInfo userInfo = (UserInfo) list.get(0);
		return userInfo;
	}

	@Override
	public void update(String username, String password) {
		String sql = "update users set password = :password where username = :username";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));
	}

	@Override
	public void add(String username, String password) {
		String sql = "insert into users(username, password) values(:username, :password)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));

		sql = "insert into user_roles(username, role) values(:username, 'ROLE_USER')";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(username, password));
	}

	@Override
	public boolean userExists(String username) {
		String sql = "select * from users where username = :username";
		List<?> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(username, null), new UserMapper());
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

}