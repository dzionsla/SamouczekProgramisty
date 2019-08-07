package com.dzionsla.aoc2016.day01;

public class Orientation{
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
	}
	
	public void move(String turn, int howMany) {
		
		if (orient == Orient.NORTH) {
			if (turn == "R") {
				x = x + howMany;
			} else if(turn == "L") {
				x = x - howMany;
			}
		} else if(orient == Orient.EAST) {
			if (turn == "R") {
				y = y + howMany;
			} else if(turn == "L") {
				y = y - howMany;
			}
		} else if(orient == Orient.WEST) {
			if (turn == "R") {
				y = y - howMany;
			} else if(turn == "L") {
				y = y + howMany;
			}
		} else if(orient == Orient.SOUTH) {
			if (turn == "R") {
				x = x - howMany;
			} else if(turn == "L") {
				x = x + howMany;
			}
		}
		
	}
	
	public static void print() {
		System.out.println("x = " + x + ", y = " + y);
	}
}

