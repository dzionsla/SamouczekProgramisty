package com.dzionsla.aoc2016.day02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFile {	
	public List<String> readAsList(String path) throws IOException {		
		return Files.lines(Paths.get(path), StandardCharsets.UTF_8).collect(Collectors.toList());
	}
}
