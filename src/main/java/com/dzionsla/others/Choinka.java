package com.dzionsla.others;

import java.util.Scanner;

public class Choinka {
	// https://www.samouczekprogramisty.pl/choinka/
	
	char treeSymbol = '*';
	char spaceSymbol = ' ';
	int heigth = 0;
	Scanner inputScanner = new Scanner(System.in);

	public Choinka() {
		readFromKeyboard();
		printAll(heigth);
	}

	private void readFromKeyboard() {
		System.out.println("Podaj wysokosc choinki: ");
		heigth = inputScanner.nextInt();
	}
	
	private void printAll(int h) {
		for (int i = h; i > 0; i--) {
			printSpacesLoop(i);	
			printTreeLoop(h-i+1);
		}
	}
	// Loops
	private void printTreeLoop(int n) {
		for (int i = 1; i < 2*n; i++) {
			System.out.print(treeSymbol);
		}
		System.out.println();
	}
	
	private void printSpacesLoop(int n) {
		for (int i = 0; i < n - 1; i++) {
			System.out.print(spaceSymbol);
		}
	}
	

}
