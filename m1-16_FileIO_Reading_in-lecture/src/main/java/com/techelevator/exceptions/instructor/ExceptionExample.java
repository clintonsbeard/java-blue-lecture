package com.techelevator.exceptions.instructor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("Please enter a number:");
			int number = 0;
			
			try {
				number = in.nextInt();
				
			} catch (InputMismatchException ex) {
				in.nextLine();
			}
				
			
			
			if (number != 10) {
				System.out.println("Your number is not 10, please try again!");
			} else {
				System.out.println("Your number was 10");
				break;
			}
			
			
		}
		
		
	}
	
	
}
