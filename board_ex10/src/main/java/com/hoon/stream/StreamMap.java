package com.hoon.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.hoon.stream.domain.Person;

public class StreamMap {
	public static void main(String[] args) {
		
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person(1L, "홍길동", 10));
		personList.add(new Person(2L, "Carmelo", 44));
		personList.add(new Person(3L, "르브롱", 22));
		personList.add(new Person(4L, "빡브롱", 16));
		
		//람다식에서 반환타입이 있는 경우 중괄호 생략
		// 반드시 세미콜론, return 까지 생략해야함
		
		
		List<String> personName = personList.stream()
		// map은 중간연산, 뒤에 더 붙어야함 최종연산이!
		.map( p -> p.getName()+"_2022/07/06"
		).collect(Collectors.toList());
		
		
		List<Integer> personAge =  personList.stream()
		.map(Person::getAge)
		.collect(Collectors.toList());
		System.out.println(personAge);
		
		Long count =  personList.stream()
		.map(Person::getAge)
		.filter(age -> age>=19)
		.count();
		System.out.println(count);
		//.forEach(System.out::println);;
		
		
		
		
	}
}
