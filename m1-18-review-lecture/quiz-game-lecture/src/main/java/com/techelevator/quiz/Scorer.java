package com.techelevator.quiz;

import com.techelevator.quiz.question.Answer;

public class Scorer {

	private int totalQuestions;
	private int correct = 0;
	
	public Scorer(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	
	public void score(Answer userAnswer) {
		if (userAnswer.isCorrectAnswer()) {
			correct++;
		}
	}


	public int getCorrect() {
		return correct;
	}

	public int getScore() {
		int score = (int) (((double) correct / (double) totalQuestions) * 100);
		return score;
	}
	
	
}
