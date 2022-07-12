package com.hoon.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hoon.exception.NotMatchUserIdException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//보통 이곳에는 404, 403, 500 등 대표적 오류들만 모아놓는 다
	// 우리가 만든 클래스를 파라미터로 넣음됨
	@ExceptionHandler(NotMatchUserIdException.class)
	public String notMatchUserId() {
		System.out.println("NotMatchUserIdException 에러 발생요");
		return "member/myPage_error";
	}

}
