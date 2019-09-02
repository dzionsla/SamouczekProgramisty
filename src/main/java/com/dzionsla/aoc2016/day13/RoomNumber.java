package com.dzionsla.aoc2016.day13;

import java.util.List;

import com.dzionsla.aoc2016.astar.AStar;
import com.dzionsla.aoc2016.astar.Node;

public class RoomNumber {
	private static Integer favNumber = 1364;
	Node initialNode = new Node(1, 1);
    Node finalNode = new Node(39, 31);
	private int lengthX = 50;
	private int lengthY = 50;
	private Boolean officeMap[][] = new Boolean[lengthX][lengthX];
	int[][] blocksArray = new int[2000][2];
	//int[][] blocksArray1 = new int[][]{{1, 3}, {2, 3}, {3, 3}};
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

		private RoomNumber getEnclosingInstance() {
			return RoomNumber.this;
		}
	}
	
	
	public RoomNumber() {
		//System.out.println(countOnes("110001101"));

		printOffice();
		//printBlocks();
		findPath(blocksArray);

	}
	
	private void findPath(int[][] blocksArray) {
		
        int rows = lengthX;
        int cols = lengthY;
        AStar aStar = new AStar(rows, cols, initialNode, finalNode);

        aStar.setBlocks(blocksArray);
        List<Node> path = aStar.findPath();
        for (Node node : path) {
            System.out.println(node);
        }
        System.out.println(path.size() - 1);
	}
	
	private void printOffice() {
		int ctr = 0;
		for (int i = 0; i < lengthY; i++) {
			for (int j = 0; j < lengthX; j++) {
				officeMap[j][i] = countOnes(new XY(j, i));
				if (officeMap[j][i] == true) {
					System.out.print(".");
				} else {
					System.out.print("#");
					blocksArray[ctr][0] = i;
					blocksArray[ctr][1] = j;
					ctr++;
				}
			}
			System.out.println(" - " + i);
		}
	}
	
	private void printBlocks() {
		for (int i = 0; i < blocksArray.length; i++) {
			System.out.println(blocksArray[i][0] + " " + blocksArray[i][1]);
		}
	}
	
	private Boolean countOnes(XY xy) {
		Integer ctr = 0;
		String str = intToBin(xy);
		//System.out.print("-" + str + "-");
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				ctr++;	
			}
		}
		//System.out.print(" " + ctr);
		return ctr % 2 == 0 ? true : false;
	}
	
	private String intToBin(XY xy) {
		return Integer.toBinaryString(calcEq(xy));
	}
	
	private String intToBin1(Integer x) {
		return Integer.toBinaryString(x);
	}
	
	private Integer calcEq(XY xy) {
		// x*x + 3*x + 2*x*y + y + y*y
		//System.out.print(xy.getX() * xy.getX() + 3 * xy.getX() + 2 * xy.getX() * xy.getY() + xy.getY() + xy.getY()*xy.getY() + favNumber);
		return xy.getX() * xy.getX() + 3 * xy.getX() + 2 * xy.getX() * xy.getY() + xy.getY() + xy.getY() * xy.getY() + favNumber;
	}
	
	
}
