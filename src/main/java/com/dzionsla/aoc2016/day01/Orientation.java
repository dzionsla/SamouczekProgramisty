package com.dzionsla.aoc2016.day01;

import java.util.ArrayList;
import java.util.List;

public class Orientation{
	
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
		
		
	}
	
	
	public static List<XY> l = new ArrayList<XY>();

	public enum Orient {
		NORTH,
		SOUTH,
		EAST,
		WEST;
		
//		private int x;
//		private int y;
//		
//		Orient(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//		
//		public int getX() {
//			return x;
//		}
//		
//		public int getY() {
//			return y;
//		}
//		
//		public String toString() {
//			return "x = " + x + " y = " + y;
//			
//		}
	}

	public enum Turn {
		LEFT,
		RIGHT;
	}
	
	public static int x;
	public static int y;
	private Orient orient;
	
	public Orientation() {
		this.x = 0;
		this.y = 0;
		this.orient = Orient.NORTH;
		save(x, y);
		showSaved();
	}
	
	public void move(String turn, int howMany) {
		
		if (orient == Orient.NORTH) {
			if (turn.equals("R")) {
				x = x + howMany;
				orient = Orient.EAST;
			} else if(turn.equals("L")) {
				x = x - howMany;
				orient = Orient.WEST;
			}
		} else if(orient == Orient.EAST) {
			if (turn.equals("R")) {
				y = y - howMany;
				orient = Orient.SOUTH;
			} else if(turn.equals("L")) {
				y = y + howMany;
				orient = Orient.NORTH;
			}
		} else if(orient == Orient.WEST) {
			if (turn.equals("R")) {
				y = y + howMany;
				orient = Orient.NORTH;
			} else if(turn.equals("L")) {
				y = y - howMany;
				orient = Orient.SOUTH;
			}
		} else if(orient == Orient.SOUTH) {
			if (turn.equals("R")) {
				x = x - howMany;
				orient = Orient.WEST;
			} else if(turn.equals("L")) {
				x = x + howMany;
				orient = Orient.EAST;
			}
		}
		
		save(x, y);
		showSaved();
	}
	
	public void save(int x, int y) {

		if (l.size() == 0) {
			XY point = new XY(x, y);
			l.add(point);
		} else {
			int localX = Math.abs(x - l.get(l.size() - 1).getX());
			int localY = Math.abs(y - l.get(l.size() - 1).getY());
			
			if (localX != 0) {
				for (int i = localX - 1; i >= 0; i--) {
					l.add(new XY(x - i, y));
				}
			} else {
				for (int i = localY - 1; i >= 0; i--) {
					l.add(new XY(x, y - i));
				}
			}
		}	
		
	}
	
	public void showSaved() {
		System.out.println(l.get(l.size() - 1));
	}
	
	public static void print() {
		System.out.println("Wspolrzedne: " + (x > 0 ? "Wschod": " Zachod") + " - " + x + (y > 0 ? "   Polnoc": " Poludnie") + " - " + y);
		System.out.println("Od pozycji startowej blokow: " + (Math.abs(x)+Math.abs(y)));
		//System.out.println(l.size());
	}
}

