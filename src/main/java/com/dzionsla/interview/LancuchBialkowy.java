package com.dzionsla.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class LancuchBialkowy {
	
	public LancuchBialkowy(String path) throws IOException {
		File file = new File(path);   
		BufferedReader br = new BufferedReader(new java.io.FileReader(file));
	    while (true) {
	        String line = br.readLine();
	        if (line == null) {
	            break;
	        }
	        System.out.println(changePossible(line, br.readLine()));
	    }
	}
	
	public boolean changePossible(String se1, String se2) {
		char[] s1 = se1.toCharArray();
	    char[] s2 = se2.toCharArray();
	    Arrays.sort(s1);
	    Arrays.sort(s2);
	    System.out.println(s1);
	    System.out.println(s2);
	    return Arrays.equals(s1, s2);
	}

	
}
