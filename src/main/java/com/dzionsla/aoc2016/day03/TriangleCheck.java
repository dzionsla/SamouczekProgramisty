package com.dzionsla.aoc2016.day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TriangleCheck {
	
	int counter;
	boolean verticall = true;
	String url = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day03_input.txt";
	
	public TriangleCheck() throws IOException {
		readAsString(url);
		System.out.println("Ilosc dobrych trojkatow: " + counter);
	}
	
	
	public void readAsString(String path) throws IOException {

		if (verticall) {
			List<String> dataList = Files.lines(Paths.get(path), StandardCharsets.UTF_8).collect(Collectors.toList());
			//dataList.forEach(System.out::println);
			for (int i = 0; i < dataList.size(); i = i + 3) {	
				for (int j = 0; j < 3; j++) {
					String st = " ";
					for (int j2 = 0; j2 < 3; j2++) {
						st = st + findValues2(dataList.get(i + j2), j) + " ";
					}
					findValues(st);
				}		
			}

		} else {
			File file = new File(path);   
			BufferedReader br = new BufferedReader(new FileReader(file));
			  
			String st; 
			while ((st = br.readLine()) != null) 
				findValues(st); 
		}
		
	}
	
	public void findValues(String str) {
		Integer[] row = new Integer[3];
		int ctr = 0;
		Pattern p1 = Pattern.compile("\\d+");
		Matcher m1 = p1.matcher(str);
	
		while (m1.find()) {
			row[ctr] = Integer.valueOf(m1.group());
			ctr++;
			//System.out.print(m1.group() + " ");
		}
		
		if (checkTriangle(row)) {
			counter++;
		};
	}
	
	public String findValues2(String str, int i) {
		Pattern p1 = Pattern.compile("\\d+");
		Matcher m1 = p1.matcher(str);
		int ctr = 0;
		while (m1.find()) {
			if (i == ctr) {
				return m1.group();
			}
			ctr++;
		}
		return "lool";
	}
	
	public boolean checkTriangle(Integer[] arr) {
		return (arr[0] + arr[1] > arr[2] && arr[1] + arr[2] > arr[0] && arr[2] + arr[0] > arr[1]);
	}
	
}
