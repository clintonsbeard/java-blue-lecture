package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26;
		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half;
		half = 0.5;

		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "TechElevator";
		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		byte seasonsOfFirefly = 1;
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.1416;
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String yourName = "Brian Lauvray";
		System.out.println(yourName);
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numberOfButtonsOnMouse = 2;
		
		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		int phoneBatteryPercentage = 23;
		
		
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int difference = 121 - 27;
		
		int numberOne = 121;
		int numberTwo = 27;
		
		difference = numberOne - numberTwo;
		System.out.println(difference);
		
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double doubleSum = 12.3 + 32.1;
		System.out.println(doubleSum);
		/*
		12. Create a String that holds your full name.
		*/
		String firstName = "John";
		String lastName = "Doe";
		String fullName = firstName + " " + lastName;
		System.out.println(fullName);
		
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String helloName = "Hello, " + fullName;
		System.out.println(helloName);
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		fullName = fullName + " Esquire";
		System.out.println(fullName);
		System.out.println(helloName);
				
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		fullName += " Equire";
		System.out.println(fullName);
		
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String movieTitle = "Saw" + 2;
		System.out.println(movieTitle);
		
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		movieTitle = movieTitle + 0;
		System.out.println(movieTitle);
		/*
		18. What is 4.4 divided by 2.2?
		*/
		double result = 4.4 / 2.2;
		System.out.println(result);
		/*
		19. What is 5.4 divided by 2?
		*/
		float resultTwo = 5.4f / 2;
		System.out.println(resultTwo);
		
		/*
		20. What is 5 divided by 2?
		*/
		
		int five = 5;
		int two = 2;
		
		double halfOfFive = (double) five / two;
		System.out.println(halfOfFive);
		/*
		21. What is 5.0 divided by 2?
		*/
		double halfOfFiveAgain = 5.0 /2;
		System.out.println(halfOfFiveAgain);
		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		double remainder = 66.6 / 100;
		System.out.println(remainder);
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		int mod = 5 % 2;
		System.out.println(mod);
		/*
		24. What is 1,000,000,000 * 3?
		*/
		int t = 1000000000;
		long z = (long) t * 3;
		System.out.println(z);
		
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean isDoneWithExercises = false;
		System.out.println(isDoneWithExercises);
		/*
		26. Now set doneWithExercise to true.
		*/
		isDoneWithExercises = true;
		System.out.println(isDoneWithExercises);
		
	}

}
