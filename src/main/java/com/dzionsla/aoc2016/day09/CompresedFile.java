package com.dzionsla.aoc2016.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompresedFile {
	String path = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day09_input.txt";
	String data;
	String o = "";
	int q,w,z;
	
	
	public CompresedFile() throws IOException {
		data = readAsString(path);
		System.out.println(data);
		
		System.out.println("Pierwsza czesc:");
		findM1(data);
		System.out.println("Druga czesc:");
		//findM2(data);
	}
	
	public String findM1(String str) {
		String out = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {				
				out = findMarker1(str.substring(i));
				i = i + q + w;
			} else {
				out = String.valueOf(str.charAt(i));
			}
			o = o + out;
		}
		System.out.println(o + "  \n- dlugosc:" + o.length() + "\n\n");
		return o;
	}
	
	public void findM2(String str) {
		String out = str;
		String o = "";
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (out.charAt(i) == '(') {
				
				out = findMarker2(out.substring(i));
				//o = out;
				i = -1;
				len = out.length();
				//out = "";
			} else {
				o = o + String.valueOf(out.charAt(i));
			}
			//System.out.println(out);
		}
		System.out.println(o + "    - dlugosc: " + o.length());
	}
	
	public String findMarker1(String str) {
		String s = str;
		StringBuilder sb = new StringBuilder();
		Pattern p = Pattern.compile("\\(\\w+\\)");
		Matcher m = p.matcher(s);
		
		m.find();
		//System.out.println(m.group() + ": " + findLength(m.group()) + ":"+ findTimes(m.group()) + " (" + m.start() + ":" + m.end() + ")  -  ");
		for (int i = 0; i < findTimes(m.group()); i++) {
			sb.append(s.substring(m.end(), m.end() + findLength(m.group())));
		}
			//s.replace(s.substring(m.start(), m.end()+findLength(m.group())), "");
		q = m.start();
		w = m.end()+findLength(m.group()) - 1;
		
		return sb.toString();
	}
	
	public String findMarker2(String str) {
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
