package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.CityDao;
import com.techelevator.model.User;

@Controller
public class HelloController {

	@Autowired
	private CityDao cityDao;
	
	/*
	 * Home page that loads a list of all cities in the database and makes them
	 * available in RequestScope using the ModelMap so they can be accessed in the JSP
	 */
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(ModelMap map) {
		
		map.addAttribute("cities", cityDao.getAllCities());
		
		return "home";
	}
	
	/*
	 * Get for pageOne, this loads the initial page
	 */
	@RequestMapping(path="/pageOne", method=RequestMethod.GET)
	public String showPageOne() {
		return "pageOne";
	}
	
	/*
	 * Get for pageOne, this accepts the Form post.   Note that the path /pageOne must be 
	 * unique for the application AND request method, so it can exist once for GET and a 
	 * second time for POST.
	 * 
	 * RequestParams are used to retrieve the data from the form.  The name of these variables
	 * needs to match the name= attributes on the form fields.
	 * 
	 * This POST returns the JSP, so it does not follow the POST-REDIRECT-GET pattern, hence
	 * it will repost the data on refresh.
	 */
	@RequestMapping(path="/pageOne", method=RequestMethod.POST)
	public String postPageOne(@RequestParam String name, @RequestParam String email) {
		return "pageOne";
	}
	
}
