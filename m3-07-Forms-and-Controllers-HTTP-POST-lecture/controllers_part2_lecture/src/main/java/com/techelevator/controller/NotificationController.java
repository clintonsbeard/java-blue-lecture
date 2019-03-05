package com.techelevator.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.NotificationSignupDAO;

@Controller
public class NotificationController {

	/* The `method` attribute of the @RequestMapping annotation allows us to specify that this method
	 * only handles requests for a specific HTTP method. The mapping below specifies that this method 
	 * is only invoked for HTTP GET requests
	 * 
	 * If the request method is specified, the path must be specified using the `path` attribute rather
	 * than just passing it as the default attribute	*/
	@RequestMapping(path="/notificationSignupInput", method=RequestMethod.GET)
	public String showNotificationSignupForm() {
		
		return "notificationSignupInput";
	}
	
	/* 
	 * The @RequestParam annotation below can be applied to controller handler method parameters
	 * to indicate that the method parameter should be populated from an HTTP request 
	 * parameter. Spring MVC will look for HTTP parameters with names that match the 
	 * method parameters (i.e. "firstName", "lastName", "emailAddress", "age"). 
	 * 
	 * TYPE CONVERSION
	 * ---------------
	 * When retrieving values from the request, Spring will also perform type conversion 
	 * (e.g. String to int). If type conversion cannot be performed (e.g. invalid number)
	 * an Exception is thrown and the request will fail. 
	 * 
	 * OPTIONAL PARAMETERS
	 * -------------------
	 * By default, parameters annotated with @RequestParam are considered to be required. 
	 * If the HTTP request does not include a value for a parameter, an exception is thrown
	 * and the request fails (4xx error). If a parameter is optional, indicate this as follows:
	 * 
	 *     @RequestParam(optional=true) String myOptionalParam ...
	 * 
	 * PARAMETER NAMES
	 * ---------------
	 * If your method parameter name does not match the HTTP parameter name, you can specify the 
	 * name of the HTTP parameter as follows:
	 * 
	 *     @RequestParam(name="first_name") String firstName ...
	 */
	@RequestMapping(path="/notificationSignupInput", method=RequestMethod.POST)
	public String processNotificationSignupSubmission(@RequestParam String firstName,
													 @RequestParam String lastName,
													 @RequestParam String emailAddress,
													 @RequestParam int age) throws FileNotFoundException, IOException {
		
		try(FileOutputStream out = new FileOutputStream(getSignupLogFile(), true)) {
			NotificationSignupDAO log = new NotificationSignupDAO(out);
			log.saveNotificationSignup(firstName, lastName, age, emailAddress);
		}
		
		/* If the String returned by a handler method starts with "redirect:", this causes Spring
		 * to send an HTTP 3xx redirect response to the client. In this case, the value following 
		 * "redirect:" is treated as an HTTP resource and **NOT** a logical view name. */
		return "redirect:/notificationSignupResult";
	}
	
	@RequestMapping(path="/notificationSignupResult", method=RequestMethod.GET)
	public String showNotificationSignupResult() {
		return "notificationSignupResult";
	}

	private File getSignupLogFile() {
		String homeDirectory = System.getProperty("user.home");
		return new File(homeDirectory, "notificationSignups.csv");
	}
}
