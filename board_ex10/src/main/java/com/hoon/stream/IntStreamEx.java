package com.hoon.stream;

import java.util.stream.IntStream;

public class IntStreamEx {
	public static void main(String[] args) {
		
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println();
		System.out.println("=====================");
		IntStream.rangeClosed(1, 10).forEach(System.out::print);
		
	}
}
