package com.dzionsla.aoc2016.day17;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class VaultMR {
	private static final int VAULT_SIZE = 4;
	
    private final static int UP = 0;
    private final static int DOWN = 1;
    private final static int LEFT = 2;
    private final static int RIGHT = 3;

    private static final Set<Character> DOOR_OPEN = new HashSet<>(Arrays.asList('b', 'c', 'd', 'e', 'f'));
    
    private final String INPUT = "lpvhkcbi";  //lpvhkcbi
    
	private static class Position{
		private int x;
		private int y;
		private String path;
		
		public Position(int x, int y, String hash) {
            this.x = x;
            this.y = y;
            this.path = hash;
        }

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + ", hash=" + path + "]";
		}
		
		
	}

	public String findShortestPath() {
		Deque<Position> pathsToCheck = new ArrayDeque<>();
        Deque<Position> nextIteration = new ArrayDeque<>();
        
        pathsToCheck.add(new Position(0, 0, INPUT));

        while (pathsToCheck.size() > 0) {
            while (pathsToCheck.size() > 0) {
                Position position = pathsToCheck.pop();

                boolean reachedDestination = position.x == VAULT_SIZE - 1 && position.y == VAULT_SIZE - 1;
                if (reachedDestination) {
                    return position.path.substring(INPUT.length());
                }

                addAdjacentPositions(nextIteration, position);
            }
            pathsToCheck = nextIteration;
            nextIteration = new ArrayDeque<>();
        }

        throw new IllegalStateException("There is no exit!");
	}
	
	public String findLongestPath() {
		Deque<Position> pathsToCheck = new ArrayDeque<>();
        Deque<Position> nextIteration = new ArrayDeque<>();
        String longestPath = null;
        pathsToCheck.add(new Position(0, 0, INPUT));

        while (pathsToCheck.size() > 0) {
            while (pathsToCheck.size() > 0) {
                Position position = pathsToCheck.pop();

                boolean reachedDestination = position.x == VAULT_SIZE - 1 && position.y == VAULT_SIZE - 1;
                if (reachedDestination) {
                	longestPath = position.path.substring(INPUT.length());
                	continue;
                }

                addAdjacentPositions(nextIteration, position);
            }
            pathsToCheck = nextIteration;
            nextIteration = new ArrayDeque<>();
        }

        return longestPath;
	}
	
	private void addAdjacentPositions(Deque<Position> nextIteration, Position position) {
        int x = position.x;
        int y = position.y;
        String path = position.path;
        char[] characters = createMD5(position.path).toCharArray();

        if (DOOR_OPEN.contains(characters[UP]) && x > 0) {
            nextIteration.add(new Position(x - 1, y, path + "U"));
        }
        if (DOOR_OPEN.contains(characters[DOWN]) && x < VAULT_SIZE - 1) {
            nextIteration.add(new Position(x + 1, y, path + "D"));
        }
        if (DOOR_OPEN.contains(characters[RIGHT]) && y < VAULT_SIZE - 1) {
            nextIteration.add(new Position(x, y + 1, path + "R"));
        }
        if (DOOR_OPEN.contains(characters[LEFT]) && y > 0) {
            nextIteration.add(new Position(x, y - 1, path + "L"));
        }
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
            //System.out.println(hashtext.substring(0, 4));
            return hashtext.substring(0, 4); 
        }
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
	}
}
