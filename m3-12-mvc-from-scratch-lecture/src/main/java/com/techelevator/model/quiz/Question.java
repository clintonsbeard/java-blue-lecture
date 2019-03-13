package com.techelevator.model.quiz;

/*
 * A Java Bean to hold the Question and user provided answer
 * The text will be the question and provided when the quiz is created.
 * The answer will be set when the user submits an answer
 */
public class Question {

	private String text;
	private String answer;
	
	/*
	 * No argument constructor to meet the requirements of being a Java Bean
	 */
	public Question() {
		
	}
	
	/*
	 * Constructor to allow easy setting of the Question text when the object is
	 * instantiated.  This is optional, but will make the Quiz creation code much cleaner.
	 */
	public Question(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
}
