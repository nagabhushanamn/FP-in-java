package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex5 {

	public static void main(String[] args) {

		// T
		int a=1;
		int b=2;
		int c=3;
		
		Stream<Integer> stream=Stream.of(a,b,c);  //  M<T>
			
		stream
			//.map(n->n*n)
		     .flatMap(n->{
		    	 	return Arrays.asList(n,n*n).stream();  // R
		     }) // M<R>
			.forEach(System.out::println);  //R
			

	}

}
