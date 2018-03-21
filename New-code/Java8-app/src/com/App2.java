package com;

import java.time.LocalTime;
import java.util.Objects;

public class App2 {

	public static void main(String[] args) {
		 System.out.println(composeHashCodes("hello", "world"));
//		System.out.println(composeHashCodes2("hello", null));
	}

	// slow
	public static String getApplicationShtate() {
		System.out.println("getApplicationState");
		return "It's " + LocalTime.now();
	}

	private static int composeHashCodes(String string1, String string2) {
		Objects.requireNonNull(string1, "string1 may not be null! " + getApplicationShtate());
		Objects.requireNonNull(string2, "string2 may not be null! " + getApplicationShtate());
		return string1.hashCode() ^ string2.hashCode();
	}

	private static int composeHashCodes2(String string1, String string2) {
		Objects.requireNonNull(string1, () -> "string1 may not be null! " + getApplicationShtate());
		Objects.requireNonNull(string2, () -> "string2 may not be null! " + getApplicationShtate());
		return string1.hashCode() ^ string2.hashCode();

	}

}
