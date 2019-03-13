package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.quiz.Question;
import com.techelevator.model.quiz.Quiz;

@Controller
/*
 * Ths SessionAttributes annotations identifies which keys in the ModelMap should be
 * placed in SessionScope instead of RequestScope.  The key name is picked by the developer,
 * but once set must be used to access the value (Quiz) in session.
 */
@SessionAttributes("sessionQuiz")
public class QuizController {

	/*
	 * Start controller for the Quiz, this acts as a Setup, and will allow
	 * the quiz to be restarted by returning to this URL.
	 */
	@RequestMapping(path="/start", method=RequestMethod.GET)
	public String start(ModelMap map) {
		
		/*
		 * Build the quiz and put it into the modelMap using the key set in the SessionAttributes
		 * annotation above.  This will put the Quiz in SessionScope instead of RequestScope.
		 */
		map.addAttribute("sessionQuiz", buildQuiz());
		
		/*
		 * Redirect to the ask controller to ask the first question
		 */
		return "redirect:/ask";
	}
	
	/*
	 * The ask controller action gets the next question from the Quiz in Session and 
	 * displays the page to get the users response.
	 */
	@RequestMapping(path="/ask", method=RequestMethod.GET)
	public String ask(ModelMap map) {
		
		/*
		 * Get the Quiz from session.  To do this use the ModelMap with the key set in
		 * the SessionAttribuetes annotation above.   The value must be cast to the correct
		 * data type (Quiz) so it can be used.
		 */
		Quiz quiz = (Quiz) map.get("sessionQuiz");
		
		/*
		 * Check if the Quiz has another question, if it is FALSE, then 
		 * redirect to the results action.  The check will work best here instead of the POST 
		 * or in the JSP so if the user refreshes the page or returns to the URL they will be
		 * shown the results again.   The quiz can be restarted by the user going to the /start
		 * URL. 
		 */
		if (!quiz.hasNextQuestion()) {
			return "redirect:/results";
		}

		/*
		 * Get the next question from the Quiz
		 */
		Question question = quiz.askQuestion();
		
		/*
		 * Add the question to the ModelMap, since the key (question) is not specified 
		 * in the SessionAttributes the question will be placed in RequestScope instead
		 * of SessionScope.  
		 */
		map.addAttribute("question", question);
		
		/*
		 * Show the ask.jsp located in WEB-INF/jsp/quiz/ask.jsp
		 */
		return "quiz/ask";
	}
	
	/*
	 * A POST method to recieve the form post with the users answer to the question.
	 * The ModelMap will be used to access the quiz in session.
	 * The RequestParam answer will recieve the value of the input field on the JSP
	 * form with name="answer" and will contain the user's answer to the question.
	 */
	@RequestMapping(path="/ask", method=RequestMethod.POST)
	public String answer(ModelMap map, @RequestParam String answer) {
		
		/*
		 * Get the Quiz from session.  To do this use the ModelMap with the key set in
		 * the SessionAttribuetes annotation above.   The value must be cast to the correct
		 * data type (Quiz) so it can be used.
		 */
		Quiz quiz = (Quiz) map.get("sessionQuiz");
		
		/*
		 * Pass the Quiz answerQuestion method the answer so it can set it on the Question
		 * and move it to the answeredQuestion list.  Note that after a change is made to the
		 * object in SessionScope, that there is no need to set it again in the ModelMap.  This
		 * is because the variable quiz will be a reference to the Quiz object already in session, 
		 * thus it will be updated when we make changes to it in the controller.
		 */
		quiz.answerQuestion(answer);
		
		/*
		 * Redirect back to the ask action to show the next question
		 */
		return "redirect:/ask";
	}
	
	
	/*
	 * Show the results of the quiz.  
	 * The results are in the Quiz object in SessionScope, and there is a getter method
	 * that will allow the JSP to access it, so there is no need to get it from session
	 * and set it back into the ModelMap in RequestScope.
	 */
	@RequestMapping(path="/results", method=RequestMethod.GET)
	public String showResult(ModelMap map) {
		
		/*
		 * Show the results page
		 */
		return "quiz/results";
	}
	
	
	
	
	/*
	 * A private method to build the Quiz object that will be stored in session.  Controllers are
	 * just Java objects, so any code can be included.    Though it is best to delegate functionality
	 * to model classes.  
	 */
	private Quiz buildQuiz() {
		/*
		 * Instantiate a Quiz object and add questions to it so it is ready to be
		 * set into session and used by the Quiz.
		 */
		Quiz quiz = new Quiz();
		quiz.addQuestion(new Question("What is the answer?"));
		quiz.addQuestion(new Question("What is the question?"));
		return quiz;
	}
	
}
