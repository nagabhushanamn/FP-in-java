package com;

import java.util.Arrays;
import java.util.List;

import com.lib.ItemsLib;
import com.model.Employee;
import com.model.Gender;

public class App {
	
	public static void main(String[] args) {
		
		List<Employee> employees=Arrays.asList(
				new Employee(32323, "A", 1000.00, Gender.FEMALE),
				new Employee(23423, "B", 2000.00, Gender.MALE),
				new Employee(12334, "C", 3000.00, Gender.MALE),
				new Employee(53555, "D", 4000.00, Gender.FEMALE)
				);
		
		//----------------------------------------------------------
		
		//ItemsLib.forEach(employees, System.out::println);
		//ItemsLib.forEach(employees, e->System.out.println(e.getName()+"\t"+e.getSalary()));
		
		List<Employee> females=ItemsLib.filter(employees, item->item.getGender()==Gender.FEMALE);
		//List<String> femaleNames=ItemsLib.map(females, item->item.getName());
		List<String> femaleNames=ItemsLib.map(females, Employee::getName);
		ItemsLib.forEach(femaleNames, System.out::println);
		
		
		
	}

}
