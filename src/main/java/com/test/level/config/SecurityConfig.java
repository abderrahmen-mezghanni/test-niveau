package com.test.level.config;
//
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled=true)


//extends WebSecurityConfigurerAdapter
public class SecurityConfig {
//@Autowired
//	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
//		auth.jdbcAuthentication()
//			.dataSource(dataSource)
//			.usersByUsernameQuery("select CIN as principal , PASSWORD as credentials , true from user where CIN=?")
//			.authoritiesByUsernameQuery("select USER_CIN as principal , ROLE_ROLE as role from user_role where USER_CIN=?")
//			.rolePrefix("ROLE_");
//			
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.anyRequest()
//					.authenticated()
//						.and()
//			.formLogin()
//				.loginPage("/login")
//				.permitAll()
//			.defaultSuccessUrl("/streams")
//			.failureUrl("/erreur");
//		
//	}
}
