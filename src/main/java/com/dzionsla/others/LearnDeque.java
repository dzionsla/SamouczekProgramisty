package com.dzionsla.others;

import java.util.ArrayDeque;
import java.util.Deque;

public class LearnDeque {

	public static void main(String[] args) {
		 Deque<String> pathsToCheck = new ArrayDeque<>();
		 
		 pathsToCheck.add("1");
		 pathsToCheck.add("2");
		 pathsToCheck.add("3");
		 
		 printDeque(pathsToCheck);
		 
		 System.out.println(pathsToCheck.pollLast());
		 
		 
		 printDeque(pathsToCheck);
	}
	
	private static void printDeque(Deque<String> deque) {
		System.out.println("------------------------------");
		deque.forEach(n -> System.out.println(n));
		System.out.println("------------------------------");
	}

}
