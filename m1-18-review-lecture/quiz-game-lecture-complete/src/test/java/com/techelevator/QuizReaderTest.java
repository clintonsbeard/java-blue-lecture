package com.techelevator;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.quiz.exception.LoadQuizException;
import com.techelevator.quiz.question.Answer;
import com.techelevator.quiz.question.MultipleChoiceQuestion;
import com.techelevator.quiz.question.Question;
import com.techelevator.quiz.question.TrueFalseQuestion;
import com.techelevator.quiz.reader.FileQuizReader;


public class QuizReaderTest {

	private static final String QUIZ_FILE = "quiz_questions.csv";
	private FileQuizReader reader;
	
	@Before
	public void setup() {
		reader = new FileQuizReader(QUIZ_FILE);
	}
	
	
	@Test
	public void read_all_quiz_questions() {
		
		try {
			List<Question> questions = reader.read();
			
			Assert.assertNotNull(questions);
			Assert.assertEquals(19, questions.size());
			
			for (Question question : questions) {
				assertAnswers(question);
			}
			
		} catch (LoadQuizException e) {
			Assert.fail("Exception opening Quiz File: " + e.getMessage());
		}
	}
	
	private void assertAnswers(Question question) {
		
		assertCorrectAnswerExists(question.getSortedAnswers());
		
		if (question instanceof MultipleChoiceQuestion) {
			assertAnswersMultipleChoice(question.getSortedAnswers());
		} else if (question instanceof TrueFalseQuestion) {
			assertAnswersTrueFalse(question.getSortedAnswers());
		}
	}
	
	private void assertAnswersMultipleChoice(List<Answer> answers) {
		Assert.assertEquals(4, answers.size());
	}
	
	private void assertAnswersTrueFalse(List<Answer> answers) {
		Assert.assertEquals(2, answers.size());
	}
	
	private void assertCorrectAnswerExists(List<Answer> answers) {
		int correct = 0;
		
		for (Answer answer : answers) {
			if (answer.isCorrectAnswer()) {
				correct++;
			}
		}
		
		Assert.assertEquals("Wrong number of correct answers found", 1,  correct);

	}
	
}
