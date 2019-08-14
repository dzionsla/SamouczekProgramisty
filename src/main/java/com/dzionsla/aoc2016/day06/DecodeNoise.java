package com.dzionsla.aoc2016.day06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DecodeNoise {
	// usuwajac Comparator.reverseOrder() w sorting part 2 robimy
	String path = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day06_input.txt";
	List<HashMap<String,Integer>> maps = new ArrayList<HashMap<String,Integer>>();
	List<String> data;
	
	public DecodeNoise() {
		try {
			readData(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		maps.add(new HashMap<String,Integer>());
		maps.add(new HashMap<String,Integer>());
		maps.add(new HashMap<String,Integer>());
		maps.add(new HashMap<String,Integer>());
		maps.add(new HashMap<String,Integer>());
		maps.add(new HashMap<String,Integer>());
		maps.add(new HashMap<String,Integer>());
		maps.add(new HashMap<String,Integer>());
		
		data.forEach(n -> addLettersToMap(n));
		
		//maps.forEach(n -> sortMapByValue(n));
		for (HashMap<String,Integer> map : maps) {
			map = sortMapByValue(map);
			System.out.println(map);
		}
		
		//maps.forEach(n -> System.out.println(n));
	}
	
	public void addLettersToMap(String str) {
		int ctr = 0;
		
		for (char c : str.toCharArray()) {
			if (maps.get(ctr).containsKey(String.valueOf(c))) {
				maps.get(ctr).put(String.valueOf(c), maps.get(ctr).get(String.valueOf(c)) + 1);
			} else {
				maps.get(ctr).put(String.valueOf(c), 1);
			}
			ctr++;
		}
	} 
	
	private HashMap<String, Integer> sortMapByValue(HashMap<String, Integer> m) {
		return m.entrySet()
				  .stream()
				  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				  .collect(Collectors.toMap(
				    Map.Entry::getKey, 
				    Map.Entry::getValue, 
				    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}
	
	public void readData(String path) throws IOException {
		data = Files.lines(Paths.get(path), StandardCharsets.UTF_8).collect(Collectors.toList());
	}
}
