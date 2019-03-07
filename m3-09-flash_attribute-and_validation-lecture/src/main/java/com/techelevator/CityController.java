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
 * Login with any username and password
 */

@Controller
@SessionAttributes("user")
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
		return "addCity";  
	}
	
	@RequestMapping(path="/addCity", method=RequestMethod.POST)
	public String addNewCity(City newCity, ModelMap map) {
	
		newCity.setCountryCode("USA");	
		cityDao.save(newCity);

		map.addAttribute("city", newCity);
		
		return "redirect:/addCityResult";  
	}

	
	@RequestMapping(path="/addCityResult", method=RequestMethod.GET)
	public String showAddCityResult(ModelMap map) {	
		
		return "cityConfirm";  
	}
		

	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String doLogin(User user, @RequestParam String password, ModelMap map) {
		
		if (!isValidLogin(user, password)) {
			map.addAttribute("error", "Invalid username or password");
			return "login";
		}
		
		map.addAttribute("user", user);
		return "redirect:/";
	}
	
	@RequestMapping(path="/logout", method=RequestMethod.GET) 
	public String doLogout(HttpSession session, ModelMap map) {
		
		session.invalidate();
		map.clear();
		
		/* this is added to get around a Browser caching issue with the CSS that sometimes does
		 * not immediately reset the bgClass to White.
		 */
		map.addAttribute("bgClass", "white");
		
		return "redirect:/";
	}
	
	private boolean isValidLogin(User user, String password) {
		
		/* The login check has been commented out so we can send any user Id or password
		 * If this was an actual login then what ever authentication process is used to 
		 * validate the user would be called here.   True would be returned if they had
		 * Successfully Authenticated and False if they did not.  
		 * 
		 * Authentication will be covered in detail later in this module.
		 */
		/*
		if (user == null || user.getUsername() == null || user.getUsername().length() < 1 
				|| password == null || password.length() < 1
				|| !(user.getUsername().equals("John") && password.equals(("123")))) {
			return false;
		}
		*/
		user.setName("John Doe");
		return true;
	}
	
}
