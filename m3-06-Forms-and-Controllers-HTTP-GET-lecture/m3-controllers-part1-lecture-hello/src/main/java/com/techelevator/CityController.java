package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.city.City;
import com.techelevator.model.city.CityDAO;

/*
 * A Controller class is identified by the @Controller annotation
 */
@Controller
public class CityController {

	@Autowired
	private CityDAO cityDao;
	
	/*
	 * The request mapping "maps" a pattern on the URL to a method in
	 * the controller.  For example, this one /search will be called when a 
	 * request with a URL like 
	 * http://localhost:8080/controllers-part1-lecture-hello/search
	 * is received.
	 */
	@RequestMapping("/search")
	public String displayCitySearch() {
		
		/*
		 * The logical view name returned from the controller tells
		 * SpringMVC what view (jsp) to load.  The View Resolver will prepend
		 * /WEB-INF/jsp/  and append  .jsp to the view name, so the logical view
		 * name "city/citySearch" 
		 *           will resolve to:  /WEB-INF/jsp/city/citySearch.jsp
		 */
		return "city/citySearch";
	}
	
	/*
	 * The HttpServletRequest is the Request Object.  By making it 
	 * an argument of the controller method, the Dispatcher Servlet will
	 * pass the Request Object to our method when it is called.  
	 * 
	 * The Request Object can be used to access the parameters and 
	 * request scope.
	 */
	@RequestMapping("/result")
	public String displayCitySearchResult(HttpServletRequest request)
	{
		/*
		 * Retrieve values of parameters by using the Request Objects
		 * getParameter(key) method.  
		 * 
		 * For example, for a request like this:
		 * http://localhost:8080/result?countryCode=USA
		 *    The String countryCode would be populated with the value USA 
		 *
		 */
		String countryCode = request.getParameter("countryCode");
		
		List<City> results = cityDao.findCityByCountryCode(countryCode);
		
		/* 
		 * The Request Object can also be used to set values in the RequestScope
		 *  using the setAttributes() method.
		 * 
		 */
		request.setAttribute("cities", results);
		
		return "city/searchResult";
	}
	
}
