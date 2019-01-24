package com.techelevator;

import java.util.Scanner;

public class PaintCalc {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			System.out.println();
			System.out.println("[1] Add a wall");
			System.out.println("[2] Calculate paint required (and Exit)");
			System.out.print("Please choose >>> ");
			String userChoice = scan.nextLine();
			
			System.out.println();
			
			if(userChoice.equals("1")) {
				
				System.out.print("Enter wall height >>> ");
				int height = Integer.parseInt(scan.nextLine());
				System.out.print("Enter wall width >>> ");
				int width = Integer.parseInt(scan.nextLine());
				int area = height * width;
				System.out.println("Added "+height+"x"+width+" wall - "+area+" square feet");
				
			} else if(userChoice.equals("2")) {
				
				// Here we need to sum up the areas of all walls that have been entered
				System.out.println("Wall 1: 10x15 - 150 square feet"); // PROTOTYPE ONLY!!!
				System.out.println("Wall 2: 10x15 - 150 square feet"); // PROTOTYPE ONLY!!!
				System.out.println("Wall 3: 10x15 - 150 square feet"); // PROTOTYPE ONLY!!!
				System.out.println("Wall 4: 10x15 - 150 square feet"); // PROTOTYPE ONLY!!!
				
				int totalArea = 600; // PROTOTYPE ONLY!!!
				System.out.println("===============================");
				System.out.println("Total Area: "+totalArea+" square feet");
				
				// 1 gallon of paint covers 400 square feet
				float gallonsRequired = (float)totalArea / 400;
				System.out.println("Paint Required: "+gallonsRequired+" gallons");
				
				System.exit(0); // Causes the program to end
			}
		}
	}

}
