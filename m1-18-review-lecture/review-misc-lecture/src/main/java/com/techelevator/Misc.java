package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Misc {

	public static void main(String[] args) {
		//changeArrayExample();
		Person personObj = new Person("Steve");
	}
	
	private static void convertArrayToList() {
		
		String[] inputArray = { "Steve", "Andrew", "John" };
		
		List<String> outputList = new ArrayList<String>();
		
		for( int i = 0; i < inputArray.length; i++) {
			outputList.add(inputArray[i]);
		}
		
	}
	
	private static void convertArrayToListPart2() {
		String[] inputArray = { "Steve", "Andrew", "John" };
		List<String> outputList = Arrays.asList(inputArray);
	}
	
	private static void convertAListToAnArray() {
		List<String> inputList = new ArrayList<String>();
		inputList.add("Steve");
		inputList.add("Andrew");
		inputList.add("John");
		
		String[] outputArray = inputList.toArray(new String[inputList.size()]);
	}
	
	
	private static void forEachExample() {
		String[] inputArray = { "Steve", "Andrew", "John" };
		
		for (String name : inputArray) {
			System.out.println(name);
		}
	}
	
	private static void changeArrayExample() {
		String[] inputArray = { "Steve", "Andrew", "John" };
		
		String[] newArray = new String[inputArray.length - 1];
		
		int j = 0;
		for (int i = 0;  i < inputArray.length - 1; i++) {
			if (inputArray[i].equals("Steve")) {
				newArray[j] = "Rachelle";
				j++;
			} else if (!inputArray[i].equals("John")) {
				newArray[j] = inputArray[j];
				j++;
			}
		}
		
		
		
	}
	

}
