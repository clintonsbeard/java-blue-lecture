package com.techelevator.addressbook.instructor;

import java.util.List;

public interface PersonDAO {

	void save(Person person);
	List<Person> getPersonByLastName(String lastName);
	
}
