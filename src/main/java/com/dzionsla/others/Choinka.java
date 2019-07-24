package com.dzionsla.others;

import java.util.Scanner;

public class Choinka {
	// https://www.samouczekprogramisty.pl/choinka/
	
	int heigth = 0;
	Scanner inputScanner = new Scanner(System.in);

	public Choinka() {
		readHeigth();
		printAll(heigth);
	}

	private void readHeigth() {
		System.out.println("Podaj wysokosc choinki: ");
		heigth = inputScanner.nextInt();
	}
	
	private void printAll(int h) {
		for (int i = h; i > 0; i--) {
			printSpaces(i);
			
			printTree(h-i+1);
			
			printSpaces(i);
			System.out.println();
		}
	}
	
	private void printTree(int n) {
		for (int i = 1; i < 2*n; i++) {
			System.out.print("*");
		}
		
		//System.out.print("*");
		
	}
	
	private void printSpaces(int n) {
		for (int i = 0; i < n - 1; i++) {
			System.out.print(" ");
		}
	}
	
}
