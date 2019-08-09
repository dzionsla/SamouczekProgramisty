package com.dzionsla.aoc2016.day02;

import java.io.IOException;

import com.dzionsla.interview.FileReader;

public class App {

	public static void main(String[] args) throws IOException {
		ReadFile read = new ReadFile();

		MapMovement movement = new MapMovement(read.readAsList("C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day02_input.txt"));
		//movement.passwordLine(line)
		
	}

}
