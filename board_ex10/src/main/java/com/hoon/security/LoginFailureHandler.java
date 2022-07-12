package com.hoon.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class LoginFailureHandler  implements  AuthenticationFailureHandler{
		// 변수위에 value 어노테션을 주면 자동으로 세터주입이 된다. 
	 	// 컴포넌트 방식 쓸때 세터주입이 필요하면 이걸로 쓴다
	@Value("loginId")
	private String loginId;
	
	@Value("loginPw")
	private String loginPw;
	
	@Value("errorMessage")
	private String errorMessage;
	
	@Value("/customLogin")
	private String defaultFailureUrl;
	
	
	@Override
	// 파라미터를각 대응 파라미터로 연결
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		System.out.println("러긴실패");
		String username = request.getParameter(loginId);
		String password = request.getParameter(loginPw);
		String errormsg = request.getParameter(errorMessage);
		
		//메시지 출력은 instaceof(타입이 맞냐 아니냐 체크_
		if(exception instanceof BadCredentialsException) {
			errormsg = "비밀번호가 일치하지 않습니다";
		}
		
		// jsp 처럼 setattribute를 통해 앞은 jsp로 던져줄 표현식 파라미터, 뒤는 뒤에서설정한 이름들
		request.setAttribute(loginId, username);
		request.setAttribute(loginPw, password);
		request.setAttribute(errorMessage, errormsg);
		
		request.getRequestDispatcher(defaultFailureUrl)
					.forward(request, response);
		
	}

}
