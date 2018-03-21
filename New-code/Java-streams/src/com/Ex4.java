package com;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex4 {

	public static void main(String[] args) {

		// Stream<Integer> stream=
		// Stream.iterate(0, n->n+1)
		// .limit(10);
		// stream.forEach(System.out::println);
		//
		// -------------------------------------------------
		//
		 List<Integer> nums=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		 Optional<Integer> optional= nums.stream()
		 //.peek(n->System.out.println("taking - "+n))
		 //.limit(10)
		 .filter(n->n%2==0)
		 //.peek(n->System.out.println("filtering - "+n))
		 .map(n->n*n)
		 //.peek(n->System.out.println("mapped - "+n))
		 //.forEach(n->System.out.println(n));
		 .limit(2)
		 .reduce((seed,n)->seed+n);
		 
		 if(optional.isPresent()) {
			 System.out.println(optional.get());
		 }
		 
		//
		//
		// System.out.println(firstThreeEvens);

//		Stream<Integer> fib = Stream.of(1, 1, 2, 3);
//		fib.forEach(System.out::println);
//		fib.forEach(System.out::println);
		
		//----------------------------------------------------
				
//		
//		Stream<Integer> fib=Stream.of(1,1,2,3);
//		fib=fib.limit(2);
//		
//		
//		Function<Integer, Integer> f1=(n)->n+10;
//		Function<Integer, Integer> f2=(n)->n+20;
//		
//		Function<Integer, Integer> joinedFunction=f1.andThen(f2);
//		
//		Integer integer=joinedFunction.apply(10);
//		System.out.println(integer);
		
				

	}

}
