package com.dzionsla.aoc2016.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadData {
	private List<String> data;
	private List<Bot> bots = new ArrayList<Bot>();
	private String dir = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day10_input.txt";
	
	public ReadData() throws IOException {
		readData(dir);	
		data.forEach(n -> System.out.println(n));
		
		readBots();
		bots.forEach(n -> System.out.println(n.toString()));

	}
	
	public List<String> getData() {
		return data;
	}
	
	public boolean isLoad(String instruction) {
		return instruction.startsWith("value");
	}
	
	public boolean isEmit(String instruction) {
		return instruction.startsWith("bot");
	}
	
	public void addBot1(Bot bot) {
		if (containsObjectOfType(bot)) {
			bots.get(bots.indexOf(bot)).consumeData1(bot.getLower());
		} else {
			bots.add(bot);
		}
	}
	
	public void addBot2(Bot bot) {
		if (containsObjectOfType(bot)) {
			bots.get(bots.indexOf(bot)).consumeData2(bot.getIdBotLow(), bot.isLowValueToBot(), bot.getIdBotHigh(), bot.isHighValueToBot());
		} else {
			bots.add(bot);
		}
	}
	
	boolean containsObjectOfType(Bot bot){
		for (int i=0; i < bots.size(); i++){
			if (bots.get(i).equals(bot)){
				return true;
			}
		}
		return false;
	}
	
	public void readBots() {
		for (String instruction : data) {
			if (isLoad(instruction)) {
				LoadCommand lc = new LoadCommand(instruction);
				Bot bot = new Bot(lc.getBotID());
				bot.consumeData1(lc.getValue());
				addBot1(bot);
			}
			else {
				EmitCommand ec = new EmitCommand(instruction);
				Bot bot = new Bot(ec.getBotID());
				bot.setHighValueToBot(ec.isBotHigh());
				bot.setLowValueToBot(ec.isBotLow());
				bot.setIdBotHigh(ec.getValueHigh());
				bot.setIdBotLow(ec.getValueLow());
				addBot2(bot);
			}
		}
	}
	
	public void readData(String dir) throws IOException {
		data = Files.lines(Paths.get(dir)).collect(Collectors.toList()) ;
	}
}
