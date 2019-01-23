package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();
		
		Map<String, String> nameToZip = new HashMap<String, String>();  // Map is an interface and HashMap is a class that implements Map
		
		/* The "put" method is used to add elements to a Map */
		nameToZip.put("David", "44120");
		nameToZip.put("Dan", "44124");
		nameToZip.put("Elizabeth", "44012");
		
		/* The "get" method is used to retrieve elements from a Map */
		System.out.println("David lives in "+nameToZip.get("David"));
		System.out.println("Dan lives in "+nameToZip.get("Dan"));
		System.out.println("Elizabeth lives in "+nameToZip.get("Elizabeth"));
		System.out.println();
		
		System.out.println("We can also retrieve a Set of keys and iterate over them using a for loop:");
		Set<String> keys = nameToZip.keySet();		// returns a Set of all of the keys in the Map
		for(String name : keys) {
			System.out.println(name+" lives in "+nameToZip.get(name));
			
		}
		System.out.println();
		
		System.out.println("put 12345 for key David\n");
		nameToZip.put("David", "12345");  // The key "David" already exists, so this line will overwrite the existing value with the new value
		for(String name : keys) {
			System.out.println(name+" lives in "+nameToZip.get(name));
		}
		System.out.println();
		
		nameToZip.remove("David");	
		System.out.println("removed David\n");
		for(String name : keys) {
			System.out.println(name+" lives in "+nameToZip.get(name));
		}
		System.out.println();
				
		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();
		
		Set<String> students = new HashSet<String>();  // change HashSet to TreeSet or LinkedHashSet to see how the behavior changes
		
		System.out.println("####################");
		System.out.println("Sets cannot contain duplicates");
		System.out.println("####################");
		System.out.println();

		students.add("Jim");
		System.out.println("Added Jim");
		students.add("Seth");
		System.out.println("Added Seth");
		students.add("Dan");
		System.out.println("Added Dan");
		students.add("Jim");  // this value will be ignored because it is duplicate
		System.out.println("Added Jim again");
		System.out.println();
		
		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();

		System.out.println("Set of students contains:");
		for(String studentName : students) { // note that the values are returned in a different order than they were added
			System.out.println(studentName+" : Hash = "+studentName.hashCode());
		}
		System.out.println();
		System.out.println("note that the values may be returned in a different order than they were added");
		System.out.println();
		
	}

}
