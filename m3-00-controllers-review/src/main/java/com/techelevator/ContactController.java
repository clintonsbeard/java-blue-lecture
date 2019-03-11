package com.techelevator;

import java.time.LocalDate;
<<<<<<< HEAD
import java.time.LocalDateTime;
=======
>>>>>>> 050f82aa23d1823b39ea0a0d0f7e771f4310128e
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.PersonDao;
import com.techelevator.dao.model.Person;

@Controller
public class ContactController {
<<<<<<< HEAD
	
=======

>>>>>>> 050f82aa23d1823b39ea0a0d0f7e771f4310128e
	@Autowired
	private PersonDao personDao;
	
	@RequestMapping("/contacts")
	public String showContactList(ModelMap map) {
		
		List<Person> personList = personDao.getMatchingPersons("");
		map.addAttribute("contacts", personList);
<<<<<<< HEAD
		
		return "contactList";
	}
	
	@RequestMapping("/searchContacts")
	public String searchContactList(ModelMap map, @RequestParam(required=true) String searchTerm) {
		
		List<Person> personList = personDao.getMatchingPersons(searchTerm);
		map.addAttribute("contacts", personList);
		
		return "contactList";
	}
	
	@RequestMapping(path="/addContact", method=RequestMethod.POST)
	public String saveContact(Person person) {
=======
	
		return "contactList";
	}
	
	
	@RequestMapping("/searchContacts")
	public String searchContactList(ModelMap map, 
			@RequestParam String searchTerm) {
		
		List<Person> personList = personDao.getMatchingPersons(searchTerm);
		map.addAttribute("contacts", personList);
	
		return "contactList";
	}
	
	@RequestMapping(path="/addContact", method=RequestMethod.GET)
	public String showAddContact() {
		return "addContact";
	}
	
	@RequestMapping(path="/addContact", method=RequestMethod.POST)
	public String saveContact(Person person) {
		
>>>>>>> 050f82aa23d1823b39ea0a0d0f7e771f4310128e
		person.setDateAdded(LocalDate.now());
		personDao.addPerson(person);
		return "redirect:/contacts";
	}
<<<<<<< HEAD
	
	@RequestMapping(path="/addContact", method=RequestMethod.GET)
	public String showAddContact() {
		return "addContact";
	}
	
}
=======
}
>>>>>>> 050f82aa23d1823b39ea0a0d0f7e771f4310128e
