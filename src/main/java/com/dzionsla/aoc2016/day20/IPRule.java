package com.dzionsla.aoc2016.day20;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class IPRule {
	private List<String> data;
	private List<BigInteger> arr;
	private String dir = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day20_input.txt";
	
	public IPRule() {
		readData();
		
		//data.forEach(n -> addToArr(n));

		System.out.println(findFirst());
		//System.out.println(long);
	}
	
	
	private long findFirst() {
		long firstAllowedIp = 0;
        for (String data : data) {
            if (firstAllowedIp < getMax(data)) {
                return firstAllowedIp;
            }
            if (getMax(data) > firstAllowedIp) {
                firstAllowedIp = getMin(data) + 1;
            }
        }
        return firstAllowedIp;
	}
	
	private void addToArr(String str) {
		Pattern p = Pattern.compile("(.+)-(.+)");
		Matcher m = p.matcher(str);
		
		if (!m.matches()) {
	    	throw new IllegalArgumentException(String.format("Instruction [%s] can't be parsed!", str));
	    }
		BigInteger start = new BigInteger(m.group(1));
		BigInteger end = new BigInteger(m.group(2));

	}
	
	private long getMax(String str) {
		Pattern p = Pattern.compile("(.+)-(.+)");
		Matcher m = p.matcher(str);
		
		if (!m.matches()) {
	    	throw new IllegalArgumentException(String.format("Instruction [%s] can't be parsed!", str));
	    }
		long start = Long.parseLong(m.group(2));
		
		return start;
	}
	
	private long getMin(String str) {
		Pattern p = Pattern.compile("(.+)-(.+)");
		Matcher m = p.matcher(str);
		
		if (!m.matches()) {
	    	throw new IllegalArgumentException(String.format("Instruction [%s] can't be parsed!", str));
	    }
		long end = Long.parseLong(m.group(1));
		
		return end;
	}
	
	private void generateTable(BigInteger from, BigInteger limit) {
		BigInteger x;
		x = new BigInteger("4294967295");

		for (BigInteger i = BigInteger.valueOf(0); i.compareTo(x) < 0 ; i = i.add(BigInteger.ONE)) {
			//System.out.println(i);
			if (x.compareTo(i) > 0) {
				System.out.println(i);
			}
		}
	}
	
	private void readData() {
		try {
			data = Files.readAllLines(Paths.get(dir));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
