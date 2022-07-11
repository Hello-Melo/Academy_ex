package com.hoon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.hoon.security.MyCustomDetailService;
import com.hoon.security.MyNoopPasswordEncoder;
import com.hoon.security.MySuccessHandler;

@Configuration
public class SecurityBean  {

//<bean id="bCryptPasswordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"/>
//<bean id="myCustomDetailService"  class="com.hoon.security.MyCustomDetailService"></bean>

	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new MySuccessHandler();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyCustomDetailService(); 
	} 
	
	@Bean
	public PasswordEncoder bcrayptPwEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PasswordEncoder noopEncoder() {
		return new  MyNoopPasswordEncoder();
	}
	
}