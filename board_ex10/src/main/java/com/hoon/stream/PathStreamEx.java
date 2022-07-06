package com.hoon.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathStreamEx {
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("c:/upload");
		Stream<Path> stream = Files.list(path);
		stream.forEach(System.out::println);
		
		List<File> collect = Files.list(path).map(p->p.toFile()).collect(Collectors.toList());
		System.out.println(collect);
		
		
	}
}
