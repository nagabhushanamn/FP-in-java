package com.examples;

public class TypeInferenceExample {

	public static void main(String[] args) {

		// StringLengthLambda myLambda = s -> s.length();
		// int len = myLambda.getLength("Hello Lambda");
		// System.out.println(len);

		printLambda(s -> s.length());

	}

	public static void printLambda(StringLengthLambda lambda) {
		System.out.println(lambda.getLength("Hello Lambda"));
	}

	interface StringLengthLambda {
		int getLength(String s);
	}

}
