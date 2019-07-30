package com.dzionsla.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class MaszynaLosujaca {
	static List<List<String>> records = new ArrayList<>();
	static HashMap<String, Integer> counts = new HashMap<String, Integer>();
	ArrayList<String> list = new ArrayList<String>();
	
	public MaszynaLosujaca(String path, int winningNumber) throws IOException {
		readCSV(path);
		createMapWithEmails();
		pickRandomWinners(winningNumber);
	}
	
	private void pickRandomWinners(int winningNumber) {
		Random rand = new Random();
		System.out.println(list.size());
		for (int i = 1; i <= winningNumber; i++) {
			int r = rand.nextInt(list.size());
			System.out.println(list.get(r) + " - " + r);;
		}
	}

	private void createMapWithEmails() {
		for (List<String> line : records) {
			for (String string : line) {
				if (findEmail(string)) {
					addToMap(string);
					list.add(string);
				}
			}
		}
		Collections.shuffle(list);
		//counts = sortMap();
	}
	
	private HashMap<String, Integer> sortMap() {
		return counts.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
	}
	
	private boolean findEmail(String str) {
		if (str.contains("@")) {
			return true;
		} else {
			return false;
		}
	}
	
	private void readCSV(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        records.add(Arrays.asList(values));
		    }
		}
		//printRecords();
	}
	
	private void addToMap(String key) {	
		if (counts.containsKey(key)) {
			counts.put(key, counts.get(key) + 1);
			
		} else {
			counts.put(key, 1);
		}
	}
	
	private void printRecords() {
		for (List<String> line : records) {
			for (String string : line) {
				System.out.println(string);
			}
		}
	}
	
	
}
