package com.techelevator.quiz;

import java.util.List;

import com.techelevator.quiz.exception.LoadQuizException;
import com.techelevator.quiz.menu.Menu;
import com.techelevator.quiz.question.Answer;
import com.techelevator.quiz.question.Question;
import com.techelevator.quiz.reader.QuizReader;

/*
 * JOB: To Administer the Quiz
 */
public class QuizRunner {

	private Menu menu;
	private QuizReader quizReader;
	
	public QuizRunner(Menu menu, QuizReader quizReader) {
		this.menu = menu;
		this.quizReader = quizReader;
				
	}
	
	/*
	 * Setup and start the Quiz
	 */
	public void start(String user) {
			
		List<Question> questions = null;
		Quiz quiz = null;
		//while(true) {
			
			
			try {
				// Get the Questions
				questions = quizReader.read();
				// Build the Quiz Object
				quiz = new Quiz(questions);
				// run the Quiz
				runQuiz(quiz, user);
			} catch (LoadQuizException e) {
				menu.showError("*** Quiz not found: " + e.getMessage());
			}
			
	
		//}
		
		endQuiz(quiz, user);
		
	}

	
	/*
	 * Facilitate the Quiz
	 */
	private void runQuiz(Quiz quiz, String user) {
		
		
		menu.showWelcome(user);
		int number = 1;
		
		// Ask the User Questions
		while (quiz.hasNext()) {
			Question question = quiz.next();
			Answer userAnswer = menu.askQuizQuestion(question, number++);
			
			quiz.scoreQuestion(userAnswer);
			menu.showQuestionResult(question, userAnswer);
		}
		
	}
	
	private void endQuiz(Quiz quiz, String user) {
		menu.showFinalResults(quiz, user);
	}
	
}
