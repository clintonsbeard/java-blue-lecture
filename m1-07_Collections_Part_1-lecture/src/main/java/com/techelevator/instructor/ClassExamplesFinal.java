package com.techelevator.instructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClassExamplesFinal {

	public static void main(String[] args) {
		
		// without import
		//java.time.LocalDateTime currentDateTime = java.time.LocalDateTime.now();
		//System.out.println(currentDateTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")));

		// With import
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
	}

}
