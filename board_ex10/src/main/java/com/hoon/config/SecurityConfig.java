package com.hoon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@Import(value= {SecurityBean.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AuthenticationSuccessHandler loginSuccessHandler;
	
	@Autowired
	UserDetailsService detailsService;
	
	// 똑같은 타입이 2개 있을시, qualifier로 메서드 이름을 설정해주면 알아서 찾아간다.
	@Autowired
	@Qualifier(value = "bcrayptPwEncoder")
	PasswordEncoder encoder;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("okeunghoon").password("{noop}1234").roles("MEMBER");
		 */
		
		auth.userDetailsService(detailsService).passwordEncoder(encoder);

	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/security/all").permitAll()
				.antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");
		
		http.formLogin()
				.usernameParameter("loginId")
				.passwordParameter("loginPw")
				.loginPage("/customLogin")
				.loginProcessingUrl("/member/login")
				.successHandler(loginSuccessHandler);
		
		http.logout()
				.logoutUrl("/myLogout")
				.invalidateHttpSession(true)
				.deleteCookies("remember-me", "JSESSION_ID");
		
	}
	
}
