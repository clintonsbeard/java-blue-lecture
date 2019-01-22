package com.techelevator;

public class InClassExample {

	public static void main(String[] args) {
		
		/* charAt returns the character at a given index in the String */
		
		String str = "TechElevator";
		char c = str.charAt(4);
		System.out.println(c);
		
		/* length returns the count of characters in the String */
		
		int length = str.length();
		System.out.println(length);
		
		/* substring returns a part of a String (AKA indexes inside the array) */
		
		String sub = str.substring(2, 5); /* 2 is beginning index (inclusive), 5 is ending index (exclusive) */
		System.out.println(sub);
		
		/* String tor = str.substring(9, 12);
		System.out.println(tor); Don't do this because your ending index is one above the max even though it technically works */
		
		String tor = str.substring(9);
		System.out.println(tor);
		
		/* contains(), startsWith(), endsWith() */
		
		boolean contains = str.contains("El");
		if (contains) {
			System.out.println("El " + contains);
		}
		contains = str.contains("el");
		if (contains == false) {
			System.out.println("el " + contains);
		}
		boolean startsWith = str.startsWith("Te");
		if (startsWith) {
			System.out.println("Te " + startsWith);
		}
		boolean endsWith = str.endsWith("or");
		if (endsWith) {
			System.out.println("or " + endsWith);
		}
		
		/* toUpperCase(), toLowerCase() */
		
		String upperCaseStr = str.toUpperCase();
		System.out.println("Original " + str);
		System.out.println("Upper " + upperCaseStr);
		System.out.println(str.toUpperCase());
		
		String lowerCaseStr = str.toLowerCase();
		System.out.println("Original " + str);
		System.out.println("Lower " + lowerCaseStr);
		
		/* equalsIgnoreCase */
		
		/* indexOf(): Gives index of first occurrence */
		
		int index = str.indexOf("e");
		System.out.println(index);
		
		int capitalIndex = str.indexOf("E");
		System.out.println(capitalIndex);
		
		int lastIndex = str.indexOf("ev");
		System.out.println(lastIndex);
	
		/* replace(): Replaces String with different String */
		
		String replace = str.replace("e", "-");
		System.out.println(replace);
		
		/* trim(): Removes leading and ending spaces */
		
		String trim = " Hello ".trim();
		System.out.println("::" + trim + "::");
		
		/* split(): Splits a string into an array */
		
		String nums = "One two three four";
		String[] splitString = nums.split(" ");
		
		/* JUST System.out.println(splitString); will print its address in the heap and NOT the information inside */
	
		/* join(): Joins Strings together into a larger String */
		
		String one = "One";
		String three = "Three";
		String joined = String.join(", ", one, "Two", three, "Four");
		System.out.println(joined);	
	
		char[] awesomeArray = new char[] { 'A', 'w', 'e', 's', 'o', 'm', 'e' };
		System.out.println(awesomeArray);
		String awesomeString1 = new String(awesomeArray);
		System.out.println(awesomeString1);
		String awesomeString2 = new String(awesomeArray);
		if (awesomeString1.equals(awesomeString2)) {
			System.out.println("Equal");
		}
		String awesomeString3 = awesomeString1;
		if (awesomeString1 == awesomeString3) {
			System.out.println("1 and 3 are ==");
		}
		if (awesomeString1.equals(awesomeString3)) {
			System.out.println("1 and 3 are .equals");
		}
	}
}