package com.techelevator;

public class InClassExampleFinal {

	public static void main(String[] args) {
	
		String str ="TechElevator";
		/*
		 * charAt returns the character at a given index in the String
		 */
	
		char c = str.charAt(4);
		System.out.println(c);
		
		/*
		 * length returns the count of the characters in the string
		 */
		int length = str.length();
		System.out.println(length);
		
		/*
		 * substring - returns part of a string, where the first number is the beginning index (inclusive) and the
		 * second number is the ending index (exclusive)
		 */
		String sub = str.substring(2,  5);
		System.out.println(sub);
		
		// To get the end of the string, just give the starting index
		String tor = str.substring(9);
		System.out.println(tor);
		
		/*
		 * contains(), startsWith(), endsWith()
		 */
		boolean contains = str.contains("El");
		if (contains) {
			System.out.println("El " + contains);
		}
		contains = str.contains("el");
		if (contains == false) {
			System.out.println("el " + contains);
		}
		
		/*
		 * toUpperCase(), toLowerCase()
		 */
		String upperCaseStr = str.toUpperCase();
		System.out.println("Original " + str);
		System.out.println("Upper " + upperCaseStr);
		System.out.println(str.toUpperCase());
		
		/*
		 * indexOf() - gives index of first occurrence
		 */
		int index = str.indexOf("El");
		System.out.println(index);
		
		/*
		 * replace()
		 */
		String replace = str.replace("e", "-");
		System.out.println(replace);
		
		/*
		 * trim() - removes leading and ending spaces
		 */
		String trim = " Hello ".trim();
		System.out.println("::" + trim + "::");
		
		/*
		 * split() 
		 */
		String nums = "One two three four";
		String[] splitString = nums.split(" ");
		//System.out.println(splitString);
		
		/*
		 * join()
		 */
		String one = "One";
		String three = "Three";
		String joined = String.join(" < ", one, "Two", three, "Four");
		System.out.println(joined);
		
		
		char[] awesomeArray = new char[] { 'A', 'w', 'e', 's', 'o','m','e' };
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
