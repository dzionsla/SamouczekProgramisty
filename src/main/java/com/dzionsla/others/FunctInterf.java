package com.dzionsla.others;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FunctInterf {
	
//	Function <T, R> – przyjmuje dowolny obiekt i zwraca dowolny obiekt (T, R),
//	Consumer <T> – przyjmuje dowolny obiekt, ale nic nie zwraca (T, void),
//	Supplier <T> – nic nie przyjmuje, ale zwraca dowolny obiekt (void, T),
//	Predicate <T> – przyjmuje dowolny obiekt, ale zwraca boolean (T, boolean),	
	
	public void interfFunct() {
		Function<Integer, String> showCodeCouple = x -> x + " Dupa";
		System.out.println(showCodeCouple.apply(1));
		
		Function<String, Integer> createIntegerAndAddTen = x -> Integer.parseInt(x) + 110;
		Stream.of("10", "20", "30")
		          .map(createIntegerAndAddTen)
		          .forEach(System.out::println);
	}
	
	public void interfConsumer() {
		Consumer<String> showCodeCouple = text -> System.out.println(text);
		showCodeCouple.accept("CodeCouple");
		
		Consumer<String> showCodeCouple1 = text -> System.out.println(text);
		Stream.of("show", "Code", "Couple")
		        .forEach(showCodeCouple1);
	}
	
	public void interfSupplier() {
		Supplier<String> returnCodeCouple = () -> "CodeCouple";
		System.out.println(returnCodeCouple.get());
	}
	
	public void interfPredicate() {
		Predicate<String> checkCodeCoupleIsTheBest = text -> text.contains("best");
		System.out.println("Is Code Couple the best? " + checkCodeCoupleIsTheBest.test("CodeCouple is the best"));
		
		Predicate<String> containsCode = textToCheck -> textToCheck.contains("Code");

		Stream.of("showCode", "Code", "Couple")
		        //.filter(containsCode)
		        .filter(containsCode.negate())
		        .forEach(System.out::println);
		
		Predicate<String> containsCode1 = textToCheck -> textToCheck.contains("Code");
		Predicate<String> containsCouple = textToCheck -> textToCheck.contains("Couple");

		Stream.of("showCode", "Code", "CodeCouple")
		        .filter(containsCode1.and(containsCouple))
		        .forEach(System.out::println);

	}
	
	
}
