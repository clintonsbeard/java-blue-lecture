package com.techelevator.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileAccess {

	
	public String readFileAsString(String inputFile, Charset encoding) throws IOException {	
		byte[] fileAsBytes = Files.readAllBytes(Paths.get(inputFile));	
		return new String(fileAsBytes, encoding);
	}
	
	public void writeFileFromString(String output, String filename) throws FileNotFoundException {
		
		try (PrintWriter out = new PrintWriter(filename)) {
			out.print(output);
		}	
	}
	
}
