package com.dzionsla.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MissingElement {

	ArrayList<Integer> array = new ArrayList<Integer>();
	
	public MissingElement(int n) {
		generateTable(0, n);
		deleteElement(n);
		findMissing1(array);
		findMissing2(array);
	}
	
	

	private static int generateRandomInt(int upperRange){
	    Random random = new Random();
	    return random.nextInt(upperRange);
	}
	
	private void deleteElement(int n) {
		int idxToDel = generateRandomInt(n+1);
		array.remove(idxToDel);
		Collections.shuffle(array);
		//array.forEach(System.out::println);
		array.forEach(w -> System.out.print("[" + w + "]"));
	}
	
	private void generateTable(int from, int limit) {
		array = Stream.iterate(from, n -> n + 1)
				.limit(limit+1)
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	private int findMissing1(ArrayList<Integer> arr) {
		int missingValue = 0;
		boolean elementFound;
		 
		for (int i = 0; i <= arr.size(); i++) {
			elementFound = false;
			for (int j = 0; j < arr.size(); j++) {
				if (arr.get(j) == i) {
					elementFound = true;
					break;
				}
			}
			
			if (!elementFound) {
				missingValue = i;
				break;
			}
		}

		System.out.println("\nSzukana liczba to: " + missingValue);
		
		return missingValue;
	}
	
	private int findMissing2(ArrayList<Integer> array) {
		
		int sum = Stream.iterate(1, n -> n + 1)
				.limit(array.size())
    			.mapToInt(n -> n)
    			.sum();
		
		int sumArray = array.stream()
				.mapToInt(n -> n)
				.sum();
		
		System.out.println("\nSzukana liczba to: " + (sum - sumArray));
		
		return sum - sumArray;	
	}
	

	
	
}
