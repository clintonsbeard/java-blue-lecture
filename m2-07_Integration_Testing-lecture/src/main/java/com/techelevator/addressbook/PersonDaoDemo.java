package com.techelevator.addressbook;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class PersonDaoDemo {

	public static void main(String[] args) {
		
		// Create our Data Source
		BasicDataSource abDataSource = new BasicDataSource();
		abDataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
		abDataSource.setUsername("postgres");
		abDataSource.setPassword("postgres1");
		
		// Instantiate the JDBC Object
		PersonDAO personDao = new JDBCPersonDAO(abDataSource);
		
		// Create a new Person
		Person person = new Person();
		person.setFirstName("Jane");
		person.setLastName("Smith");
		person.setDateAdded(LocalDateTime.now());
		person.setType("work");
		
		personDao.save(person);
		
		String lastName = "Fulton";
		
		List<Person> fultons = personDao.getPersonByLastName(lastName);
		
		
	}
	
}
