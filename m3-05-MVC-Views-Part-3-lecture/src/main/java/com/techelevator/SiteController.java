package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Planet;

@Controller 
public class SiteController {
	
	private ForumDao forumDao;
	
	public SiteController() {
		forumDao = new ForumDao();
	}

	@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@RequestMapping("/aboutUs")
	public String showAboutUs() {
		return "aboutUs";
	}
	
	@RequestMapping("/forum")
	public String showForumList(HttpServletRequest request) {
		request.setAttribute("topicList", forumDao.readAllTopics());
		return "forum/forumList";
	}
	
	@RequestMapping("/forum/forumDetail") 
	public String showForumDetails(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("forumId"));
		request.setAttribute("topic", forumDao.getForumTopicById(id));
		return "forum/forumDetail";
	}
	
	@RequestMapping("/planetDetail")
	public String showPlanetDetails(ModelMap map) {
		
		map.addAttribute("planets", getListOfPlanets());
		
		return "planetDetail";
	}
	
	private List<Planet> getListOfPlanets() {
		List<Planet> planets = new ArrayList<Planet>();
		
		planets.add(new Planet("Mercury", "mercury.jpg", .39d, 0));
		planets.add(new Planet("Venus", "venus.jpg", .72d, 0));
		planets.add(new Planet("Earth", "earth.jpg", 1d, 1));
		planets.add(new Planet("Mars", "mars.jpg", 1.52d, 2));
		planets.add(new Planet("Jupiter", "jupiter.jpg", 5.2d, 79));
		planets.add(new Planet("Saturn", "saturn.jpg", 9.58d, 62));
		planets.add(new Planet("Uranus", "uranus.jpg", 19.20d, 27));
		planets.add(new Planet("Neptune", "venus.jpg", 30.05d, 14));
		return planets;
	}
}
