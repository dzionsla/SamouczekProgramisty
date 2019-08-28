package com.dzionsla.aoc2016.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssemJava {
	List<String> data = new ArrayList<String>();
	private String dir = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day12_input.txt";
	Map<String, Integer> registers = new HashMap<String, Integer>();
	
	public AssemJava() {
		readDataAsList(dir);
		//data.forEach(n -> System.out.println(n));
		
		loopData();
	}

	private void loopData() {
		for (int i = 0; i < 100; i++) {
			if (i >= (data.size())) {
				break;
			}
			Integer jump = jnz2(data.get(i));
			if (jump != null) {
				i = i + jump;
			}
			if (i >= (data.size())) {
				break;
			}
			copy(data.get(i));
			inc(data.get(i));
			dec(data.get(i));

			//System.out.println(data.get(i));
		}
		
		registers.entrySet().stream()
        .forEach( x -> System.out.println("Key : " + x.getKey() + " Value : " + x.getValue()));
	}
	

	private Boolean copy(String str) {
		Pattern p = Pattern.compile("cpy (\\d+|\\w+) (\\w+)");
		Matcher m = p.matcher(str);

		if (!m.matches()) {
			return false;  
        }
		
		if ( m.group(1).equals("a") || (m.group(1).equals("b")) || (m.group(1).equals("c")) || (m.group(1).equals("d")) ) {
			registers.put(m.group(2), registers.get(m.group(1)));
		} else {
			registers.put(m.group(2), Integer.valueOf(m.group(1)));
		}

		return true;
	}
	
	private Boolean inc(String str) {
		Pattern p = Pattern.compile("inc (\\w+)");
		Matcher m = p.matcher(str);

		if (!m.matches()) {
			return false;  
        }

		registers.put(m.group(1), registers.get(m.group(1)) + 1);

		return true;
	}
	
	private Boolean dec(String str) {
		Pattern p = Pattern.compile("dec (\\w+)");
		Matcher m = p.matcher(str);

		if (!m.matches()) {
			return false;  
        }

		registers.put(m.group(1), registers.get(m.group(1)) - 1);

		return true;
	}
	
	private Integer jnz2(String str) {
		Pattern p = Pattern.compile("jnz (\\d+|\\w+) (-?[1-9]\\d*)");
		Matcher m = p.matcher(str);

		if (!m.matches()) {
			return null;  
        }
		
		if (registers.containsKey(m.group(1))) {
			if (registers.get(m.group(1)) != 0) {
				return Integer.valueOf(m.group(2));
			} else {
				return 0;
			}
		} else {
			return Integer.valueOf(m.group(2));
		}

	}
	
	private Integer jnz1(String str) {
		Pattern p = Pattern.compile("jnz (\\d+|\\w+) (-?[1-9]\\d*)");
		Matcher m = p.matcher(str);

		if (!m.matches()) {
			return null;  
        }
		
		if (registers.containsKey(m.group(1))) {
			if (registers.get(m.group(1)) != 0) {
				return Integer.valueOf(m.group(2));
			} else {
				return 0;
			}
		} else if ( (m.group(1).equals("a") || (m.group(1).equals("b")) || (m.group(1).equals("c")) || (m.group(1).equals("d"))) ){
			System.out.println(m.group(1));
			return 0;
		} else if(m.group(1) != "0"){
			return Integer.valueOf(m.group(2));
		} else {
			return 0;
		}

	}
	
	private void readDataAsList(String path) {
		try {
			data = Files.readAllLines(Paths.get(path));
			//data = Files.lines(Paths.get(path)).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
