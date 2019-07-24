package com.dzionsla.interview;

import java.math.BigInteger;
import java.util.Scanner;

public class CyclicNumber {
	String inputNumber;
	Scanner inputScanner = new Scanner(System.in);
	
	public CyclicNumber() {
		readFromKeyboard();
		isCycle(inputNumber);
	}
	
	private void readFromKeyboard() {
		//System.out.print("Podaj Liczbe: ");
		//inputNumber = inputScanner.nextLine();
		inputNumber = "016393442622950819672131147540983606557377049180327868852459";
		System.out.println(isCycle(inputNumber));
	}
	
	public Boolean isCycle(String number) {
		int numberLength = number.length();
		String[] permutations = new String[numberLength];
		
		for (int i = 0; i < numberLength; i++) {
			permutations[i] = number.substring(i) +  number.substring(0, i);
		}
		
		BigInteger value = new BigInteger(number);
		String formatString = "%0" + numberLength + "d";
		//Stream.of(permutation).forEach(s -> System.out.println(s));
		outerLoop: for (int i = 1; i <= numberLength; i++) {
			BigInteger localValue = value.multiply(BigInteger.valueOf(i));
			String formattedResult = String.format(formatString, localValue);
			for (String permutation : permutations) {
				if (formattedResult.equals(permutation)) {
					continue outerLoop;
				}
			}
			return false;
		}
		
		return true;
	}
	
	
}
