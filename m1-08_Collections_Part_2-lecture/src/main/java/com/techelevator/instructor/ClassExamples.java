package com.techelevator.instructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ClassExamples {

	public static void main(String[] args) {
				
		/*
		 * Map Examples
		 */
		
		/*
		 * Map<T1, T2> name = new HashMap<T1, T2>(), where T1 is the datatype of the key
		 * and T2 is the datatype of the value 
		 */
		Map<Integer, Boolean> ourMap = new HashMap<Integer, Boolean>();
		
		/*
		 * Add key value pairs to the Map using .put(key, value)
		 */
		ourMap.put(10, true);
		ourMap.put(20, false);
		
		/*
		 * Retrieve values from the Map using .get(key)
		 */
		System.out.println("10 is " + ourMap.get(10));
		boolean valueOf20 = ourMap.get(20);
		System.out.println("20 is " + valueOf20);
		
		/* Using the same key with a different value, replaces the value */
		ourMap.put(10, false);
		System.out.println("10 is " + ourMap.get(10));
		
		if (ourMap.get(20) == false) {
			System.out.println("20 is false");
		}
		
		Map<String, String> items = new HashMap<String, String>();
		
		items.put("A1", "Chips");
		items.put("A2", "Soda");
		items.put("A3", "Candy");
		items.put("A4", "Gum");
		
		System.out.println("A1 has " + items.get("A1"));
		
		/* Values can be empty or null */
		//items.put("B1", "");
		//items.put("B2", null);
		
		
		/* 
		 * We can use a for each to loop through the keySet, which is a list of the keys
		 * in the map
		 */
		for (String key : items.keySet()) {
			System.out.println(key + " contains " + items.get(key));
			
			if (items.get(key).equals("Chips")) {
				System.out.println("Chips are at " + key);
			}
		}
		
		
		/* 
		 * Items can be removed using .remove(key)
		 */
		/*
		 * .containsKey(key) can be used to see if the map has a key with
		 * that value
		 */
		if (items.containsKey("A3") == true) {
			System.out.println("Map contains A3");
		}
		
		items.remove("A3");
		
		if (items.containsKey("A3") == false) {
			System.out.println("A3 has been removed");
		}
		
		
		/*
		 * Solve the problem in the method below
		 */
		Map<String, Integer> amountMap = new HashMap<String, Integer>();
		amountMap.put("Joe", 100);
		amountMap.put("Steve", 200);
		
		for (String key : amountMap.keySet()) {
			System.out.println(key + " Starts with $" + amountMap.get(key));
		}
		
		amountMap = giveHalfOfJoesMoneyToSteve(amountMap);
		
		for (String key : amountMap.keySet()) {
		 	System.out.println(key + " now has $" + amountMap.get(key));
		}

		/*
		 * Set Examples
		 */
		
		/*
		 * Set<T> name = new HashSet<T>, where T is the datatype the set will hold
		 * HashSet does not preserve order
		 * Sets only allow unique values
		 * If we add a duplicate value, it does not error but is not not added
		 */
		Set<Integer> numbers = new HashSet<Integer>();
		numbers.add(10);
		numbers.add(12);
		numbers.add(10); // If we add a duplicate value, it does not error but is not added
		numbers.add(10);
		numbers.add(8);
		numbers.add(502);
		
		System.out.println(numbers.size());
		
		/*
		 * Set has not get method and the items cannot be accessed by index, so we must use
		 * for each to get the values
		 */
		for (Integer i : numbers) {
			System.out.println(i);
		}
		
		/*
		 * TreeSet works like HashSet, but maintains natural order
		 */
		Set<Integer> numberTree = new TreeSet<Integer>();
		numberTree.add(10);
		numberTree.add(12);
		numberTree.add(10); // If we add a duplicate value, it does not error but is not added
		numberTree.add(10);
		numberTree.add(8);
		numberTree.add(502);
		
		System.out.println(numberTree.size());
		
		/*
		 * Set has not get method and the items cannot be accessed by index, so we must use
		 * for each to get the values
		 */
		for (Integer i : numberTree) {
			System.out.println(i);
		}

	}
	
	/*
	 * For the map amountMap, it contains key Joe and Steve and the amount of money each one has
	 * Give half of Joe's Money to Steve and return the map with the new values
	 */
	public static Map<String, Integer> giveHalfOfJoesMoneyToSteve(Map<String, Integer> amountMap) {
		
		int halfOfJoesMoney = amountMap.get("Joe") / 2;

		
		//       Updating Steve Money 		Getting Steve's Original Money
		amountMap.put("Steve", 			amountMap.get("Steve") + halfOfJoesMoney);
		amountMap.put("Joe",  amountMap.get("Joe") - halfOfJoesMoney);
		return amountMap;
	}

}
