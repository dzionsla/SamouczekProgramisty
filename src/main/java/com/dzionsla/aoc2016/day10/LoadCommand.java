package com.dzionsla.aoc2016.day10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadCommand {
	Pattern PATTERN = Pattern.compile("value (\\d+) goes to bot (\\d+)");
	int value;
	int botID;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getBotID() {
		return botID;
	}

	public void setBotID(int botID) {
		this.botID = botID;
	}

	public LoadCommand(String instruction) {
	    Matcher matcher = PATTERN.matcher(instruction);
	    if (!matcher.matches()) {
	    	throw new IllegalArgumentException(String.format("Instruction [%s] can't be parsed!", instruction));
	    }
	    value = Integer.valueOf(matcher.group(1));
	    botID = Integer.valueOf(matcher.group(2));
	 }
	
	
	
}
