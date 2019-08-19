package com.dzionsla.aoc2016.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompresedFile {
	String path = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day09_input1.txt";
	String data;
	String o = "";
	
	
	public CompresedFile() throws IOException {
		data = readAsString(path);
		System.out.println(data);
		//System.out.println(findMarker(data));
		findM(data);
	}
	
	public void findM(String str) {
		String out = str;
		String o = "";
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (out.charAt(i) == '(') {
				
				out = findMarker(out.substring(i));
				//o = out;
				i = -1;
				len = out.length();
				//out = "";
			} else {
				o = o + String.valueOf(out.charAt(i));
			}
			//System.out.println(out);
		}
		System.out.println(o);
		//System.out.println(out);
	}
	
	public String findMarker1(String str, int j) {
		int temp = j;
		Pattern p = Pattern.compile("\\(\\w+\\)");
		Matcher m = p.matcher(str);
		
		
		
		return str;
	}
	
	public String findMarker(String str) {
		StringBuilder sb = new StringBuilder();

		String out = "";
		Pattern p = Pattern.compile("\\(\\w+\\)");
		Matcher m = p.matcher(str);
		m.find();
		//while (m.find()) {
//			int l = sb.length();
//			Pattern p1 = Pattern.compile("\\)\\(");
//			Matcher m1 = p1.matcher(sb.toString());
//			
//			if (m1.find()) {
//				System.out.println(" ------------------------------- ");
//				for (int i = 0; i < findTimes(m.group()); i++) {
//					sb.append(str.substring(m.end(), m.end() + findLength(m.group())));
//				}
//				System.out.println(sb.toString());
//				sb.delete(0, l);
//				System.out.println(sb.toString());
//			}else {
//				break;
//			}
			//System.out.println(sb.toString() + " 11111111 ");
			for (int i = 0; i < findTimes(m.group()); i++) {
				sb.append(str.substring(m.end(), m.end() + findLength(m.group())));
			}
			//System.out.println(sb.toString());
			//out = sb.toString() + str.substring(m.end() + findLength(m.group()));
			sb.append(str.substring(m.end() + findLength(m.group())));
//
			//System.out.println(sb.toString() + " 12");
			//sb.append(sb.toString());
			//System.out.println(sb.toString() + " 33333333 ");
		//}
		
 //		while (m.find()) {
//			System.out.println(m.group() + ": " + findLength(m.group()) + ":"+ findTimes(m.group()) + " (" + m.start() + ":" + m.end() + ")  -  ");
//			for (int i = 0; i < findTimes(m.group()); i++) {
//				sb.append(str.substring(m.end(), m.end() + findLength(m.group())));
//			}
//			//sb.append(findMarker(sb.toString()));
//			System.out.println(sb.toString());
//		}
		
		return sb.toString();
		
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
