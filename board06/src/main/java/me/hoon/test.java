package me.hoon;

import java.util.Scanner;

public class test {
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("첫번째 숫자 입력 : >>>");
	int a = scan.nextInt();
	System.out.print("두번째 숫자 입력 : >>>");
	int b = scan.nextInt();
	int sum = 0;

	if(a > b) {
		for(int i = 0 ;  i <= a; i++) {
			if (i % 3 == 0 ) {
				sum = sum + i;
			}
		}
	}
	else if (a<b) {
		for(int i = 0 ;  i <= b; i++) {
			if (i % 3 == 0 ) {
				sum = sum + i;
			}
		}
	}
	
	System.out.println(a + " 에서 " + b +"까지 3의 배수의 합 : " + sum );
	
}
}
