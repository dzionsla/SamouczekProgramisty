package com.dzionsla.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lambda {
	// https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
	
	String[] array = {"d2", "a2", "b1", "b3", "c2", "a0", "a1"};
	
	public int[] lambdaIterate(int from, int limit) {
		return  Stream.iterate(from, n -> n + 1)
				.limit(limit)
    			.filter(n -> n % 2 == 0)
    			.mapToInt(n -> n)
    			.toArray();
	}
	
	public void lambdaPrimitiveArrays() {
		int[] intArray = lambdaIterate(1, 20);
		
		IntStream intStream1 = Arrays.stream(intArray);
		intStream1.forEach(x -> System.out.println(x));
	}
	
	public void lambdaComplexArrays() {
		String[] array = {"a", "b", "c", "d", "e"};
		
		//Arrays.stream
        //Stream<String> stream1 = Arrays.stream(array);
        //stream1.forEach(x -> System.out.println(x));

        //Stream.of
        Stream<String> stream2 = Stream.of(array);
        stream2.forEach(x -> System.out.print(x + " "));
	}
	
	public void lambdaAnyMatch() {
		String[] array = {"d2", "a2", "b1", "b3", "c"};
		
		Stream.of(array)
	    	.map(s -> s.toUpperCase())
	    	.anyMatch(s -> {
	    		System.out.println("anyMatch: " + s);
	    		return s.startsWith("A");
	    });
	}
	
	public void lambdaFilter() {
		Stream.of(array)
			.filter(s -> s.startsWith("b"))
			.forEach(System.out::println);
	}
	
	public void lambdaMapToInt() {
		Stream.of(array)
	    .map(s -> s.substring(1))
	    .mapToInt(Integer::parseInt)
	    .max()
	    .ifPresent(System.out::println); 
	}
	
	// https://www.mkyong.com/java8/java-8-how-to-sort-list-with-stream-sorted/
	public void lambdaSorted() {
		Stream.of(array)
		.filter(s -> {
	        //System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
//	    .sorted((s1, s2) -> {
//	        //System.out.printf("sort: %s; %s\n", s1, s2);
//	        return s1.compareTo(s2);
//	    })
		.sorted(Comparator.reverseOrder())
	    .map(s -> {
	        //System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
	}
	
	
	
	
	
}
