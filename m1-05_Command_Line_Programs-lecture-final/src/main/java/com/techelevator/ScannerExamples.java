package com.techelevator;

import java.util.Scanner;

public class ScannerExamples {

	public static void main(String[] args) {
		
		/*
		 * Command line programs usually follow this work flow:   Take Data, Calculate Data, Give Results
		 * 
		 * How can we do each of these steps?
		 */

		
		
		/*
		 * To read user input from the command line, we can use a Scanner, which
		 * we need to pass the System.in inputStream.  
		 */
		/* ADD CODE TO CREATE A SCANNER AND ASK THE USER THEIR NAME */
		Scanner in = new Scanner(System.in);
		System.out.println("What is your name?");
		
		/* 
		 * We use the Scanner nextLine() method to get the input from the user as
		 * a String.  This gets all values the user types up until and including the Enter/Return.
		 */
		/* ADD CODE TO GET THE USERS NAME AND DISPLAY IT */
		String username = in.nextLine();
		System.out.println("You said your name is " + username);
		
		
		/*
		 * We can also use other methods of scanner like nextInt() to get input from the user
		 * and have it automatically parsed to that datatype.  This will not include the Enter/Return
		 * character, which will be left on the inputStream and must be cleaned up to continue.
		 * 
		 * If the character the user enters is not a valid value for the data type, the user will
		 * see an Exception.
		 */
		/* ADD CODE TO GET THE NEXT USERS NUMBER AND DISPLAY IT */
		System.out.print("Enter a number: ");
		int userNumber = in.nextInt();
		in.nextLine();
		System.out.println("Your number is " + userNumber);
		
		
		// We can also get a number as a String and then parse it using the desired datatypes parse function
		/* ADD CODE TO GET THE USER DOLLAR AMOUNT */
		System.out.print("Enter a dollar amount:" );
		String dollarString = in.nextLine();
		
		/*
		 * We convert the string by calling the parse method on the datatype we wish to convert.  The string must only contain
		 * characters that are valid for that datatype, otherwise the user will recieve an exception.  
		 * 
		 * Some examples (there are many others)
		 * 		Integer.parseInt(string s);
		 *		Long.parseLong(string s);
		 * 		Double.parseDouble(string s);
		 * 		Boolean.parseBoolean(string s);
		 *
		 */
		/* ADD CODE TO PARSE THE USER ENTERED DOUBLE */
		double amount = Double.parseDouble(dollarString);
		double tax = .075;
		double total = amount + (amount * tax);

		/* ADD CODE TO ADD TAX TO THE AMOUNT AND DISPLAY IT */
		System.out.println("Your total is: " + total);
		
		/*
		 * If you want to display formatted values we can use the printf function with a formatter.
		 * 
		 * Each formatter has a specifier that starts with a % and ends with a code for the type.  Between the % and the code 
		 * are details of how to format the resulting string.
		 * 
		 * Example:  %4.2f  - format a floating point number (float or double) with a minimum of 4 characters before the decimal point and 2 
		 * after the decimal point.  -->  1234.00
		 * 
		 * The two most common specifiers are:
		 * 		%f  - floating point
		 *      %s  - string of characters
		 *      
		 * The formatter is put into the String where you want the data to be placed, and the value to format comes after a comma following
		 * the string.
		 */
		/* ADD CODE THAT DISPLAYS TWO ITEMS IN A FORMATTED LIST.  THE FIRST SHOULD SHOW THE USER SUPPLIED PRICE 
		 * AND CALCULATED TAX.    
		 * 	
		 * EXAMPLE:
		 *  Item        Price   Tax   Total 
		 *	---------------------------------
		 *	Book        $12.77  $0.08  $13.73 
		 * 	Record      $5.76  $0.43  $6.19 
		 */
		
		System.out.println();
		System.out.printf("%-10s", "Item");
		System.out.printf("  %-2s ", "Price");
		System.out.printf("  %-2s ", "Tax");
		System.out.printf("  %-2s ", "Total");
		System.out.println("\n---------------------------------");
		
		System.out.printf("%-10s", "Book");
		System.out.printf("  $%-4.2f ", amount);
		System.out.printf("  $%-4.2f ", tax);
		System.out.printf("  $%-4.2f ", total);
		
		System.out.println();
		System.out.printf("%-10s", "Record");
		System.out.printf("  $%4.2f ", 5.76);
		System.out.printf("  $%4.2f ", 0.43);
		System.out.printf("  $%4.2f ", 6.19);
		
		
		
	}

}
