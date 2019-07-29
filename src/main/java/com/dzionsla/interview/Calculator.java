package com.dzionsla.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	private ArrayList<String> commands = new ArrayList<String>();
	private ArrayList<Integer> values = new ArrayList<Integer>();
	private List<String> data;
	int startValue;
	
	public Calculator(int startValue, List<String> data) {
		this.startValue = startValue;
		//this.data = data;
		readValues(data);
		//System.out.println();
		readCommands(data);
		
	}
	
	private void calculate() {
		
	}
	
	private void readValues(List<String> data) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher;
		
		for (String line : data) {
			matcher = pattern.matcher(line);
			if (matcher.find()) {
				values.add(Integer.parseInt(matcher.group()));
			}
		}
		//values.forEach(s -> System.out.print(s + " "));
	}
	
	private void readCommands(List<String> data) {
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher;
		
		for (String line : data) {
			matcher = pattern.matcher(line);
			if (matcher.find()) {
				commands.add(matcher.group());
			}
		}
		//commands.forEach(s -> System.out.print(s + " "));
	}
	
	private int add(int a, int b) {
		return a + b;
	}
	
	private int subtract(int a, int b) {
		return a - b;
	}
	
	private int multiply(int a, int b) {
		return a * b;
	}
	
	private int divide(int a, int b) {
		return a / b;
	}
	
	public enum Command {
	    ADD,
	    SUBTRACT,
	    MULTIPLY,
	    DIVIDE,
	    APPLY;
	}

	
}