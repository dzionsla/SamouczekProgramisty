package com.dzionsla.interview;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileReader {
	static String dataString;
	static List<String> dataList;

	public static List<String> readAsList(String path) throws IOException {
		dataList = Files.lines(Paths.get(path), StandardCharsets.UTF_8).collect(Collectors.toList());
		return dataList;
	}
	
	public static String readAsString(String path) throws IOException {
		dataString = new String(Files.readAllBytes(Paths.get(path)));
		return dataString; 
	}
	
	public static int readLastValue() {
		String lastString = dataList.get(dataList.size() - 1);
//		String str = dataString;
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(lastString);
//		Matcher matcher2 = pattern.matcher(str);
//		while(matcher2.find()) {
//           
//            System.out.println("found: " + matcher2.group());
//        }
        matcher.find();
        
		return  Integer.parseInt(matcher.group());
	}
	
	
	
	
	
}
