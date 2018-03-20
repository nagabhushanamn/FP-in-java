package com.examples;

@FunctionalInterface
interface Greeting {
	void perform();
}

class HelloWorldGreeting implements Greeting {
	@Override
	public void perform() {
		System.out.println("Hello World");
	}
}

public class Greeter {

	// public void greet() {
	// System.out.println("Hello world");
	// }

	public void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {
		
		Greeter greeter = new Greeter();
		
		Greeting helloWorlGreeting = new HelloWorldGreeting();
		Greeting innerClassGreeting=new Greeting() {
			@Override
			public void perform() {
				System.out.println("Hello World");
			}
		};
		Greeting myLambdaFunction = () -> System.out.println("Hello World from Lambda");
		
		greeter.greet(myLambdaFunction);


	}

}

