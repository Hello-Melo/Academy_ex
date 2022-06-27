package com.hoon.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//객체가 Aspect를 구현한것임을 나타냄
@Aspect
//component는 스프링에서 bean으로 인식하기 위해 component 붙여줌
@Component
public class LogAdvice {
	
	//execution(* com.hoon.service.*.*(..) service 뒤 *은 클래스 , 2번째 *은 함수 (..)은 모든 타입을 의미
	@After("execution(* com.hoon.service.*.doAdd(String, String)) && args(str1, str2)")  // <- 이 코드 내용이 어드바이스,// 조건을 설정해주는게 포인트 컷!
	public void logBefore(String str1, String str2) {
		System.out.println("=======나중에 실행!=======");
		System.out.println("첫 번째 파라미터" + str1);
		System.out.println("첫 번째 파라미터" + str2);
	}
	
	// 즉 jsp에서 쓰던 connector 라던가 하는 설정들을 모두 여기 Advice에 넣어놔서 코드를 간략화 하는것!
	// 이를 AOP 즉 관점지향적 프로그래밍이라고 한다. 
	// 어드바이스는 코드의 내용, 포인트 컷은 코드에 조건을 주는 것을 의미한다.

	@Around("execution(* com.hoon.service.*.doAdd(String, String))")
	public Object logTime(ProceedingJoinPoint joinPoint) {
		System.out.println("시작시간 설정 ");
		long start = System.currentTimeMillis();
		
		Object result = null;
		
			try {
				result = joinPoint.proceed(); //doAdd 호출
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		// 비지니스 로직
		
		System.out.println("도달시간 설정 ");
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (end - start));
		return result;
	}
	
	
	
}
