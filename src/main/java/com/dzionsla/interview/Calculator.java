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
		// Podejœcie numer I
		this.startValue = startValue;
		
		readValues(data);
		readCommands(data);
		calculate();
		
		// Podejœcie numer II
		
		
		
		
	}
	
	private void calculate() {
		int ctr = 0;
		int sum = 0;
		
		for (String cmd : commands) {
			switch (cmd) {
			case "add":
				if (ctr == 0) {
					sum = add(startValue, values.get(ctr));
				} else {
					sum = add(sum, values.get(ctr));
				}
				break;
			case "subtract":
				if (ctr == 0) {
					sum = subtract(startValue, values.get(ctr));
				} else {
					sum = subtract(sum, values.get(ctr));
				}
				break;
			case "multiply":
				if (ctr == 0) {
					sum = multiply(startValue, values.get(ctr));
				} else {
					sum = multiply(sum, values.get(ctr));
				}
				break;
			case "divide":
				if (ctr == 0) {
					sum = divide(startValue, values.get(ctr));
				} else {
					sum = divide(sum, values.get(ctr));
				}
				break;
			case "apply":
				if (ctr == 0) {
					System.out.println(startValue);
				} else {
					System.out.println(sum);
				}
				break;

			default:
				break;
			}
			
			ctr++;
		}
		
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