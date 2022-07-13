package com.hoon.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityTestController {

		@GetMapping("/all")
		public String doAll( @CookieValue(name = "myCookie", required = false)
		String myCookie,  HttpServletRequest request) {
			
			// 아래 코드 써도 되고, 어노테이션 cookievalue 를 써서 해줘도 인식함.
			//cookievalue에 이름은 파라미터변수오 ㅏ똑같이, 리콰이어드는 false해주면 쿠키없이도 접속 가능
//			Cookie[] cookies = request.getCookies();
//			for(Cookie cookie : cookies) {
//				System.out.println("쿠키 이름 : " + cookie.getName());
//				System.out.println("쿠키 값 : " + cookie.getValue());
//			}
			System.out.println(myCookie);
			System.out.println("모든방문자");
			return "member/all";
		}
		
		@GetMapping("/member")
		public String doMember() {
			System.out.println("회원목록");
			return "member/member";
			
		}
		@GetMapping("/admin")
		public String ToAdmin() {
			System.out.println("");
			return "member/admin";
		}
	
		
}
