package com.dzionsla.aoc2016.day02;

import java.util.ArrayList;
import java.util.List;

public class MapMovement {
	List<String> list = new ArrayList<String>();
	List<Integer> password = new ArrayList<Integer>();
	List<String> passwordAdv = new ArrayList<String>();
	static final Integer START = 5;
	XY startPosition = new XY(1, 1);
	XY startPositionAdv = new XY(2, 0);
	XY actualPosition;
	XY actualPositionAdv;
	boolean newStart = true;
	Integer[][] keypad = new Integer[][] {
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9}
	};
	String[][] keypadAdv = new String[][] {
		{"0", "0", "1", "0", "0"},
		{"0", "2", "3", "4", "0"},
		{"5", "6", "7", "8", "9"},
		{"0", "A", "B", "C", "0"},
		{"0", "0", "D", "0", "0"}
	};
	private class XY {
		private int x;
		private int y;
		
		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public XY move(XY actPos, XY move) {
			return new XY(actPos.getX() + move.getX(), actPos.getY() + move.getY());
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

		private MapMovement getEnclosingInstance() {
			return MapMovement.this;
		}

		

	}
	
	public enum Keyboard{
		UP('U'),
		DOWN('D'),
		LEFT('L'),
		RIGHT('R');
		
		private char letter ;
		
		private Keyboard(char s) {
			letter = s;
		}
		
		public char getLetter() {
			return letter;
		}
		
	}
	
	public MapMovement(List<String> list) {
		this.list = list;
		// Basic Keyboard
		loopList();
		//printKeyboard(keypad);
		
		System.out.print("Password: ");
		password.forEach(n -> System.out.print(n));
		
		// Advance Keyboard
		System.out.println("\n\nAdvance PASSWORD!!");
		//printKeyboard(keypadAdv);
		
		System.out.print("Password Adv: ");
		passwordAdv.forEach(n -> System.out.print(n));
	}
	
	public void loopList() {
		for (String str : list) {
			passwordLine(str);
		}
	}
	
	public String passwordLine(String line) {
		
		if (newStart == true) {
			actualPosition = startPosition;
			actualPositionAdv = startPositionAdv;
			newStart = false;
		}
		for (char c : line.toCharArray()) {
			// Basic
			actualPosition = move(c, actualPosition, false);
			// Advance
			actualPositionAdv = move(c, actualPositionAdv, true);
			
		}
		// Basic
		startPosition = actualPosition;
		password.add(keypad[actualPosition.getX()][actualPosition.getY()]);
		
		// Advance
		startPositionAdv = actualPositionAdv;
		passwordAdv.add(keypadAdv[actualPositionAdv.getX()][actualPositionAdv.getY()]);
		
		//System.out.println(keypad[actualPosition.getX()][actualPosition.getY()]);
		//newStart = true;
		
		return " ";
	}
	
	public XY move(char c, XY actPos, boolean adv) {
		if (c == Keyboard.UP.getLetter() && (adv ? checkIfPossibleAdv(c, actPos) : checkIfPossible(c, actPos)) ) {
			actPos = actPos.move(actPos, new XY(-1,0));
		} else if (c == Keyboard.DOWN.getLetter() && (adv ? checkIfPossibleAdv(c, actPos) : checkIfPossible(c, actPos)) ) {
			actPos = actPos.move(actPos, new XY(1,0));
		} else if (c == Keyboard.RIGHT.getLetter() && (adv ? checkIfPossibleAdv(c, actPos) : checkIfPossible(c, actPos)) ) {
			actPos = actPos.move(actPos, new XY(0,1));
		} else if (c == Keyboard.LEFT.getLetter() && (adv ? checkIfPossibleAdv(c, actPos) : checkIfPossible(c, actPos)) ) {
			actPos = actPos.move(actPos, new XY(0,-1));
		}
			
		return actPos;
	}
	
	public boolean checkIfPossible(char c, XY actPos) {
		if (c == Keyboard.UP.getLetter() && actPos.getX() > 0) {
			return true;
		} else if (c == Keyboard.DOWN.getLetter() && actPos.getX() < 2) {
			return true;
		} else if (c == Keyboard.LEFT.getLetter() && actPos.getY() > 0) {
			return true;
		} else if (c == Keyboard.RIGHT.getLetter() && actPos.getY() < 2) {
			return true;
		}
		
		return false;
	}
	
	public boolean checkIfPossibleAdv(char c, XY actPos) {
		if (c == Keyboard.UP.getLetter() && 
				(actPos.getX() == 1 || actPos.getX() == 2 || actPos.getX() == 3 || actPos.getX() == 4)  &&
				(actPos.getY() == 1 || actPos.getY() == 2 || actPos.getY() == 3 ) &&
				!(actPos.getX() == 1 && actPos.getY() == 1) && !(actPos.getX() == 1 && actPos.getY() == 3)) {
			return true;
		} else if (c == Keyboard.DOWN.getLetter() && 
				(actPos.getX() == 0 || actPos.getX() == 1 || actPos.getX() == 2 || actPos.getX() == 3)  &&
				(actPos.getY() == 1 || actPos.getY() == 2 || actPos.getY() == 3 ) &&
				!(actPos.getX() == 3 && actPos.getY() == 1) && !(actPos.getX() == 3 && actPos.getY() == 3)) {
			return true;
		} else if (c == Keyboard.LEFT.getLetter() && 
				(actPos.getX() == 1 || actPos.getX() == 2 || actPos.getX() == 3)  &&
				(actPos.getY() == 1 || actPos.getY() == 2 || actPos.getY() == 3 || actPos.getY() == 4) &&
				!(actPos.getX() == 1 && actPos.getY() == 1) && !(actPos.getX() == 3 && actPos.getY() == 1)) {
			return true;
		} else if (c == Keyboard.RIGHT.getLetter() && 
				(actPos.getX() == 1 || actPos.getX() == 2 || actPos.getX() == 3)  &&
				(actPos.getY() == 0 || actPos.getY() == 1 || actPos.getY() == 2 || actPos.getY() == 3) &&
				!(actPos.getX() == 1 && actPos.getY() == 3) && !(actPos.getX() == 3 && actPos.getY() == 3)) {
			return true;
		}
		
		return false;
	}
	
	public <T> void printKeyboard(T[][] keypad) {
		for (int i = 0; i < keypad.length; i++) {
			for (int j = 0; j < keypad[i].length; j++) {
				System.out.println(keypad[i][j] + " - (" + i + ", " + j + ")");
			}
			System.out.println();
		}
	}
	
}
