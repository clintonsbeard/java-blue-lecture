package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class ClassExamples {

	public static void main(String[] args) {
		
		/*
		 * Map Examples
		 */
		
		/*
		 * Map<T1, T2> name = new HashMap<T1, T2>(), where T1 is the datatype of the key
		 * and T2 is the datatype of the value 
		 */

		
		/*
		 * Add key value pairs to the Map using .put(key, value)
		 */

		
		/*
		 * Retrieve values from the Map using .get(key)
		 */


		/* Using th same key with a different value, replaces the value */

		
		/* Values can be empty or null */

		
		/* 
		 * We can use a for each to loop through the keySet, which is a list of the keys
		 * in the map
		 */

		
		/* 
		 * Items can be removed using .remove(key)
		 */

		
		/*
		 * .containsKey(key) can be used to see if the map has a key with
		 * that value
		 */

		
		/*
		 * Set Examples
		 */

		/*
		 * Set<T> name = new HashSet<T>, where T is the datatype the set will hold
		 * HashSet does not preserve order
		 * Sets only allow unique values
		 * If we add a duplicate value, it does not error but is not not added
		 */

		
		/*
		 * Set has not get method and the items cannot be accessed by index, so we must use
		 * for each to get the values
		 */

		
		/*
		 * TreeSet works like HashSet, but maintains natural order
		 */

		
		
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
	}
	
	public static Map<String, Integer> giveHalfOfJoesMoneyToSteve(Map<String, Integer> amountMap) {
		
		
		return null;
	}

}
