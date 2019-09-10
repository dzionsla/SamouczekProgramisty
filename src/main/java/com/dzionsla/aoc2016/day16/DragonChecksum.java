package com.dzionsla.aoc2016.day16;

import java.util.regex.Pattern;

public class DragonChecksum {
	private static String INPUT = "10001110011110000";
	private static String INPUT1 = "111100001010";
	private static Integer LENGTH = 272;
	private static Integer LENGTHv2 =35651584;
	//Pattern PATTERN = Pattern.compile("");
	
	
	public DragonChecksum() {
		//System.out.println(createRandomData(INPUT1));
		
		//System.out.println(dataToDisk(INPUT1));;
		//System.out.println(generateChecksum("0110010111111111"));;
		System.out.println(createChecksum(dataToDisk(INPUT)));;
	}
	
	private String createChecksum(String str) {
		String local = str;
		while (local.length() % 2 == 0) {
			//System.out.println(local);
			local = generateChecksum(local);
		}
		
		return local;
	}
	
	private String generateChecksum(String str) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < str.length(); i=i+2) {
			if (str.substring(i, i + 2).equals("11") || str.substring(i, i + 2).equals("00")) {
				sb.append(1);
			} else {
				sb.append(0);
			}
		}
		
		return sb.toString();
	}
	
	private String dataToDisk(String str) {
		String local = str;
		
		for (int i = 0; ;i++) {
			local = createRandomData(local);
			if (local.length() >= LENGTHv2) {
				return local.substring(0, LENGTHv2);
			}
		}
	}
	
	private Integer binToInt(String str) {
		return Integer.parseInt(str, 2);
	}
	
	private String createRandomData(String str) {
		// ZA WOLNE DLA PART 2
//		StringBuilder sb = new StringBuilder();
//		sb.append(str);
//		System.out.println("Length before: " + sb.length());
//		sb.reverse();
//		for (int i = 0; i < sb.length(); i++) {
//			if (sb.charAt(i) == '1') {
//				sb.replace(i, i + 1, "0");
//			} else {
//				sb.replace(i, i + 1, "1");
//			}
//		}
//		sb.insert(0, 0);
//		sb.insert(0, str);
//		System.out.println("Length after: " + sb.length());
//		return sb.toString();
		
		String local = new StringBuffer(str).reverse().toString();
		 
		local = local.replace('0', 'x');
		local = local.replace('1', '0');
		local = local.replace('x', '1');
		
		return str + '0' + local;
	}
}
