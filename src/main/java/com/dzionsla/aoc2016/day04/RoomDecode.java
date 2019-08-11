package com.dzionsla.aoc2016.day04;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RoomDecode {
	
	String path = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day04_input.txt";
	List<String> data = new ArrayList<String>();
	List<String> hash = new ArrayList<String>();
	
	public RoomDecode() throws IOException {
		readData(path);
		loopData(data);

		//printData();
	}
	
	public void loopData(List<String> data) {
		for (String code : data) {
			checkCode(code);
		}
	}
	
	public boolean checkCode(String code) {
		System.out.print(code + ": ");
		System.out.print(getIdent(code) + " - ");
		System.out.println(getHash(code));
		
		return false;
	}
	
	public Integer getIdent(String line) {
		Pattern p1 = Pattern.compile("\\d+");
		Matcher m1 = p1.matcher(line);
		m1.find();
		
		return Integer.valueOf(m1.group());
	}
	
	public String getHash(String line) {
		Pattern p1 = Pattern.compile("\\[[a-z]+\\]");
		Matcher m1 = p1.matcher(line);
		m1.find();
		
		return m1.group().substring(1, 6);
	}
	
	public String getHassh(String line) {
		
		
		return "";
	}
	
	
	public void readData(String path) throws IOException {
		data = Files.lines(Paths.get(path), StandardCharsets.UTF_8).collect(Collectors.toList());
	}
	
	public void printData() {
		data.forEach(n -> System.out.println(n));
	}
	
}
