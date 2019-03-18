package com.techelevator.model.quiz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * The Quiz object holds the Quiz to be given the user.  This object will be stored in session.
 */
public class Quiz {

	/*
	 * A Queue is used for the questions to be asked.  This will allow us to peek() to 
	 * ask the next question, and then poll() to remove it and add the answer.
	 */
	private Queue<Question> questions = new LinkedList<Question>();
	
	/*
	 * A list is used for the answered questions.   Questions will be moved here once they
	 * are removed from the Queue and an answer added.  The List will allow the JSP to use
	 * forEach to loop through the Questions and show the questions and user answers.
	 */
	private List<Question> answeredQuestions = new ArrayList<Question>();
	
	/*
	 * Adds a Question to the Queue
	 */
	public void addQuestion(Question question) {
		questions.offer(question);
	}
	
	/*
	 * Gets the next question from the Queue.  Peek() is used so it can be displayed 
	 * without removing it from the queue.
	 */
	public Question askQuestion() {
		return questions.peek();
	}
	
	/*
	 * Sets the users answer for a question, by
	 * 1. Removing the Question from the queue() using poll()
	 * 2. Setting the Answer on the question
	 * 3. Adding the Question to the answered Question list
	 */
	public void answerQuestion(String answer) {
		Question next = questions.poll();
		next.setAnswer(answer);
		answeredQuestions.add(next);
	}
	
	/*
	 * Provided so the controller can check if the quiz is complete.  
	 * Booleans should generally be positives, so we return !isEmpty on the Queue
	 * to correctly provide a value for the property "hasNextQuestion"
	 */
	public boolean hasNextQuestion() {
		return !questions.isEmpty();
	}
	
	/*
	 * Returns the List of answered questions.  This is provided to allow the JSP
	 * to directly retrieve the answers from Session without the need for the controller
	 * to retrieve them and set them in RequestScope.
	 */
	public List<Question> getAnsweredQuestions() {
		return this.answeredQuestions;
	}

	
}
