package com.techelevator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("greeting", "Welcome");
		
		Person doug = new Person("Doug", "Rogers", 45);
		doug.setAddress(new Address("123 Street", "Columbus", "Ohio"));
		
		req.setAttribute("person", doug);
		
		
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Mike", "Mazzullo", 21));
		personList.add(new Person("Asher", "Díaz", 22));
		personList.add(new Person("Sondra", "Coffin", 23));
		personList.add(new Person("Jeff", "Prescott", 12));

		req.setAttribute("personList", personList);
	
		getServletContext().getRequestDispatcher("/WEB-INF/personList.jsp").forward(req, resp);;
	}
}
