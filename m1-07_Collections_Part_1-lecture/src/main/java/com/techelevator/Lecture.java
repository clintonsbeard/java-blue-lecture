package com.techelevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List<String> names = new ArrayList<String>();
		names.add("Frodo");
		names.add("Sam");
		names.add("Pippin");
		names.add("Merry");
		names.add("Gandalf");
		names.add("Aragorn");
		names.add("Boromir");
		names.add("Gimli");
		names.add("Legolas");
		
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		//the elements will be returned in the same order they were added
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		names.add("Sam");
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		names.add(2, "David");
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		names.remove(2);
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");	

		boolean inList = names.contains("Samwise");
		System.out.println("Samwise is in the list of names: " + inList);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
	
		String[] namesArray = names.toArray(new String[names.size()]);
		for(int i = 0; i < namesArray.length; i++) {
			System.out.println(namesArray[i]);
		}

		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");
		
		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation 
		 * of a primitive value */
		Integer employees = new Integer(25);       // here we call a constructor that "wraps" a primitive int value in an object
		Integer piecesOfCake = new Integer("24");  // here we call a constructor that converts a String into an Integer
		
		if(employees > piecesOfCake) {
			System.out.println("Burn the building down");
		}
		
		Double accountBalance = null;
		// double newBalance = accountBalance + 100;  // this causes a NullPointerException because we are trying to "unbox" a null value

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		// Let's loop through names again, but this time using a for-each loop
		    // for each name in names
		for(String name : names) {
			// print the name
			System.out.println(name);
		}
		
		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();

		Queue<String> priorities = new LinkedList<String>();

		priorities.offer("Clean the dishes");
		priorities.offer("Wash the counters");
		priorities.offer("Sweep the floor");
		priorities.offer("Scrub the floor");

		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////
		while (priorities.size() > 0) {
			String nextPriority = priorities.poll();
			System.out.println("NEXT PRIORITY " + nextPriority);
		}

		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();

		Stack<String> browserStack = new Stack<String>();

		////////////////////
		// PUSHING ITEMS TO THE STACK
		//////////////////// 
		browserStack.push("http://www.google.com");
		browserStack.push("http://www.cnn.com");
		browserStack.push("http://www.google.com");
		browserStack.push("http://www.techelevator.com");
		browserStack.push("http://www.si.com");

		////////////////////
		// POPPING THE STACK
		////////////////////
		while(browserStack.size() > 0)
		{
			String previousPage = browserStack.pop();
			System.out.println("PREVIOUS PAGE: " + previousPage);
		}
	}
}
