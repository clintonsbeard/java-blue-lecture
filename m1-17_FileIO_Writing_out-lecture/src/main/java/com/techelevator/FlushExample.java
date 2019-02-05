package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FlushExample {

	/*
	 * Once you run this, you must stop it with the Red stop button on the Eclipse Console.
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		
		String filename = "bufferTest.txt";
		File file = new File(filename);
		
		String message="This is line ";
		int lineCount = 0;
		
		try (PrintWriter printWriter = new PrintWriter(file);
				BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {
			
			while (true) {
				bufferedWriter.write(message + lineCount++ + "\n");
				//Thread.sleep(500);
				bufferedWriter.flush();
				
			}
		}
		
	}

}
