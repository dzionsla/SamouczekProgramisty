package com.dzionsla.aoc2016.day06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DecodeNoise {
	String path = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day06_input1.txt";
	List<String> data;
	
	public DecodeNoise() {
		try {
			readData(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data.forEach(System.out::println);
	}
	
	
	public void readData(String path) throws IOException {
		data = Files.lines(Paths.get(path), StandardCharsets.UTF_8).collect(Collectors.toList());
	}
}
