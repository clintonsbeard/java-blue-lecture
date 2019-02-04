package com.techelevator.scanner.instructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookReader {
												// Either by adding throws
	public static void main(String[] args) throws FileNotFoundException {
		
		int startingLine = 116;
		int lineCount = 500;
		
		File inputFile = getFileFromUser();

		try (Scanner fileIn = new Scanner(inputFile)) {
			
			int lineNumber = 0;
			while (fileIn.hasNextLine() && lineNumber < lineCount) {
				String line = fileIn.nextLine();
				lineNumber++;
				if (lineNumber > startingLine) {
					System.out.println(lineNumber + " : " + line);
				}
			}
			
			
		} catch (FileNotFoundException e) {  // or adding a catch
			// Caught exceptions can be re-thrown
			throw e;
		}
		
	}

	private static File getFileFromUser() {
		
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		if(inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
		
	}
	
}
