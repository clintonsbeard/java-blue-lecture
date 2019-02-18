package com.techelevator.addressbook.instructor;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCPersonDAO implements PersonDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCPersonDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(Person person) {
		String insertSql = "INSERT INTO person (person_id, first_name, last_name, date_added, type, update_date) " + 
						"VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING person_id";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(insertSql, 
				person.getFirstName(), person.getLastName(), person.getDateAdded(), person.getType(), person.getUpdateDate());
		
		results.next();
		person.setPersonId(results.getLong("person_id"));
		
	}

	@Override
	public List<Person> getPersonByLastName(String lastName) {
		
		List<Person> persons = new ArrayList<Person>();
		
		String selectSql = "SELECT person_id, first_name, last_name, date_added, type, update_date FROM person " + 
				"WHERE last_name = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSql, lastName);
		
		while (results.next()) {
			Person p = mapRowToPerson(results);
			persons.add(p);
		}
		
		return persons;
	}
	
	private Person mapRowToPerson(SqlRowSet results) {
		Person person = new Person();
		person.setPersonId(results.getLong("person_id"));
		person.setFirstName(results.getString("first_name"));
		person.setLastName(results.getString("last_name"));
		
		if (results.getDate("date_added") != null) {
			person.setDateAdded(results.getTimestamp("date_added").toLocalDateTime());
		}
		
		person.setType(results.getString("type"));
		
		if (results.getDate("update_date") != null) {
			person.setUpdateDate(results.getTimestamp("update_date").toLocalDateTime());
		}
		
		return person;
	}

	
	
}
