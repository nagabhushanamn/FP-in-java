package com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.model.Employee;
import com.model.Gender;

public class Ex2 {
	
	public static void main(String[] args) {
		

		List<Employee> employees=Arrays.asList(
				new Employee(23423, "B", 2000.00, Gender.MALE),
				new Employee(32323, "A", 1000.00, Gender.FEMALE),
				new Employee(53555, "D", 4000.00, Gender.FEMALE),
				new Employee(12334, "C", 3000.00, Gender.MALE),
				new Employee(12334, "C", 3000.00, Gender.MALE)
				);
		
		
		 employees.stream()	  // Build operation
				  .filter(e->e.getSalary()>=2500)  // Intermediate operation
				  .map(Employee::getName)
				  .distinct()
				  //.sorted((s1,s2)->s2.compareTo(s1))
				  .sorted(Comparator.reverseOrder())
				  .forEach(System.out::println); // Termonal opeation
		
		
		
	}

}









