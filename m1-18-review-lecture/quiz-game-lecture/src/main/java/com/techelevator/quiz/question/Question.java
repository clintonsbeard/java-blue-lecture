package com.techelevator.quiz.question;

import java.util.ArrayList;
import java.util.List;

public abstract class Question {

	private String question;
	private List<Answer> answers = new ArrayList<Answer>();

	public Question(String question) {
		this.question = question;
	}
	
	public abstract List<Answer> getSortedAnswers();

	protected List<Answer> getAnswers() {
		return this.answers;
	}
	
	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getCorrectAnswer() {
		for (Answer answer: answers) {
			if (answer.isCorrectAnswer()) {
				return answer.getAnswer();
			}
		}
		return "ANSWER NOT FOUND";
	}
	 
}
