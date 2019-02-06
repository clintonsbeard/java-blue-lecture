package com.techelevator.quiz.menu;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.techelevator.quiz.Quiz;
import com.techelevator.quiz.question.Answer;
import com.techelevator.quiz.question.Question;

/*
 * JOB: Communicate with the user
 * 
 * This is ONLY class that uses System.in and System.out
 */
public class Menu {

	private Scanner in;
	private PrintStream out;
	
	public Menu(Scanner in, PrintStream out) {
		this.in = in;
		this.out = out;
	}
	
	public String getQuizFileFromUser() {
		String filename = null;
		
		while (filename == null) {
			out.print("What is the path to the quiz file? >>>");
			filename = in.nextLine();
		}
		
		return filename;
	}
	
	public void showError(String message) {
		out.println(message);
	}
	
	public Answer askQuizQuestion(Question question, int number) {
		
		out.println();
		out.println("Question " + number + ":");
		out.println(question.getQuestion());
		
		int num = 1;
		for (Answer answer : question.getSortedAnswers()) {
			out.println("[" +  num++ + "] " + answer.getAnswer());
		}
		

		return getUserAnswer(question.getSortedAnswers());
		
	}
	
	public void showQuestionResult(Question question, Answer userAnswer) {
		
		System.out.print("Your answer was ");
		
		if (userAnswer.isCorrectAnswer()) {
			System.out.println("CORRECT");
		} else {
			System.out.println("INCORRECT");
			System.out.println("The correct answer was: " + question.getCorrectAnswer());
		}
	}
	
	public void showFinalResults(Quiz quiz, String user) {
		
		System.out.println();
		System.out.println(user + ", your final result is:");
		
		String finalScore = quiz.getScore() + "% with " 
				+ quiz.getNumberCorrect() + " of " + quiz.getTotalQuestions() + " Questions correct.";
		
		System.out.println(finalScore);
	}
	
	public String getUserName() {
		System.out.print("Enter your name: >>>");
		return in.nextLine();
	}
	

	
	public void showWelcome(String user) {
		System.out.println();
		System.out.println("Welcome " + user + " let's begin!");
	}
	
	private Answer getUserAnswer(List<Answer> answers) {
		Answer userChoice = null;
		
		while (userChoice == null) {
			out.print("Select answer >>> ");
			int selection = 0;
			try {
				selection = in.nextInt();
				in.nextLine();
			} catch (InputMismatchException e) {
				out.println("Invalid choice, please try again!");
				continue;
			}
			
			if (selection - 1 < answers.size()) {
				userChoice = answers.get(selection - 1);
			} else {
				out.println("Invalid choice, please try again!");
				continue;
			}
		}
		return userChoice;
		
	}
	

	
}
