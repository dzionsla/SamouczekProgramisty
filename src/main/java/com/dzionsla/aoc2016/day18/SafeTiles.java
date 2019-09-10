package com.dzionsla.aoc2016.day18;

public class SafeTiles {
	private static String INPUT = ".^..^....^....^^.^^.^.^^.^.....^.^..^...^^^^^^.^^^^.^.^^^^^^^.^^^^^..^.^^^.^^..^.^^.^....^.^...^^.^.";
	private static String INPUT1 = "..^^.";
	private static String INPUT2 = ".^^.^.^^^^";
	private static int howManyRowsV1 = 40;
	private static int howManyRowsV2 = 400000;
	
	private static int howManySafe = 0;
	
	public SafeTiles() {
		printVault(INPUT);
	}
	
	private void printVault(String str) {
		System.out.println(str);
		String localString = str;
		
		for (int i = 0; i < localString.length(); i++) {
			if (localString.charAt(i) == '.') {
				howManySafe++;
			}
		}
		
		for (int i = 1; i < howManyRowsV2; i++) {
			StringBuilder sbLine = new StringBuilder();
			for (int j = 0; j < localString.length(); j++) {
				StringBuilder sb = new StringBuilder();
				if (j == 0) {
					sb.append('.');
					sb.append(localString.substring(0, 2));
					sbLine.append(checkIfTrap(sb.toString()));
					
				} else if (j == localString.length() - 1) {
					sb.append(localString.substring(localString.length() - 2));
					sb.append('.');
					sbLine.append(checkIfTrap(sb.toString()));
				} else {
					sb.append(localString.substring(j - 1, j + 2));
					sbLine.append(checkIfTrap(sb.toString()));
				}
			}
			localString = sbLine.toString();
			//System.out.println(localString);
//			sbLine.delete(0, sbLine.length());
//			System.out.println(sbLine.toString());
		}
		System.out.println(howManySafe);
	}
	
	private String checkIfTrap(String str) {
		if (str.charAt(0) == '^' && str.charAt(1) == '^' && str.charAt(2) == '.') {
			return "^";
		} else if (str.charAt(0) == '.' && str.charAt(1) == '^' && str.charAt(2) == '^') {
			return "^";
		} else if (str.charAt(0) == '^' && str.charAt(1) == '.' && str.charAt(2) == '.') {
			return "^";
		} else if (str.charAt(0) == '.' && str.charAt(1) == '.' && str.charAt(2) == '^') {
			return "^";
		} else {
			howManySafe++;
			return ".";
		}
	}
	
	
	
	
	
}
