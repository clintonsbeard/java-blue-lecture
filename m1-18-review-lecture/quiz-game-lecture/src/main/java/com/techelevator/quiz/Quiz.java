package com.techelevator.quiz;

import java.util.Collections;
import java.util.List;

import com.techelevator.quiz.question.Answer;
import com.techelevator.quiz.question.MultipleChoiceQuestion;
import com.techelevator.quiz.question.Question;

public class Quiz {
	
	private List<Question> questions;
	private Scorer scorer;
	private int totalQuestions;
	
	public Quiz(List<Question> questions) {
		this.questions = questions;
		this.totalQuestions = questions.size();
		createQuiz();
	}
	
	public boolean hasNext() {
		if (questions.size() > 0) {
			return true;
		}
		return false;
	}
	
	public Question next() {
		Question question = questions.remove(0);
		return question;
	}
	
	public int getScore() {
		return this.scorer.getScore();
	}
	
	public int getTotalQuestions() {
		return totalQuestions;
	}
	
	public int getNumberCorrect() {
		return this.scorer.getCorrect();
	}
	
	public void scoreQuestion(Answer userAnswer) {
		this.scorer.score(userAnswer);
	}

	
	private void createQuiz() {
		scorer = new Scorer(questions.size());
		Collections.shuffle(questions);
	}
}
