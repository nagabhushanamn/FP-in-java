package com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.model.Address;
import com.model.Employee;
import com.model.Gender;

public class Ex6 {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(
				new Employee(32323, "A", 1000.00, Gender.FEMALE, new Address("bengalore", "ind")),
				new Employee(32323, "AA", 1000.00, Gender.FEMALE, new Address("bengalore", "ind")),
				new Employee(23423, "B", 2000.00, Gender.MALE, new Address("chennai", "ind")),
				new Employee(12334, "C", 3000.00, Gender.MALE, new Address("chennai", "ind")),
				new Employee(12338, "E", 5000.00, Gender.FEMALE, new Address("chennai", "ind")));

		Stream<Employee> emps = employees.stream();
		Map<Double, List<Employee>> brackets = emps.collect(Collectors.groupingBy(e -> e.getSalary() / 1000));
		System.out.println(brackets);
		
	}

}
