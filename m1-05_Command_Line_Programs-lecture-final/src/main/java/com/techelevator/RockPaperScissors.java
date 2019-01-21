package com.techelevator;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	/*
	 * Command Line programs follow this structure: Take Input, Calculate Data, Give
	 * Output
	 * 
	 * How could we use this structure, with what we know of Java, so far, to write
	 * a simple game like Rock, Paper, Scissors?
	 */
	public static void main(String[] args) {

		String[] choices = { "Rock", "Paper", "Scissors" };

		int userScore = 0;
		int computerScore = 0;
		int ties = 0;
		
		Scanner in = new Scanner(System.in);
		Random randomGenerator = new Random();
		
		while (true) {

			System.out.print("Select (R)ock, (P)aper, (S)cissors, or (Q)uit.  Choose Wisely >>>");
			String userChoice = in.nextLine().toUpperCase();
			
			if (userChoice.equals("Q")) {
				System.out.println();
				System.out.println("Final Score");
				System.out.println("------------------------------------------");
				System.out.printf(" %-10s%-10s%-10s ", "Player", "Computer", "Tie");
				System.out.println();
				System.out.printf(" %-10s%-10s%-10s ", userScore, computerScore, ties);
				System.out.println();
				System.out.println("Thank you for playing!");
				break;
			}

			int randomNumber = randomGenerator.nextInt(3);
			String computerChoice = choices[randomNumber];

			System.out.println("The computer chose " + computerChoice);

			switch (userChoice) {
			case "R":
				if (computerChoice.equals("Rock")) {
					ties++;
					System.out.println("It's a TIE");
				} else if (computerChoice.equals("Paper")) {
					computerScore++;
					System.out.println("The computer wins");
				} else if (computerChoice.equals("Scissors")) {
					userScore++;
					System.out.println("You win!");
				}
				break;
			case "P":
				if (computerChoice.equals("Rock")) {
					userScore++;
					System.out.println("You win!");
				} else if (computerChoice.equals("Paper")) {
					ties++;
					System.out.println("It's a Tie");
				} else if (computerChoice.equals("Scissors")) {
					computerScore++;
					System.out.println("The computer wins");
				}
				break;
			case "S":
				if (computerChoice.equals("Rock")) {
					computerScore++;
					System.out.println("Computer wins");
				} else if (computerChoice.equals("Paper")) {
					userScore++;
					System.out.println("You win!");
				} else if (computerChoice.equals("Scissors")) {
					ties++;
					System.out.println("It's a Tie");
				}
				break;
			default:
				System.out.println("I don't know what that is!");
				break;
			}
		}

	}

}
