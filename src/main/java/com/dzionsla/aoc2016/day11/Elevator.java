package com.dzionsla.aoc2016.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Elevator {
	List<String> data = new ArrayList<String>();
	private String dir = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day11_input.txt";
	
	public Elevator() {
		readDataAsList(dir);
		data.forEach(n -> System.out.println(n));
	}
	
	
	
	
	
	
	private void readDataAsList(String path) {
		try {
			data = Files.lines(Paths.get(path)).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
