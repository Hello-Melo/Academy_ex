package com.hoon.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.hoon.stream.domain.Person;

public class StreamMap2 {
	public static void main(String[] args) {
		
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person(1L, "홍길동", 10));
		personList.add(new Person(2L, "Carmelo", 44));
		personList.add(new Person(3L, "르브롱", 22));
		personList.add(new Person(4L, "빡브롱", 16));
		
		 double avg = personList.stream()
		.mapToInt(p -> p.getAge())
		.average().getAsDouble();
		
		 System.out.println(avg);
	}
}
