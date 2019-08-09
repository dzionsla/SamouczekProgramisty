package com.dzionsla.aoc2016.day04;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RoomDecode {
	
	String path = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day04_input1.txt";
	List<String> data = new ArrayList<String>();
	List<String> hash = new ArrayList<String>();
	Integer sum;
	
	public RoomDecode() throws IOException {
		readData(path);
		loopData(data);

		//printData();
	}
	
	public void loopData(List<String> data) {
		int howMany = 0;
		
		for (String code : data) {
			if (checkCode(code)) {
				howMany++;
			}
		}
	}
	
	public boolean checkCode(String code) {
		System.out.print(code + ": ");
		System.out.print(getIdent(code) + " - ");
		System.out.print(getHash(code) + "   :   ");
		System.out.println(getLetters(code));
		
		System.out.println(countLetters(getLetters(code)));
		
		
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
	
	public String getLetters(String line) {
		String output = "";
		Pattern p1 = Pattern.compile("[a-z]+-");
		Matcher m1 = p1.matcher(line);
		
		while (m1.find()) {
			output = output + m1.group();	
		}
		
		output = output.replaceAll("-", "");
		
		return sortString(output);
	}
	
	public String sortString(String str) {
	    return str.chars()
	      .sorted()
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	}
	
	public String countLetters(String str) {
		HashMap<String, Integer> m = new HashMap<String, Integer>();
		
		for (char c : str.toCharArray()) {
			if (m.containsKey(String.valueOf(c))) {
				m.put(String.valueOf(c), m.get(String.valueOf(c)) + 1);
			} else {
				m.put(String.valueOf(c), 1);
			}
		}
		
		for (int i = 0; i < 6; i++) {
			
		}
		m.entrySet().forEach(n -> System.out.print(n));
		//m = sortMap(m);
		//System.out.println(m);
		
		//System.out.println(sortMap(m));
		
		return "";
	}
	
	private HashMap<String, Integer> sortMap(HashMap<String, Integer> map) {
		return map.entrySet()
				  .stream()
				  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				  .collect(Collectors.toMap(
				    Map.Entry::getKey, 
				    Map.Entry::getValue, 
				    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}
	
	public void readData(String path) throws IOException {
		data = Files.lines(Paths.get(path), StandardCharsets.UTF_8).collect(Collectors.toList());
	}
	
	public void printData() {
		data.forEach(n -> System.out.println(n));
	}
	
}
