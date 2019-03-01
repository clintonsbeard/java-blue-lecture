package com.techelevator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setAttribute("name", "John");
		
		List<String> names = new ArrayList<String>();
		names.add("André");
		names.add("Matt");
		names.add("Vineeta");
		names.add("Diane");
		names.add("Apple");
		names.add("Leon");
		names.add("C.J.");
		
		/* This line adds a request attribute with the name "studentList" 
		 * that contains our list of student names. This will later be 
		 * used by the View (i.e. JSP) to display student names in HTML */
		req.setAttribute("nameList", names);
		
		Map<String, String> animal2Herd = new HashMap<String, String>();
		animal2Herd.put("Lion", "Pride");
		animal2Herd.put("Rhino", "Crash");
		animal2Herd.put("Giraffe", "Tower");
		
		req.setAttribute("herds", animal2Herd);

		
		/* This line forwards the request to the JSP */
		this.getServletContext().getRequestDispatcher("/WEB-INF/nameList.jsp").forward(req, resp);
	}
}
