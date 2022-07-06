package com.hoon.stream;

import java.util.Arrays;

public class DistinctExample {
	public static void main(String[] args) {
		
		
		String[] test = {"1", "1", "1", "2", "2", "2"};
		//distinct는 중복제거 메서드!
		Arrays.stream(test).distinct().forEach(System.out::println);
		
	}
	
		
}
