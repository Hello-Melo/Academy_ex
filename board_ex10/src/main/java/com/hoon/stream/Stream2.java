package com.hoon.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Stream2 {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("고길동");
		list.add("길동");
		list.add("펭");
		list.add("스프링링링");
		
		//스트림 생성
		java.util.stream.Stream<String> stream = list.stream();
		//익명 구현 개체를 람다식으로 구현가능
		// Consumer는 하나의 추상메서드를 가짐~(accept)
		
		//파라미터로 람다식 전달
		//파라미터 타입생략가능
		//파라미터 하나이면 소괄호 생략가능
		stream.forEach( e -> {
			System.out.println(e);
			System.out.println("길이 : " + e.length() );
			System.out.println("=================");
			
		});
		
			
		
		// 중괄호 내 코드가 한줄인 경우
		// 중괄호 생략가능 -> 세미콜론은 반드시 생략
		// stream2.forEach( e -> { System.out.println(e) });
		
		list.stream().forEach( e -> System.out.println(e) );
	
		// 메서드 참조
		// 파라미터가 한개일경우 생략가능 쌉가능
		System.out.println("==================");
		System.out.println("메서드 참조");
		System.out.println("==================");
		
		list.stream().forEach(System.out::println);
		
	}
}
