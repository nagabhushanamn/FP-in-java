package com.examples;

public class RunnableExample {

	public static void main(String[] args) {

		Thread myThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Printed inside runnable");
			}
		});
		myThread.start();

		Thread mylambdaThread = new Thread(() -> System.out.println("Printed inside Lambda Runnable"));
		mylambdaThread.start();

	}

}
