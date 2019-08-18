package com.dzionsla.aoc2016.day07;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IPv7 {
	private List<String> data;
	String path = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day07_input.txt";
	int counter = 0;


	public IPv7() {
		try {
			readData(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(data.size());
		
		loopData();
		
		
		//data.forEach(n -> System.out.println(getHypernet(n) + "   -   " + getTLS(n)));
	}
	
	public void loopData() {
		int c = 0;
		for (String ip : data) {
			// 1st part
//			if (!checkTLS(getHypernet(ip)) && checkTLS(getTLS(ip))) {
//				counter++;
//			}
			// 2nd part
			System.out.println(ip + " " + c++);
			if (checkSSL(getTLS(ip), getHypernet(ip))) {
				counter++;
				System.out.println(counter);
			}
			System.out.println("--------------------------------------------------------------------------------------------------------");
		}
		System.out.println(counter);
	}
	
	public boolean checkSSL(String withoutBra, String withBra) {
		String localWithBra = "";
		
		System.out.println(withoutBra + " --- " + withBra);
		
		for (int i = 0; i < withBra.length() - 2; i++) {
			if (withBra.charAt(i) == withBra.charAt(i+2) && withBra.charAt(i) != withBra.charAt(i+1) ) {
				localWithBra = withBra.substring(i, i+3);	
				System.out.println(localWithBra + " : " + i);
				if (withoutBra.contains(changeLetters(localWithBra))) {
					System.out.println(localWithBra + "-" + changeLetters(localWithBra));

					return true;
				}
				//break;
			}
		}

		return false;
	}
	
	public String changeLetters(String s) {
		
		StringBuilder sb = new StringBuilder(s); 
        sb.setCharAt(0, s.charAt(1)); 
        sb.setCharAt(2, s.charAt(1)); 
        sb.setCharAt(1, s.charAt(0)); 
        
        return sb.toString(); 
		}
	
	public boolean checkTLS(String str) {
		Pattern p1 = Pattern.compile("(\\w)\\1");
		Matcher m1 = p1.matcher(str);
		
		while(m1.find()) {
			
			if (m1.start() != 0 && m1.end() != str.length()) {
				if ( (str.charAt(m1.start() - 1) == str.charAt(m1.end())) ) {
					//System.out.print(m1.group() + " " + str.charAt(m1.start() - 1) + " " + str.charAt(m1.end()) );
					//System.out.println("ssssssssssssssssssssssssss");
					return true;
				}
			}
		}
		//System.out.println();
		return false;
	}
	
	public String getHypernet(String line) {
		Pattern p1 = Pattern.compile("\\[[a-z]+\\]");
		Matcher m1 = p1.matcher(line);
		String out = "";
		
		while(m1.find()) {
			out = out + m1.group();
		}
		//System.out.println(out);
		
		return out;
	}
	
	public String getTLS(String line) {	
		return line.replaceAll("\\[[a-z]+\\]", "-");
	}
	
	public void readData(String path) throws IOException {
		data = Files.lines(Paths.get(path), StandardCharsets.UTF_8).collect(Collectors.toList());
	}

}
