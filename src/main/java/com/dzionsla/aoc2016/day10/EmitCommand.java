package com.dzionsla.aoc2016.day10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmitCommand {
	Pattern PATTERN = Pattern.compile("bot (\\d+) gives low to (bot|output) (\\d+) and high to (bot|output) (\\d+)");
	int botID;
	boolean botLow;
	int valueLow;
	boolean botHigh;
	int valueHigh;
	
	
	public EmitCommand(String instruction) {
		
        Matcher matcher = PATTERN.matcher(instruction);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("Instruction [%s] can't be parsed!", instruction));
        }
        
        botID = Integer.valueOf(matcher.group(1));
        
        botLow = isBot(matcher.group(2));
        
        valueLow = Integer.valueOf(matcher.group(3));
        
        botHigh = isBot(matcher.group(4));
        
        valueHigh = Integer.valueOf(matcher.group(5));
    }
	
	public int getBotID() {
		return botID;
	}


	public void setBotID(int botID) {
		this.botID = botID;
	}


	public boolean isBotLow() {
		return botLow;
	}


	public void setBotLow(boolean botLow) {
		this.botLow = botLow;
	}


	public int getValueLow() {
		return valueLow;
	}


	public void setValueLow(int valueLow) {
		this.valueLow = valueLow;
	}


	public boolean isBotHigh() {
		return botHigh;
	}


	public void setBotHigh(boolean botHigh) {
		this.botHigh = botHigh;
	}


	public int getValueHigh() {
		return valueHigh;
	}


	public void setValueHigh(int valueHigh) {
		this.valueHigh = valueHigh;
	}


	public boolean isBot(String str) {
		return str.contains("bot");
	}

	@Override
	public String toString() {
		return "EmitCommand [PATTERN=" + PATTERN + ", botID=" + botID + ", botLow=" + botLow + ", valueLow=" + valueLow
				+ ", botHigh=" + botHigh + ", valueHigh=" + valueHigh + "]";
	}
	
}
