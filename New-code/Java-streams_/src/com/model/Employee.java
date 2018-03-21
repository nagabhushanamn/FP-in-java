package com.model;

import java.util.Random;
import java.util.stream.Stream;

public class Employee {

	private int id;
	private String name;
	private double salary;
	private Gender gender;
	
	private Address address;

	public Employee(int id, String name, double salary, Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
	}
	
	

	public Employee(int id, String name, double salary, Gender gender, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.address = address;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", gender=" + gender + "]";
	}
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	private static Random rand = new Random();
	public static Employee[] randomlyGenerate(int n) {
		return Stream.generate(() -> {
			String name = "IBM-employee";
			int rn=rand.nextInt();
			return new Employee(rn,name, rand.nextInt(1000),Gender.MALE);
		}).limit(n).toArray(Employee[]::new);
	}

}










