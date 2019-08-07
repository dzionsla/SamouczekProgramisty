package com.dzionsla.main;

import java.io.IOException;

import com.dzionsla.others.FunctInterf;

public class App {

	public static void main(String[] args) throws IOException {
		// Rysowanie choinki na consoli
		//Choinka tree = new Choinka();
		
		// Liczby cykliczne
		//CyclicNumber cyclicNumber = new CyclicNumber();

		// Missing element
		//MissingElement m = new MissingElement(10);
		
		// Calculator
//		String path = "test.txt";
//		List<String> data = null;
//		try {
//			data = FileReader.readAsList(path);
//			String est = FileReader.readAsString(path);
//			Calculator calc = new Calculator(FileReader.readLastValue(), data);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// £añcuch bia³kowy
		//LancuchBialkowy lb = new LancuchBialkowy("test2.txt");
		
		// Maszyna losuj¹ca
		//FileReader.readCSV("test1.csv");
		//MaszynaLosujaca ml = new MaszynaLosujaca("C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\test2.csv", 2);
		
		
		// REGEX MATCHER PATTERN
		//MatcherPattern.printMatcher();
		
		// Interface function
		FunctInterf f = new FunctInterf();
		//f.interfFunct();
		//f.interfConsumer();
		//f.interfSupplier();
		f.interfPredicate();
		
		
		//Lambda l = new Lambda();
		//l.lambdaComplexArrays();
		//l.lambdaAnyMatch();
		//l.lambdaFilter();
		//l.lambdaMapToInt();
		//l.lambdaSorted();
		//System.out.println(Arrays.toString(intArray));
		
	}

}
