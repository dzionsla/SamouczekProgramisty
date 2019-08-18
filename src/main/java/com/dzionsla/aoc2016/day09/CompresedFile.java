package com.dzionsla.aoc2016.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompresedFile {
	String path = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day09_input.txt";
	String data;
	
	
	public CompresedFile() throws IOException {
		data = readAsString(path);
		System.out.println(data);
		findMarker(data);
	}
	public void findMarker(String str) {
		StringBuilder sb = new StringBuilder();
		Pattern p = Pattern.compile("\\(\\w+\\)");
		Matcher m = p.matcher(str);
		
		while (m.find()) {
			System.out.println(m.group() + ": " + findLength(m.group()) + ":"+ findTimes(m.group()) + " (" + m.start() + ":" + m.end() + ")");
		}
	}
	
	public Integer findLength(String str) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(str);
		m.find();
		
		return Integer.valueOf(m.group());
	}
	
	public Integer findTimes(String str) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(str);
		m.find();
		m.find();
		
		return Integer.valueOf(m.group());
	}
	
	public static String readAsString(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path))); 
	}
}
