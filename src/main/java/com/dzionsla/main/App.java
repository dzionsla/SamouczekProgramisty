package com.dzionsla.main;

import java.io.IOException;
import java.util.List;

import com.dzionsla.interview.Calculator;
import com.dzionsla.interview.FileReader;
import com.dzionsla.interview.LancuchBialkowy;
import com.dzionsla.others.MaszynaLosujaca;

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
		MaszynaLosujaca ml = new MaszynaLosujaca("test2.csv", 2);
		
		//Lambda l = new Lambda();
		//l.lambdaComplexArrays();
		//l.lambdaAnyMatch();
		//l.lambdaFilter();
		//l.lambdaMapToInt();
		//l.lambdaSorted();
		//System.out.println(Arrays.toString(intArray));
		
	}

}
