package com.techelevator.dao;

import com.techelevator.dao.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

@Component
public class JDBCPersonDao implements PersonDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCPersonDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    
	@Override
	public List<Person> getMatchingPersons(String search) {
		String sql = "SELECT person_id, first_name, last_name, date_added, type, update_date FROM person WHERE first_name ILIKE ? OR last_name ILIKE ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, "%" + search + "%", "%" + search + "%");
		
		List<Person> persons = new ArrayList<Person>();
		while(result.next()) {
			persons.add(mapRowToPerson(result));
		}
		
		return persons;
	}

	
	@Override
	public void addPerson(Person person) {
		String sql = "INSERT INTO person (person_id, first_name, last_name, date_added) VALUES (DEFAULT, ?, ? , ?) RETURNING person_id";
		long id = jdbcTemplate.queryForObject(sql, Long.class, person.getFirstName(), person.getLastName(), person.getDateAdded());
		person.setPersonId(id);
	}
	
	
	private Person mapRowToPerson(SqlRowSet result) {
		Person person = new Person();
		
		person.setPersonId(result.getLong("person_id"));
		person.setFirstName(result.getString("first_name"));
		person.setLastName(result.getString("last_name"));
		
		if (result.getDate("date_added") != null) {
			person.setDateAdded(result.getDate("date_added").toLocalDate());
		}
		
		person.setType(result.getString("type"));
		
		if (result.getDate("update_date") != null) {
			person.setUpdateDate(result.getDate("update_date").toLocalDate());
		}
		return person;
	}

}