package com.hoon.stream;

import java.util.Arrays;

public class StreamExample3 {
	public static void main(String[] args) {
		
		String[] arr = {"홍길동", "고길동", "박길동", "침길동"};
		
		java.util.stream.Stream<String> stream = Arrays.stream(arr);
		
		//q배열을 스트림으로 생성
		stream.forEach(System.out::println);
		
		
		
		
		
		
	
		
	}
}
