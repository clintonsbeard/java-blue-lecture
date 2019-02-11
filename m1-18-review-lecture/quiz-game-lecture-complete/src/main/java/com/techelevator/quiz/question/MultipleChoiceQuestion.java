package com.techelevator.quiz.question;

import java.util.Collections;
import java.util.List;

public class MultipleChoiceQuestion extends Question {

	private boolean answersShuffled = false;
	
	public MultipleChoiceQuestion(String question) {
		super(question);
	}

	@Override
	public List<Answer> getSortedAnswers() {
		if (!answersShuffled) {
			Collections.shuffle(super.getAnswers());
			answersShuffled = true;
		}
		return super.getAnswers();
	}
	
}
