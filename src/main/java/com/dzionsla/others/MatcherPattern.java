package com.dzionsla.others;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherPattern {
	static String text = "Wieczorne akrobacje, mrocz30-409nych nietoperzy sad-90s_adas 333 9456 55  22-234  elodelo.dd@o2.pl";
	static String text1 = "powiedz,ze, jes.tem,  ch.uj ,em";
	static String text2 = "Agata zjad³a osiem ananasóa i ostrygê, a Anita oby³a siê smakiem";
	
	public static void printMatcher() {
		System.out.println(text);
		System.out.println();
		
		// matcher
		//Pattern p1 = Pattern.compile("\\s\\d{2}\\s"); //liczby z okreslona dlugoscia
		//Pattern p1 = Pattern.compile("([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)"); email
		//Pattern p1 = Pattern.compile("[a-zA-Z0-9_.-]+@[a-zA-Z0-9_.-]+");
		//Pattern p1 = Pattern.compile("\\d{2}+-\\d{3}+"); kod pocztowy
		//Pattern p1 = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
		Pattern p1 = Pattern.compile("\\b[aeiou]+\\b");
		Matcher m1 = p1.matcher(text2);
		while (m1.find()) {
			System.out.println(m1.group());
		}
		
		
		//split
//		Pattern p2 = Pattern.compile("\\.");
//		String[] m2 = p2.split(text1);
//		System.out.println(Arrays.toString(m2));
		
		
		
	}
}