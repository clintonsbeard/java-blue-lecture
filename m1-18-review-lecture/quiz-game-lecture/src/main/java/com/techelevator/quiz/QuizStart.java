package com.techelevator.quiz;

import java.util.Scanner;

import com.techelevator.quiz.menu.Menu;
import com.techelevator.quiz.reader.FileQuizReader;
import com.techelevator.quiz.reader.QuizReader;

public class QuizStart {
	
	/*
	 * Setups up and starts the quiz.
	 */
	
	public void startQuiz() {
		
		/* Create a menu object */
		Menu menu = new Menu(new Scanner(System.in), System.out);
		
		/* Gets the user's name and the file name, using that menu object */
		String user = menu.getUserName();
		String filename = menu.getQuizFileFromUser();
		
		/* Create a FileReader object, passing it the file name */
		QuizReader quizReader = new FileQuizReader(filename);
	
		/* Create a QuizRunner object and pass it the menu and the FileReader */
		QuizRunner quizRunner = new QuizRunner(menu, quizReader);
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