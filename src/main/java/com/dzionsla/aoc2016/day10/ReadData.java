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
	private Integer bin0, bin1, bin2;
	
	public ReadData() throws IOException {
		readData(dir);	
		//data.forEach(n -> System.out.println(n));
		
		readBots();
		//bots.forEach(n -> System.out.println(n.toString()));
		for (int i = 0; i < 25; i++) {
			runSequence();
		}
		
		
	}

	public List<String> getData() {
		return data;
	}
	
	private void runSequence() {
		for (Bot bot : bots) {
			if (findBothValues(bot)) {
				// Part 1
//				if (checkBotPart1(bot)) {
//					System.out.println(bot);
//					break;
//				}
				// Part 2
				if (checkBotPart2()) {
					System.out.println( bin0 + "-" + bin1 + "-" + bin2);
					System.out.println("Multiply: " + (bin0*bin1*bin2));
				}
				System.out.println(bot);
				updateWhen2Values(bot);

				
			}
		}
	}
	public Boolean checkBotPart2() {
		return bin0 != null && bin1 != null && bin2 != null;
	}
	
	public Boolean checkBotPart1(Bot bot) {
		return bot.getHigher().equals(61) && bot.getLower().equals(17);
	}
	
	public void updateWhen2Values(Bot bot) {
		Bot localBot = bots.get(bots.indexOf(bot));
		Boolean lowValueToBot = localBot.isLowValueToBot();
		Boolean highValueToBot = localBot.isHighValueToBot();
		Integer idBotLow = localBot.getIdBotLow();
		Integer idBotHigh = localBot.getIdBotHigh();
		Integer lowerValue = localBot.getLower();
		Integer higherValue = localBot.getHigher();
//		System.out.println(bots.get(getPosByID(idBotLow)));
//		System.out.println(bots.get(getPosByID(idBotHigh)));
		if (lowValueToBot) {
			bots.get(getPosByID(idBotLow)).consumeData1(lowerValue);
			localBot.setLower(null);
		} else {
			if (idBotLow == 0) {
				bin0 = lowerValue;
			} else if (idBotLow == 1) {
				bin1 = lowerValue;
			} else if (idBotLow == 2) {
				bin2 = lowerValue;
			}
		}
		
		if (highValueToBot) {
			bots.get(getPosByID(idBotHigh)).consumeData1(higherValue);
			localBot.setHigher(null);
		} else {
			if (idBotHigh == 0) {
				bin0 = lowerValue;
			} else if (idBotHigh == 1) {
				bin1 = lowerValue;
			} else if (idBotHigh == 2) {
				bin2 = lowerValue;
			}
		}
		
//		System.out.println(bots.get(getPosByID(idBotLow)));
//		System.out.println(bots.get(getPosByID(idBotHigh)));
	}
	
	public Integer getPosByID(Integer ID) {
		for (Bot bot : bots) {
			if (bot.getId().equals(ID)) {
				return bots.indexOf(bot);
			}
		}
		return null;
	}
	
	public Boolean findBothValues(Bot bot) {
		return bot.getLower() != null && bot.getHigher() != null;
	}
	
	public Boolean findOneValue(Bot bot) {
		return bot.getLower() != null ^ bot.getHigher() != null;
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
