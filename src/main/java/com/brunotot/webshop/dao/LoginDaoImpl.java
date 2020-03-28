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
public class LoginDaoImpl implements LoginDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public UserInfo findUserInfo(String username) {
		String sql = "select username,password from users where username = :username";
		UserInfo userInfo = null;
		try {
			userInfo = (UserInfo) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterSource(username, ""), new UserInfoMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userInfo;
	}

	private static final class UserInfoMapper implements RowMapper<Object> {
		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			String username = rs.getString("username");
			String password = rs.getString("password");
			return new UserInfo(username, password);
		}
	}

	private SqlParameterSource getSqlParameterSource(String username, String password) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("username", username);
		parameterSource.addValue("password", password);
		return parameterSource;
	}

	public List<String> getUserRoles(String username) {
		String sql = "select role from user_roles where username = :username";
		List<String> roles = namedParameterJdbcTemplate.queryForList(sql, getSqlParameterSource(username, ""), String.class);
		return roles;
	}

}