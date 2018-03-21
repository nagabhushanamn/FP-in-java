package com.parallel;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

import com.model.Employee;

class SalaryAdder {

	double total;

	public synchronized void accept(Employee e) {
		total += e.getSalary();
	}

	DoubleAdder doubleAdder = new DoubleAdder();

	public void accept2(Employee e) {
		doubleAdder.add(e.getSalary());
	}

}

public class Parallel {

	public static void main(String[] args) {

		double total;
		Employee[] employees = Employee.randomlyGenerate(20_000_000);

		//
		System.out.println("Staless sequential-stream");
		total = Time.timeIt(Parallel::getTotalSalarySequential, employees);
		System.out.println("Total salary: " + total);

		System.out.println();

		System.out.println("Staless parallel-stream");
		total = Time.timeIt(Parallel::getTotalSalaryParallel, employees);
		System.out.println("Total salary: " + total);

		System.out.println();

		System.out.println("statefull imperative/sequential-stream");
		total = Time.timeIt(Parallel::getTotalSalarySequential2, employees);
		System.out.println("Total salary: " + total);

		System.out.println();

		System.out.println("statefull parallel-stream & sync");
		total = Time.timeIt(Parallel::getTotalSalaryParallel2, employees);
		System.out.println("Total salary: " + total);

		System.out.println();

		System.out.println("statefull parallel-stream & no sync");
		total = Time.timeIt(Parallel::getTotalSalaryParallel3, employees);
		System.out.println("Total salary: " + total);

	}

	private static double getTotalSalarySequential(Employee[] employees) {
		return Stream.of(employees).mapToDouble(Employee::getSalary).sum();
	}

	private static double getTotalSalarySequential2(Employee[] employees) {
		SalaryAdder salaryAdder = new SalaryAdder();
		Stream.of(employees).forEach(e -> salaryAdder.accept(e));
		return salaryAdder.total;
	}

	private static double getTotalSalaryParallel(Employee[] employees) {
		return Stream.of(employees).parallel().mapToDouble((e) -> {
			return e.getSalary();
		}).sum();
	}

	private static double getTotalSalaryParallel2(Employee[] employees) {
		SalaryAdder salaryAdder = new SalaryAdder();
		Stream.of(employees).parallel().forEach(e -> salaryAdder.accept(e));
		return salaryAdder.total;
	}

	private static double getTotalSalaryParallel3(Employee[] employees) {
		SalaryAdder salaryAdder = new SalaryAdder();
		Stream.of(employees).parallel().forEach(e -> salaryAdder.accept2(e));
		return salaryAdder.doubleAdder.doubleValue();
	}

}
