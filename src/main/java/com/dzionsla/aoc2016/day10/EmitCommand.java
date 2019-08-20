package com.dzionsla.aoc2016.day10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmitCommand {
	
	
	public EmitCommand(String instruction) {
		Pattern PATTERN = Pattern.compile("bot (\\d+) gives low to (bot|output) (\\d+) and high to (bot|output) (\\d+)");
        Matcher matcher = PATTERN.matcher(instruction);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("Instruction [%s] can't be parsed!", instruction));
        }
        
    }
	
	
	
}
