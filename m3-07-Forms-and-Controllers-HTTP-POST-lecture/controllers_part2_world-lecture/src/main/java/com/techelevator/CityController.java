package com.techelevator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.CityDAO;
import com.techelevator.dao.model.City;

@Controller
public class CityController {

	@Autowired
	private CityDAO cityDao;

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showAddCity(HttpServletRequest request) {
		request.setAttribute("cities", cityDao.findCityByCountryCode("USA"));		
		return "addCity";
	}
	
	/*
	 * Using a GET and HttpServletRequest
	 * 
	 * Parameters passed in the URL
	 * Parameters retrieved using the Request Object (HttpServletRequest)
	 * Values returned using HttpServletRequest
	 * 
	 * If the Page is refreshed, it adds the city again!
	 */
	@RequestMapping(path="/addCity", method=RequestMethod.GET)
	public String addNewCity(HttpServletRequest request) {
	
		String name = request.getParameter("name");
		String district = request.getParameter("district");
		String population = request.getParameter("population");
		
		City newCity = new City();
		newCity.setCountryCode("USA");
		newCity.setName(name);
		newCity.setDistrict(district);
		newCity.setPopulation(Integer.parseInt(population));
		
		cityDao.save(newCity);
		
		request.setAttribute("cities", cityDao.findCityByCountryCode("USA"));		
		return "addCity";
	}
	
	/*
	 * Using a POST and HttpServletRequest
	 * 
	 * Parameters passed in message body
	 * Parameters retrieved using the Request Object (HttpServletRequest)
	 * Values returned using HttpServletRequest
	 * 
	 * If Refreshed, still adds the city again, but this time we get a warning!
	 */
	@RequestMapping(path="/addCity", method=RequestMethod.POST)
	public String addNewCityByPost(HttpServletRequest request) {
	
		String name = request.getParameter("name");
		String district = request.getParameter("district");
		String population = request.getParameter("population");
		
		City newCity = new City();
		newCity.setCountryCode("USA");
		newCity.setName(name);
		newCity.setDistrict(district);
		newCity.setPopulation(Integer.parseInt(population));
		
		cityDao.save(newCity);
		
		request.setAttribute("cities", cityDao.findCityByCountryCode("USA"));		
		return "addCity";
	}
	
	
	/*
	 * Using a POST and Request Parameters
	 * 
	 * Parameters passed in message body
	 * Parameters retrieved using the Request Parameters 
	 * Values returned using HttpServletRequest
	 * 
	 * If Refreshed, still adds the city again, but this time we get a warning!
	 */
	@RequestMapping(path="/addCityWithRequestParams", method=RequestMethod.POST)
	public String addNewCityByPost(HttpServletRequest request, @RequestParam String name, 
			@RequestParam(name="district") String state, @RequestParam int population, @RequestParam(required=false) String notRequired) {
			
		City newCity = new City();
		newCity.setCountryCode("USA");
		newCity.setName(name);
		newCity.setDistrict(state);
		newCity.setPopulation(population);
		
		cityDao.save(newCity);
		
		request.setAttribute("cities", cityDao.findCityByCountryCode("USA"));		
		return "addCity";
	}
		
	/*
	 * Using a POST and Model Binding
	 * 
	 * Parameters passed in message body
	 * Parameters are bound to the City object
	 * Values returned using HttpServletRequest
	 * 
	 * If Refreshed, still adds the city again, but this time we get a warning!
	 */
	@RequestMapping(path="/addCityWithBinding", method=RequestMethod.POST)
	public String addNewCityByPost(City newCity, HttpServletRequest request) {
		
		newCity.setCountryCode("USA");	
		cityDao.save(newCity);
		
		request.setAttribute("cities", cityDao.findCityByCountryCode("USA"));		
		return "addCity";
	}
	
	/*
	 * Using a POST and Model Binding
	 * 
	 * Parameters passed in message body
	 * Parameters are bound to the City object
	 * Values returned using ModelMap
	 * 
	 * If Refreshed, still adds the city again, but this time we get a warning!
	 */
	@RequestMapping(path="/addCityWithPostWithModelMap", method=RequestMethod.POST)
	public String addNewCityByPostWithModelMap(City newCity, ModelMap map) {
		
		newCity.setCountryCode("USA");	
		cityDao.save(newCity);

		
		map.addAttribute("cities", cityDao.findCityByCountryCode("USA"));	
		return "addCity";  
	}
	
	/*
	 * Adding a new City using a POST-REDIRECT-GET
	 * 
	 * Parameters passed in message body
	 * This time the parameters are bound to the City object
	 * No output values are set
	 * 
	 * Instead of returning the logical view name, it returns a redirect to the original GET method, this
	 * way if the page is refreshed it won't apply the change again!
	 */
	@RequestMapping(path="/addCityWithPostAndRedirect", method=RequestMethod.POST)
	public String addNewCityByPostAndRedirect(City newCity) {

		newCity.setCountryCode("USA");	
		cityDao.save(newCity);
			
		/*
		 * Instead of returning a view name, we can return redirect:<controller request mapping> to redirect to
		 * a GET and keep the form from submitting again on a refresh
		 */
		//return "redirect:/"; 
		
		/*
		 * Or we could choose to redirect to a Thank You or other status page if we don't want to show results
		 */
		return "redirect:/thankyou"; 
	}
	
	@RequestMapping(path="/thankyou", method=RequestMethod.GET)
	public String showThankYou() {
		return "thankYou";
	}
	
	
}
