package com.dzionsla.aoc2016.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadData {
	private List<String> data;
	private List<String> botGives = new ArrayList<String>();
	private List<Bot> bots = new ArrayList<Bot>();
	private String dir = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day10_input1.txt";
	
	public ReadData() throws IOException {
		readData(dir);	
		data.forEach(n -> System.out.println(n));
		
		readBots();
		bots.forEach(n -> System.out.println(n.toString()));
		botGives.forEach(n -> System.out.println(n));
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
	
	public void addBot(Bot bot) {
		if (containsObjectOfType(bot)) {
			bots.get(bots.indexOf(bot)).consumeData(bot.getLower());
		} else {
			bots.add(bot);
		}
	}
	
	boolean containsObjectOfType(Object o){
		for (int i=0; i < bots.size(); i++){
			if (bots.get(i).getClass().equals(o.getClass())){
				return true;
			}
		}
		return false;
	}
	
	public void readBots() {
		for (String instruction : data) {
			if (isLoad(instruction)) {
				LoadCommand ec = new LoadCommand(instruction);
				Bot bot = new Bot(ec.getBotID());
				bot.consumeData(ec.getValue());
				addBot(bot);
				//bots.add(bot);
				//data.remove(data.indexOf(instruction));
			}
			else {
				botGives.add(instruction);
			}
		}
	}
	
	public void readData(String dir) throws IOException {
		data = Files.lines(Paths.get(dir)).collect(Collectors.toList()) ;
	}
}
