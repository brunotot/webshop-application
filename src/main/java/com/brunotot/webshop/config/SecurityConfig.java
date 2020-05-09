package com.brunotot.webshop.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.brunotot.webshop.service.LoginServiceImpl;
import com.brunotot.webshop.util.Helper;

/**
 * Security configuration class.
 * 
 * @author Bruno
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Autowired datasource connection bean.
	 */
	@Autowired
	DataSource dataSource;

	/**
	 * Autowired login service implementation bean.
	 */
	@Autowired
	LoginServiceImpl loginServiceImpl;

	/**
	 * Autowired global authentication configuration bean.
	 * 
	 * @param auth Authentication builder object
	 * @throws Exception When unable to provide authentication
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginServiceImpl);
		auth.authenticationProvider(authenticationProvider());
	}

	/**
	 * Data access object authentication bean.
	 * 
	 * @return Authentication provider bean
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(loginServiceImpl);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	/**
	 * Password encoder bean.
	 * 
	 * @return BCryptPasswordEncoder object
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Configures access for |ADMIN|USER|ANON| and configures j_spring_security_check on login.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers(Helper.getAntMatchersForAdminRole()).access("hasRole('ROLE_ADMIN')")
			.antMatchers(Helper.getAntMatchersForUserRole()).access("hasRole('ROLE_USER')")
			.antMatchers(Helper.getAntMatchersForAllRoles()).permitAll()
			.and()
			.formLogin().loginProcessingUrl("/j_spring_security_check").loginPage("/login")
			.failureUrl("/login?error=true").usernameParameter("username").passwordParameter("password")
			.and()
			.rememberMe().tokenRepository(persistentTokenRepository()).tokenValiditySeconds(60 * 60)
			.and()
			.exceptionHandling().accessDeniedPage("/accessDenied")
			.and()
			.logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login");
	}

	/**
	 * Token repository bean.
	 * 
	 * @return Persistent token repository database bean
	 */
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}

}