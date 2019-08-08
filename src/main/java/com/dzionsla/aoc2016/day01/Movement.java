package com.dzionsla.aoc2016.day01;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Movement {
	Orientation orient = new Orientation();
	String input0 = "L2, R3";
	String input1 = "R2, R2, R2, R2";
	String input2 = "R5, L5, R5, R3";
	String in = "R2, L5, L4, L5, R4, R1, L4, R5, R3, R1, L1, L1, R4, L4, L1, R4, L4, R4, L3, R5, R4, R1, R3, L1, L1, R1, L2, R5, L4, L3, R1, L2, L2, R192, L3, R5, R48, R5, L2, R76, R4, R2, R1, L1, L5, L1, R185, L5, L1, R5, L4, R1, R3, L4, L3, R1, L5, R4, L4, R4, R5, L3, L1, L2, L4, L3, L4, R2, R2, L3, L5, R2, R5, L1, R1, L3, L5, L3, R4, L4, R3, L1, R5, L3, R2, R4, R2, L1, R3, L1, L3, L5, R4, R5, R2, R2, L5, L3, L1, L1, L5, L2, L3, R3, R3, L3, L4, L5, R2, L1, R1, R3, R4, L2, R1, L1, R3, R3, L4, L2, R5, R5, L1, R4, L5, L5, R1, L5, R4, R2, L1, L4, R1, L1, L1, L5, R3, R4, L2, R1, R2, R1, R1, R3, L5, R1, R4";
	String input = "R2, L5, L4, L5, R4, R1, L4, R5, R3, R1, L1, L1, R4, L4, L1, R4, L4, R4, L3, R5, "
			+ "R4, R1, R3, L1, L1, R1, L2, R5, L4, L3, R1, L2, L2, R192, L3, R5, R48, R5, L2, R76, "
			+ "R4, R2, R1, L1, L5, L1, R185, L5, L1, R5, L4, R1, R3, L4, L3, R1, L5, R4, L4, R4, "
			+ "R5, L3, L1, L2, L4, L3, L4, R2, R2, L3, L5, R2, R5, L1, R1, L3, L5, L3, R4, L4, "
			+ "R3, L1, R5, L3, R2, R4, R2, L1, R3, L1, L3, L5, R4, R5, R2, R2, L5, L3, L1, L1, "
			+ "L5, L2, L3, R3, R3, L3, L4, L5, R2, L1, R1, R3, R4, L2, R1, L1, R3, R3, L4, L2, "
			+ "R5, R5, L1, R4, L5, L5, R1, L5, R4, R2, L1, L4, R1, L1, L1, L5, R3, R4, L2, R1, "
			+ "R2, R1, R1, R3, L5, R1, R4";
	
	ArrayList<String> list = new ArrayList<String>();
	
	public Movement() {
//		parse(input).forEach(System.out::println);
		
		list = parse(input1);
		calculatePath();
		Orientation.print();
		
	}
	
	private ArrayList<String> parse(String input) {
		return (ArrayList<String>) Stream.of(input.split(","))
				  .map(e -> e.replaceAll("\\s",""))
			      .collect(Collectors.toList());
	}
	
	private void calculatePath() {
		
		for (String dir : list) {
			orient.move(showDirection(dir), showValue(dir));
		}
	}
	
	private String showDirection(String dir) {
		Pattern p = Pattern.compile("[A-Z]");
		Matcher m = p.matcher(dir);
		m.find();
		//System.out.print(m.group(0));
		return m.group(0);
	}
	
	private int showValue(String dir) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(dir);
		m.find();
		//System.out.print(Integer.valueOf(m.group(0)) + " - ");
		
		return Integer.valueOf(m.group(0));
	}
	
	
}
