package com.dzionsla.aoc2016.day17;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

// not working !!

public class Steps {
	private String INPUT = "lpvhkcbi";
	private String INPUT1 = "ihgpwlah";
	private String INPUT2 = "kglvqrro";
	private String INPUT3 = "ulqzkmiv";
	private String INPUT4 = "hijkl";
	private Integer length = 4;
	private XY startPoint = new XY(0, 0);
	private XY endPoint = new XY(3, 3);
	private XY actPosition = new XY(0, 0);
	Map<Integer, XY> road = new LinkedHashMap<Integer, XY>();
	Integer moves = 0;
	boolean returned = false;
	
	private class XY {
		private int x;
		private int y;
		private boolean[] pm = new boolean[4];
		private int count = 0;
		
		public XY(int x, int y) {
			this.x = x;
			this.y = y;
			count++;
		}
		
		public XY(int x, int y, boolean[] pm) {
			this.x = x;
			this.y = y;
			this.pm = pm;
			count++;
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
		
//		public XY move(int i) {
//			if (i == 0) {
//				//setX(getX() - 1);
//				return new XY(getX() - 1, getY());
//			} else if (i == 1) {
//				//setX(getX() + 1);
//				return new XY(getX() + 1, getY());
//			} else if (i == 2) {
//				//setY(getY() - 1);
//				return new XY(getX(), getY() - 1);
//			} else if (i == 3) {
//				//setY(getY() + 1);
//				return new XY(getX(), getY() + 1);
//			}
//			return null;
//			
//		}
		
		public boolean[] getPm() {
			return pm;
		}

		public void setPm(boolean[] pm) {
			this.pm = alreadyVisited(pm);
		}
		
		private boolean[] alreadyVisited(boolean[] pm) {
			if (count == 0) {
				count++;
				return arrChanged(pm, 0);
			} else if (count == 1) {
				count++;
				return arrChanged(pm, 1);
			} else if (count == 2) {
				count++;
				return arrChanged(pm, 2);
			} else if (count == 3) {
				count++;
				return arrChanged(pm, 3);
			} else {
				return null;
			}
		}
		
		private boolean[] arrChanged(boolean[] pm, int i) {
			boolean[] locPm = pm;
			int ctr = 0;
			
			for (int j = 0; j < locPm.length; j++) {
				if (i == 0) {
					return locPm;
				} else if (i == 1) {
					if (locPm[j] == true) {
						locPm[j] = false;
						return locPm;
					}
					
				} else if (i == 2) {
					if (locPm[j] == true) {
						locPm[j] = false;
						ctr++;
						if (ctr == 2) {
							return locPm;
						}
					}
				} else if (i == 3) {
					if (locPm[j] == true) {
						locPm[j] = false;
						ctr++;
						if (ctr == 3) {
							return locPm;
						}
					}
				}
			}
			
			return null;
		}

		public void move(int i) {
			if (i == 0) {
				setX(getX() - 1);
			} else if (i == 1) {
				setX(getX() + 1);
			} else if (i == 2) {
				setY(getY() - 1);
			} else if (i == 3) {
				setY(getY() + 1);
			}
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

		private Steps getEnclosingInstance() {
			return Steps.this;
		}

	}
	
	public Steps() {
		String hash = INPUT1;
		int ctr = 0;
		
		road.put(0, startPoint);
		System.out.println(actPosition);
		
		while (!actPosition.equals(endPoint)) {
			boolean[] pm1 = possibleMovements(createMD5(hash), actPosition);
			road.put(moves, new XY(actPosition.getX(), actPosition.getY(), pm1));
			pm1 = moveBack(pm1);
			System.out.println("before: " + hash);
			printMoves(pm1);
			hash = changeHashAndPos(hash, pm1);
			System.out.println("after: " + hash);
			System.out.println(actPosition);
			
			
			System.out.println("--------------------");
			
			if (ctr == 100) {
				break;
			}
			ctr++;
		}
		System.out.println(road);
	}
	
	private boolean[] moveBack(boolean[] pm) {
		
		for (int i = 0; i < pm.length; i++) {
			if (pm[i] == true) {
				return pm;
			}
		}
		returned = true;
		road.remove(road.size() - 1);
		
		actPosition = road.get(road.size() - 1);
		//moves++;
		actPosition.setPm(actPosition.getPm());
		

		return actPosition.getPm();
	}
	
	private String changeHashAndPos(String hash, boolean[] possibility) {
		StringBuilder sb = new StringBuilder(hash);
		
		if (returned) {
			sb.deleteCharAt(sb.length() - 1);
		}
		
		if (possibility[0] == true) {
			sb.append('U');
			//locActPos = actPosition.move(0);
			actPosition.move(0);
		} else if (possibility[1] == true) {
			sb.append('D');
			//locActPos = actPosition.move(1);
			actPosition.move(1);
		} else if (possibility[2] == true) {
			sb.append('L');
			//locActPos = actPosition.move(2);
			actPosition.move(2);
		} else if (possibility[3] == true) {
			sb.append('R');
			//locActPos = actPosition.move(3);
			actPosition.move(3);
		}
		moves++;
		returned = false;
		
		return sb.toString();
	}
	
	public boolean checkIfPossible(int i, XY actPos) {
		if (i == 0 && actPos.getX() > 0) {
			return true;
		} else if (i == 1 && actPos.getX() < 2) {
			return true;
		} else if (i == 2 && actPos.getY() > 0) {
			return true;
		} else if (i == 3 && actPos.getY() < 2) {
			return true;
		}
		
		return false;
	}
	
	private boolean[] possibleMovements(String str, XY actPos)	{
		boolean[] pm = new boolean[4];

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'b' || str.charAt(i) == 'c' || str.charAt(i) == 'd' || str.charAt(i) == 'e' || str.charAt(i) == 'f') {
				if (checkIfPossible(i, actPos)) {
					pm[i] = true;
				}
			}
		}
		
		return pm;
	}
	
	private String createMD5(String str) {
		try { 
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(str.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            System.out.println(hashtext.substring(0, 4));
            return hashtext.substring(0, 4); 
        }
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
	}
	
	private void printMoves(boolean[] pm) {
		System.out.println("UP: " + pm[0]);
		System.out.println("DOWN: " + pm[1]);
		System.out.println("LEFT: " + pm[2]);
		System.out.println("RIGHT: " + pm[3]);
	}
	
	private void printMaze() {
//		Integer ctr = 1;
//		for (int i = 0; i < length; i++) {
//			for (int j = 0; j < length; j++) {
//				System.out.print(" | " + ctr + " | ");
//				ctr++;
//			}
//			System.out.println();
//		}
		boolean first = true;
		System.out.println("#########");
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (j == 0) {
					if (first) {
						System.out.print("#" + "S" + "|");
					} else {
						System.out.print("#" + " " + "|");
					}
				} else if (j == length - 1) {
					System.out.println(" " + "#");
				} else {
					System.out.print(" |");
				}
				first = false;
			}
			System.out.println("#-#-#-#-#");
		}
		System.out.println("#########");
	}
	
}
