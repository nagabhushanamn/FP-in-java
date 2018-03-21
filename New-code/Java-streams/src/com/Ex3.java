package com;

import java.util.Random;
import java.util.stream.Stream;

public class Ex3 {

	public static void main(String[] args) {

		// Stream<Integer> stream = Stream.of(1, 1, 2, 3);
		// Integer[] nums = { 1, 1, 2, 3 };
		// stream = Stream.of(nums);

		Random random = new Random();

		Stream<Integer> stream= Stream.generate(random::nextInt)
						       .filter(n->n>0)
							   .limit(10);
			
		stream.forEach(n->{
	    	   System.out.println("consuming-"+n);
		});
	}

}
