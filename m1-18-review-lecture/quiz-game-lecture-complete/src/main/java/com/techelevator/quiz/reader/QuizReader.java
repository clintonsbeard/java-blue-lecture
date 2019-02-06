package com.techelevator.quiz.reader;

import java.util.List;

import com.techelevator.quiz.exception.LoadQuizException;
import com.techelevator.quiz.question.Question;

public interface QuizReader {


	List<Question> read() throws LoadQuizException;
	
}
