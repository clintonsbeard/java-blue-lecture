package com.techelevator;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	/*
	 * Command Line programs follow this structure:  Take Input, Calculate Data, Give Output
	 * 
	 * How could we use this structure, with what we know of Java, so far, to write a simple game
	 * like Rock, Paper, Scissors?
	 */
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		Random randomGenerator = new Random();
		
		String[] choices = {"Rock", "Paper", "Scissors"};
		
		int userScore = 0;
		int computerScore = 0;
		int tieScore = 0;
		
		while (true) {
			
			System.out.print("Select (R)ock, (P)aper, or (S)cissors.  Choose wisely: ");
			String userChoice = in.nextLine().toUpperCase();
			
			if (userChoice.equals("Q")) {
				System.out.println("Final Score:");
				System.out.println("------------------------------");
				System.out.printf("%1s%14s%10s", "Player", "Computer", "Tie");
				System.out.println();
				System.out.printf("%1s%12s%15s", userScore, computerScore, tieScore);
				break;
			}
			
			int randomNumber = randomGenerator.nextInt(3);
			
			String computerChoice = choices[randomNumber];
			
			System.out.println("Mr. Computer chose " + computerChoice);
			
			switch (userChoice) {
				case "R":
					if (computerChoice.equals("Rock")) {
						System.out.println("Tie!");
						tieScore++;
					}
					if (computerChoice.equals("Paper")) {
						System.out.println("You lose!  The Sheriff of Computer Falls has shot you between the eyes.");
						computerScore++;
					}
					if (computerChoice.equals("Scissors")) {
						System.out.println("You win!  Mr. Computer's widow requests his remains, but you just laugh and spit in her face.");
						userScore++;
					}
					break;
				case "P": 
					if (computerChoice.equals("Rock")) {
						System.out.println("You are victorious!  You and Sir Computer are both Highlanders, so you then experience a quickening.");
						userScore++;
					}
					if (computerChoice.equals("Paper")) {
						System.out.println("Tie!  Dr. Computer's choices are randomly generated, so don't feel bad.");
						System.out.println("...actually, you should feel pretty bad.");
						tieScore++;
					}
					if (computerChoice.equals("Scissors")) {
						System.out.println("You are defeated!  Computersaurus Rex swallows you in one bite and by tomorrow morning, all your favorite memories and human experiences are just a giant pile of shit on the ground.");
						computerScore++;
					}
					break;
				case "S":
					if (computerChoice.equals("Rock")) {
						System.out.println("You chose poorly.  Captain Computer lifts his rock up over his head and dashes your brains in upon the rocks.  Your remains then rot in the sun, creating an awful mess.");
						userScore++;
					}
					if (computerChoice.equals("Paper")) {
						System.out.println("You wipe the bits and bytes off your blade after splitting your opponent in twain.");
						computerScore++;
					}
					if (computerChoice.equals("Scissors")) {
						System.out.println("You both chose scissors!  I would normally make an off-color joke here, but this is a family game.");
						tieScore++;
					}
					break;
				case "Q":
					break;
				default:
					System.out.println("Don't act so dense.  Choose R, P or S if you're man enough or choose Q if you're the coward I know you are.");
					break;
			}

		}
	}
}
