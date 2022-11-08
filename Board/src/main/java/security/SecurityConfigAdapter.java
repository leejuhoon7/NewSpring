package com.yedam.java.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Setter;

@Configuration
@EnableWebSecurity
public class SecurityConfigAdapter  extends WebSecurityConfigurerAdapter{

	@Setter(onMethod_ = {@Autowired})
	DataSource dataSource;
	
	@Bean
	protected CustomLoginSuccessHandler successHandler() {
		System.out.println("==========================");
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	protected PasswordEncoder bcrypt() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/top.jsp").permitAll()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest().authenticated() 
			.and()
			.formLogin().loginPage("/login.jsp")
						.usernameParameter("userId")
						.loginProcessingUrl("/login")
						.successHandler(successHandler())
						.permitAll()
			.and()
			.logout().logoutUrl("/logout")
				     .logoutSuccessUrl("/top.jsp")
			.and()
			.exceptionHandling().accessDeniedPage("/accessDenied.jsp")
			.and()
			.csrf().disable()
			;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		String loginSql = "select LOGIN_ID, PASSWORD, 1 from T_USER where LOGIN_ID = ?";
		String authSql = "select LOGIN_ID, ROLE_NAME from T_ROLE "+ 
				 	  "inner join T_USER_ROLE on T_ROLE.ID = T_USER_ROLE.ROLE_ID "+
				 	  "inner join T_USER on T_USER_ROLE.USER_ID = T_USER.ID "+ 
				 	  "where LOGIN_ID = ?";		
		auth.jdbcAuthentication()
		    .dataSource(dataSource)
		    .usersByUsernameQuery(loginSql)
		    .authoritiesByUsernameQuery(authSql)
		    //.passwordEncoder(bcrypt())
		    ;
	}

	
}
