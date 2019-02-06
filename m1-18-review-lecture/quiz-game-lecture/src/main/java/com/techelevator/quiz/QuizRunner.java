package com.techelevator.quiz;

import java.util.List;

import com.techelevator.quiz.exception.LoadQuizException;
import com.techelevator.quiz.menu.Menu;
import com.techelevator.quiz.question.Answer;
import com.techelevator.quiz.question.Question;
import com.techelevator.quiz.reader.QuizReader;

public class QuizRunner {

	private Menu menu;
	private QuizReader quizReader;
	
	public QuizRunner(Menu menu, QuizReader quizReader) {
		this.menu = menu;
		this.quizReader = quizReader;
				
	}
	
	public void start(String user) {
			
		List<Question> questions = null;
		Quiz quiz = null;
		//while(true) {
			
			// Get the Questions
			// Build the Quiz Object
			// run the Quiz
			
	
		//}
		
		endQuiz(quiz, user);
		
	}

	
	private void runQuiz(Quiz quiz, String user) {
		
		
		menu.showWelcome(user);
		int number = 1;
		
		// Ask the User Questions
		
	}
	
	private void endQuiz(Quiz quiz, String user) {
		menu.showFinalResults(quiz, user);
	}
	
}
