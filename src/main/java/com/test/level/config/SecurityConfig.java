package com.test.level.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(NoOpPasswordEncoder.getInstance())
			.usersByUsernameQuery("select CIN as principal , password as credentials , true from user where CIN=?")
			.authoritiesByUsernameQuery("select USER_CIN as principal , ROLE_ROLE as role from user_role where USER_CIN=?")
			.rolePrefix("ROLE_");
//		auth.inMemoryAuthentication().withUser("12345").password("{noop}12345").roles("ADMIN");
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.anyRequest()
					.authenticated()
						.and()
			.formLogin()
				.permitAll()
			.defaultSuccessUrl("/streams")
			.failureUrl("/erreur");
		
//		http
//		.authorizeRequests()
//		.antMatchers("*/streams/*").hasRole("ADMIN")
//		.and()
//		.formLogin();
		
		
	}
}
