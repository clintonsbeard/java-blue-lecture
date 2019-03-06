package com.techelevator.dao;

import com.techelevator.dao.model.Person;
import java.util.List;

public interface PersonDao {
	
    public List<Person> getMatchingPersons(String search);
    public void addPerson(Person person);
    
}