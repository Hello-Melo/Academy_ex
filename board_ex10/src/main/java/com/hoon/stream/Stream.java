package com.hoon.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Stream {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("고길동");
		list.add("길동");
		list.add("펭");
		list.add("스프링링링");
		
		java.util.stream.Stream<String> stream = list.stream();
		//익명 구현 개체를 람다식으로 구현가능
		// Consumer는 하나의 추상메서드를 가짐~
		
		stream.forEach(new Consumer<String>() {

			//파라미터로 익명개체를 전달함!
			@Override
			public void accept(String e) {
				//이거 실행하면 list에 있는 것들이 순서대로 처리됨
				System.out.println(e);
				System.out.println("길이 : " + e.length() );
				System.out.println("=================");
			}
			
		});
		
	
		
		
	}
}
