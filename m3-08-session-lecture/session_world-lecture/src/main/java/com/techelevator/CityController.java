package com.techelevator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.dao.CityDAO;
import com.techelevator.dao.model.City;
import com.techelevator.dao.model.User;

/*
 * Login with the following
 * 	username: John
 * 	password: 123
 */

@Controller
//@SessionAttributes("user") // Example of single Session value
@SessionAttributes({"user", "bgClass" })
//@SessionAttributes({"user", "bgClass"})   // Example of multiple session values
public class CityController {

	@Autowired
	private CityDAO cityDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showCityList(ModelMap map) {
		

		
		if (map.get("user") == null) {
			return "redirect:/login";
		}
		
		map.addAttribute("cities", cityDao.findCityByCountryCode("USA"));		
		return "cityList";
	}
	
	
	@RequestMapping(path="/addCity", method=RequestMethod.GET)
	public String showAddCity(ModelMap map) {
		if (map.get("user") == null) {
			return "redirect:/login";
		}
		User currentUser = (User) map.get("user");
		currentUser.setName("Hello");
		return "addCity";  
	}
	
	@RequestMapping(path="/addCity", method=RequestMethod.POST)
	public String addNewCity(City newCity) {
	
		newCity.setCountryCode("USA");	
		cityDao.save(newCity);
		
		return "redirect:/";  
	}
	
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String doLogin(User user, @RequestParam String password, ModelMap map) {
		
		if (!isValidLogin(user, password)) {
			map.addAttribute("error", "Invalid username or password");
			user = null;
			return "login";
		}
		
		map.addAttribute("user", user);
		return "redirect:/";
	}
	
	@RequestMapping(path="/logout", method=RequestMethod.GET) 
	public String doLogout(HttpSession session, ModelMap map) {
		
		session.invalidate();
		map.clear();
		
		// Why do we need this line?
		map.addAttribute("bgClass", "white");
		return "redirect:/";
	}
	
	
	@RequestMapping(path="/selectBackgroundColor", method=RequestMethod.GET)
	public String selectBackgroundColor(ModelMap map) {
		if (map.get("user") == null) {
			return "redirect:/login";
		}
		return "selectBackgroundColor";
	}
	
	
	@RequestMapping(path="/changeBackground", method=RequestMethod.POST)
	public String changeBackgroundColor(@RequestParam(name="bgColor") String backgroundColor, ModelMap map) {
		map.addAttribute("bgClass", backgroundColor);
		
		return "selectBackgroundColor";   // Without bgClass as a SessionAttribute this page has the color, but no others
		//return "redirect:/selectBackgroundColor";    // Without bgClass as a SessionAttribute, a redirect loses our changes.  How does this change once we add the bgClass as a Session Attribute?
	}
	
	
	private boolean isValidLogin(User user, String password) {
		if (!(user.getUsername().equals("John") && password.equals(("123")) ||
				user == null || user.getUsername() == null || user.getUsername().length() < 1 
				|| password == null || password.length() < 1)) {
			
			return false;
		}
		user.setName("Joe Doe");
		return true;
	}
	
}
