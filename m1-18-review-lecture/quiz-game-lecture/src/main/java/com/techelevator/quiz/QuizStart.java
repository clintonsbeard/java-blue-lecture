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
		
		Menu menu = new Menu(new Scanner(System.in), System.out);
		
		String user = menu.getUserName();
		
		String filename = menu.getQuizFileFromUser();
		QuizReader quizReader = new FileQuizReader(filename);
	
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
