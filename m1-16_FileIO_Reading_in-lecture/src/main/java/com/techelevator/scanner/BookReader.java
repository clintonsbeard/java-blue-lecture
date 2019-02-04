package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookReader {

	public static void main(String[] args) throws FileNotFoundException {

		int wordCount = 0;
		int sentenceCount = 0;
		
		File inputFile = getFileFromUser();	
		
		try (Scanner fileIn = new Scanner(inputFile)) {
			
			while (fileIn.hasNextLine()) {
				String line = fileIn.nextLine();
				String[] words = line.split(" ");
				wordCount += words.length;
			}
			System.out.println( );
		} 
		catch (FileNotFoundException e) {
			throw e;
		}
	}
	
//	alices_adventures_in_wonderland.txt

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