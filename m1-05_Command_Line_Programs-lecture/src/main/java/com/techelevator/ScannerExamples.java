package com.techelevator;

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

		
		/* 
		 * We use the Scanner nextLine() method to get the input from the user as
		 * a String.  This gets all values the user types up until and including the Enter/Return.
		 */
		/* ADD CODE TO GET THE USERS NAME AND DISPLAY IT */

		
		
		/*
		 * We can also use other methods of scanner like nextInt() to get input from the user
		 * and have it automatically parsed to that datatype.  This will not include the Enter/Return
		 * character, which will be left on the inputStream and must be cleaned up to continue.
		 * 
		 * If the character the user enters is not a valid value for the data type, the user will
		 * see an Exception.
		 */
		/* ADD CODE TO GET THE NEXT USERS NUMBER AND DISPLAY IT */

		
		
		// We can also get a number as a String and then parse it using the desired datatypes parse function
		/* ADD CODE TO GET THE USER DOLLAR AMOUNT */

		
		
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


		/* ADD CODE TO ADD TAX TO THE AMOUNT AND DISPLAY IT */

		
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
		
		
		
	}

}
