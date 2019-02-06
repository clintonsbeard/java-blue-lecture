package com.techelevator.quiz;

import java.util.Scanner;

import com.techelevator.quiz.menu.Menu;
import com.techelevator.quiz.reader.FileQuizReader;
import com.techelevator.quiz.reader.QuizReader;

public class QuizStart {
	
	
	/*
	 * JOB: Setups up and starts the Application.
	 */
	public void startQuiz() {
		
		// Create a Menu Object
		Menu menu = new Menu(new Scanner(System.in), System.out);
		
		// Get the users name and the file name, using that menu object
		String user = menu.getUserName();
		String filename = menu.getQuizFileFromUser();
		
		// Create a FileReader Object, passing it the filename
		QuizReader quizReader = new FileQuizReader(filename);
	
		// Create a QuizRunner object and pass it the menu and the File Reader
		QuizRunner quizRunner = new QuizRunner(menu, quizReader);
		
		// Calls the start method on the QuizRunner to start the Quiz
		quizRunner.start(user);
		
		
	}
	
		
	
	/*
	 * The main method that starts the Quiz Game
	 */
	public static void main(String[] args) {
		
		QuizStart quizStart = new QuizStart();
		quizStart.startQuiz();

	}

}
