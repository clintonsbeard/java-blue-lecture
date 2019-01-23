package com.techelevator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ClassExamples {

	public static void main(String[] args) {
		
		/* WITHOUT IMPORT
		 * java.time.LocalDateTime currentDateTime = java.time.LocalDateTime.now();
		 * System.out.println(currentDateTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		 * 
		 * WITH IMPORT */

		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		List<String> names = new ArrayList<String>();
		names.add("John");
		names.add("Bob");
		names.add("Sue");
		names.add("Jane");
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		names.remove("Bob");
		System.out.println(names.size());
		
		names.set(0, "Sally");
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		if (names.contains("Sue")) {
			System.out.println("List Contains Sue");
		}
		
		if (names.contains("Joe") == false) {
			System.out.println("List Does Not Contain Joe");
		}
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		Integer z = numbers.get(0) + 5;
		System.out.println(z);
		
		List<Boolean> booleans = new ArrayList<Boolean>();
		booleans.add(true);
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		System.out.println("\n--------------------------------\n");
		
		for (String currentName : names) {
			System.out.println(currentName);
		}
		
		int[] nums = {1, 2, 3, 4, 5};
		for (int number : nums) {
			System.out.println(number);
		}
		
		List<Integer> iNums = new ArrayList<Integer>();
		
		iNums.add(6);
		iNums.add(7);
		iNums.add(8);
		
		for (int number : iNums) {
			System.out.println(number);
		}
		
		iNums.add(9);
		iNums.add(10);
		
		for (Integer number : iNums) {
			System.out.println(number);
		}
		
		System.out.println("\n---------------------------------\n");
		
		Queue<String> ourQueue = new LinkedList<String>();
		ourQueue.offer("Joe");
		ourQueue.offer("Nancy");
		ourQueue.offer("Jill");
		
		for (String name : ourQueue) {
			System.out.println(name);
		}
		
		String next = ourQueue.poll();
		System.out.println("Now serving " + next + ".");
		
		ourQueue.offer("Bill");
		
		String whoIsNext = ourQueue.peek();
		System.out.println(whoIsNext + " is next in line.");	
		
		while(ourQueue.isEmpty() == false) {
			System.out.println(ourQueue.poll());
		}
		
		System.out.println("\n---------------------------------\n");
		
		Stack<String> ourStack = new Stack<String>();
		
		ourStack.push("Bob");
		ourStack.push("Steve");
		ourStack.push("Paul");
		
		while(ourStack.isEmpty() == false) {
			System.out.println(ourStack.pop());
		}
	
	}
}