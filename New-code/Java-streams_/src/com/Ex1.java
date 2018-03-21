package com;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class MyList implements Iterable<Object>{

	@Override
	public Iterator<Object> iterator() {
		return new Iterator<Object>() {
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}
			@Override
			public Object next() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	
}

public class Ex1 {

	public static void main(String[] args) {

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5); // data-structure

		// imperative code  ==> what & how
		Iterator<Integer> iterator = integers.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);

		}
		
		for(Integer integer:integers) {
			System.out.println(integer);
		}
		
		// declarative code ==> what   ,   ==> expressive code
		integers
			.stream()
			.forEach(System.out::println);
		
		
		}

}
