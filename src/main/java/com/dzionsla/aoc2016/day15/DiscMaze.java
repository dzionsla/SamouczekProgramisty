package com.dzionsla.aoc2016.day15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiscMaze {
	private String dir = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day15_input.txt";
	Map<Integer, Disc> discs = new HashMap<Integer, Disc>();
	
	private class Disc {
		int discID;
		int maxPos;
		int time;
		int actPos;
		
		public Disc(int discID, int maxPos, int time, int actPos) {
			this.discID = discID;
			this.maxPos = maxPos;
			this.time = time;
			this.actPos = actPos;
		}
		
		public int getDiscID() {
			return discID;
		}
		
		public void setDiscID(int discID) {
			this.discID = discID;
		}
		
		public int getMaxPos() {
			return maxPos;
		}
		
		public void setMaxPos(int maxPos) {
			this.maxPos = maxPos;
		}
		
		public int getTime() {
			return time;
		}
		
		public void setTime(int time) {
			this.time = time;
		}
		
		public int getActPos() {
			return actPos;
		}
		
		public void setActPos(int actPos) {
			this.actPos = actPos;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + discID;
			result = prime * result + maxPos;
			result = prime * result + actPos;
			result = prime * result + time;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Disc other = (Disc) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (discID != other.discID)
				return false;
			if (maxPos != other.maxPos)
				return false;
			if (actPos != other.actPos)
				return false;
			if (time != other.time)
				return false;
			return true;
		}
		
		private DiscMaze getEnclosingInstance() {
			return DiscMaze.this;
		}
		
		@Override
		public String toString() {
			return "Disc [discID=" + discID + ", maxPos=" + maxPos + ", time=" + time + ", position=" + actPos + "]";
		}

	}
	
	public DiscMaze() {
		toMap(readToList(dir));
		
		printMap(discs);
		
		//System.out.println(checkMovement(discs.get(1), 5));
		//System.out.println(howManyMoveTo0(discs.get(2)));
		
		//System.out.println(lcm(10, 3));
		taskV1();
	}
	
	private void taskV1() {
		boolean check = false;
		for (int i = 0; ; i++) {
			for (int j = 1; j <= discs.size(); j++) {
				if (checkMovement(discs.get(j), i) != 0) {
					check = false;
					break;
				}
				check = true;
			}
			if (check) {
				System.out.println(i);
				break;
			}
		}
	}
	
	public static int lcm(int number1, int number2) {
		int x,max=0,min=0,lcm=0;
        if(number1>number2) {
            max=number1;
            min=number2;
        }
        else {
            max=number2;
            min=number1;
        }

        for(int i=1;i<=min;i++) {
            x=max*i; 
            if(x%min==0) {
            	lcm=x; 
            	break; 
            }
        }
         return lcm;
    }
	
	private int howManyMoveTo0(Disc disc) {
		return disc.maxPos - disc.actPos - disc.discID;
	}
	
	private int checkMovement(Disc disc, int howManyMoves) {
		return (disc.actPos + howManyMoves + disc.discID) % (disc.maxPos);
	}
	
	private void toMap(List<String> data) {
		Integer ctr = 1;
		for (String disc : data) {
			discs.put(ctr, returnDisc(disc));
			ctr++;
		}
	}
	
	private Disc returnDisc(String str) {
		Pattern p = Pattern.compile("Disc #(\\d+) has (\\d+) positions; at time=(\\d+), it is at position (\\d+).");
		Matcher m = p.matcher(str);
		
		if (!m.matches()) {
            throw new IllegalArgumentException(String.format("Instruction [%s] can't be parsed!", str));
        }
		
		return new Disc(Integer.valueOf(m.group(1)), Integer.valueOf(m.group(2)), Integer.valueOf(m.group(3)), Integer.valueOf(m.group(4)));
	}
	
	private void printMap(Map<Integer, Disc> map) {
		map.entrySet().stream()
        .forEach( x -> System.out.println("Key : " + x.getKey() + " Value : " + x.getValue()));
	}
	
	private List<String> readToList(String dir) {
		try {
			return Files.readAllLines(Paths.get(dir));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
