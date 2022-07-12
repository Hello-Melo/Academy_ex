package com.hoon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@Import(value= {SecurityBean.class})
@ComponentScan("com.hoon.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AuthenticationSuccessHandler loginSuccessHandler;
	
	@Autowired
	UserDetailsService detailsService;
	
	// 똑같은 타입이 2개 있을시, qualifier로 메서드 이름을 설정해주면 알아서 찾아간다.
	@Autowired
	@Qualifier(value = "bcrayptPwEncoder")
	PasswordEncoder encoder;
	
	@Autowired
	AuthenticationFailureHandler failureHandler;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("okeunghoon").password("{noop}1234").roles("MEMBER");
		 */
		
		auth.userDetailsService(detailsService).passwordEncoder(encoder);

	}

	@Autowired
	PersistentTokenRepository persistentTokenRepository;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// webConfig에 filter 가 있어도 여기에도 해줘야한다.
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("utf-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class);
		
		//csrf 로 해당 연결을 금지시키는걸 무시하는것 
		http.csrf().ignoringAntMatchers("/uploadAjaxAction", "/deleteFile", "/replies/**");
		
		// 해당 역할을 가진 룰을 각각의 해당 리크에 연결
		http.authorizeRequests()
				.antMatchers("/security/all").permitAll()
				.antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/security/member").access("hasRole('ROLE_MEMBER')")
		.and()  // 꼭 http 안쓰더라도 이렇게 중간에 and()를 넣어주면 이어서 작성 가능
		             // 예시라서 그렇게 적은듯.
				.formLogin()
				.usernameParameter("loginId")
				.passwordParameter("loginPw")
				.loginPage("/customLogin")
				.loginProcessingUrl("/member/login")
				.successHandler(loginSuccessHandler)
				.failureHandler(failureHandler);
		
		//remember me는 persistanttokenresositonry 타입을 받는 변수. 맨 아래는 유효시간
		http.rememberMe().key("project")
				.tokenRepository(persistentTokenRepository)
				.tokenValiditySeconds(604800);
		
		//로그아웃 메서드. 로그 아웃기 갈 주소 입력., 그리고 쿠키에 jssesiionsi 꼭 넣기
		http.logout()
				.logoutUrl("/myLogout")
				.invalidateHttpSession(true)
				.deleteCookies("remember-me", "JSESSION_ID");
		
	}
	
}
