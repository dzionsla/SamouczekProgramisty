package com.dzionsla.aoc2016.day08;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class PuzzleScreen {
	
	private class XY {
		private int x;
		private int y;
		
		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + x;
			result = prime * result + y;
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
			XY other = (XY) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		private PuzzleScreen getEnclosingInstance() {
			return PuzzleScreen.this;
		}
		
	}
	
	private List<String> data;
	String path = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day08_input.txt";
	String[][] screen = new String[6][50];
	
	public PuzzleScreen() {
		try {
			readData(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//data.forEach(n -> System.out.println(n + " - " + getCommand(n)));
		
		createScreen();
		loopData();
		printScreen();
		checkLit();
		
		//System.out.println(getValues("rect 1x1"));

	}
	
	public void loopData() {
		for (String cmd : data) {
			if (getCommand(cmd).equals("rotate")) {
				rotateMain(getValues(cmd), checkIfColumn(cmd));
			} else if (getCommand(cmd).equals("rect")) {
				rect(getValues(cmd));
			} else {
				System.out.println("Blad!!");
			}
			printScreen();
		}
	}

	public void rect(XY xy) {
		for (int i = 0; i < xy.getY(); i++) {
			for (int j = 0; j < xy.getX(); j++) {
				screen[i][j] = "#";
			}
		}
	}
	
	public void rotateMain(XY xy, boolean column) {
		if (column) {
			rotateColumn(xy);
		} else {
			rotateRow(xy);
		}
	}
	
	public void rotateRow(XY xy) {
		String str = "";
		
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				if (Integer.valueOf(xy.getX()).equals(i)) {
					str = str + screen[i][j];
				}
			}
		}
		
		str = rot(str, xy.getY());
		
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				if (Integer.valueOf(xy.getX()).equals(i)) {
					screen[i][j] = String.valueOf(str.charAt(j));
				}
			}
		}
		
	}
	
	public void rotateColumn(XY xy) {
		String str = "";
		
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				if (Integer.valueOf(xy.getX()).equals(j)) {
					str = str + screen[i][j];
				}
			}
		}

		str = rot(str, xy.getY());

		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				//System.out.print(xy.getX() + ":" + j + "-");
				if (Integer.valueOf(xy.getX()).equals(j)) {
					//System.out.print("(jebneeeee - " + screen[i][j] + ")");
					screen[i][j] = String.valueOf(str.charAt(i));
				}
			}
			//System.out.println();
		}
	}
	
	public String rot(String s, int offset) {
		  int i = offset % s.length();
		  return   s.substring(s.length() - i) + s.substring(0, s.length() - i);
	}
	
	public XY getValues(String str) {
		XY xy = new XY(0, 0);
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(str);
		
		m.find();
		xy.setX(Integer.valueOf(m.group()));
		m.find();
		xy.setY(Integer.valueOf(m.group()));
		
		return xy;
	}
	
	public boolean checkIfColumn(String str) {
		return str.contains("column");
	}
	
	public String getCommand(String str) {
		String arr[] = str.split(" ", 2);
		return arr[0];
	}
	
	public void checkLit() {
		int ctr = 0;
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				if (screen[i][j].equals("#")) {
					ctr++;
				}
			}
		}
		System.out.println(ctr);
	}
	
	public void createScreen() {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				screen[i][j] = ".";
			}
		}
	}
	
	public void printScreen() {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				System.out.print(screen[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void readData(String path) throws IOException {
		data = Files.lines(Paths.get(path), StandardCharsets.UTF_8).collect(Collectors.toList());
	}
}
