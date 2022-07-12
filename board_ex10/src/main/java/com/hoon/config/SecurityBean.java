package com.hoon.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.hoon.security.LoginFailureHandler;
import com.hoon.security.MyCustomDetailService;
import com.hoon.security.MyNoopPasswordEncoder;
import com.hoon.security.MySuccessHandler;

@Configuration
public class SecurityBean  {

	@Autowired
	DataSource dataSource;
	
//<bean id="bCryptPasswordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"/>
//<bean id="myCustomDetailService"  class="com.hoon.security.MyCustomDetailService"></bean>

	//bean을 줘도 되지만, 각 클래스에 @componenet 어노테이션을 달고 security config에 @componentSacn
	// 어노테이션을 줘서 실행해도 빈으로 인식한다!
	
	
//	  @Bean
//	   public AuthenticationSuccessHandler loginSuccessHandler() {
//	    return new  MySuccessHandler(); }
	
	

//	  @Bean
//	  public UserDetailsService userDetailsService() { 
//		  return new  MyCustomDetailService(); }
	 
	
	@Bean
	public PasswordEncoder bcrayptPwEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PasswordEncoder noopEncoder() {
		return new  MyNoopPasswordEncoder();
	}
	
//	@Bean
//	public AuthenticationFailureHandler failureHandler() {
//		LoginFailureHandler lf = new LoginFailureHandler();
//		lf.setLoginId("loginId");
//		lf.setLoginPw("loginPw");
//		lf.setErrorMessage("errorMessage");
//		lf.setDefaultFailureUrl("/customLogin");
//		return lf;
//	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
}