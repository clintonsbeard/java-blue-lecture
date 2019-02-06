package com.techelevator.quiz.question;

public class Answer {

	private String answer;
	private boolean isCorrectAnswer;
	
	public Answer (String answer, boolean isCorrectAnswer) {
		this.answer = answer;
		this.isCorrectAnswer = isCorrectAnswer;
	}

	public String getAnswer() {
		return answer;
	}

	public boolean isCorrectAnswer() {
		return isCorrectAnswer;
	}
	
	
	
}
