package com.dzionsla.aoc2016.day19;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Elfs {
	private static int howManyElfs = 3001330;
	private static int howManyElfs1 = 3001330;
	List<Integer> elfs = new ArrayList<Integer>();
	
	public Elfs() {	
		System.out.println(partOne(howManyElfs));
//		System.out.println(partTwo(howManyElfs));

		for (int i = 1; ; i++) {
			double x = Math.pow(2, i);
			if (x >= howManyElfs1) {
				double y = howManyElfs1 - Math.pow(2, i - 1);
				System.out.println(2 * y + 1);
				break;
			}
		}
	}
	
	private static int partOne(int size) {
	    Deque<Integer> queue = IntStream.rangeClosed(1, size).boxed().collect(Collectors.toCollection(ArrayDeque::new));
	    
	    while (queue.size() > 1) {
	      queue.add(queue.poll());
	      queue.poll();
	    }
	    return queue.poll();
	  }
	
	private static int partTwo(int size) {
	    Deque<Integer> left = IntStream.rangeClosed(1, size / 2).boxed().collect(Collectors.toCollection(ArrayDeque::new));
	    Deque<Integer> right = IntStream.rangeClosed(size / 2 + 1, size).boxed().collect(Collectors.toCollection(ArrayDeque::new));

	    while (left.size() + right.size() > 1) {
	      right.poll();
	      right.add(left.poll());
	      if ((left.size() + right.size()) % 2 == 0)
	        left.add(right.poll());
	    }
	    return right.poll();
	  }
	
	
	private static void fillList(List<Integer> elfs, int howMany) {
		for (int i = 0; i < howMany; i++) {
			elfs.add(i);
		}
		//System.out.println(elfs.size());
		elfs.forEach(n -> System.out.println(n));
	}
	
}
