package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcCityDao implements CityDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcCityDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<City> getAllCities() {
		String sql = "Select name FROM city";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
		
		List<City> cities = new ArrayList<City>();
		while (result.next()) {
			cities.add(new City(result.getString("name")));
		}
		
		return cities;
	}

	/*
	 * Selecting a single value like a count from the database.
	 * Multiple ways.
	 */
	@Override
	public long getCountOfCities() {
		
	
		String sql = "SELECT count(*) AS countOfCities from city";
		
		/*
		 * Can use the SqlRowSet to get the results
		 */
		//SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
		
		/*
		 * next() must be called on the result to move it to the first value
		 */
		//result.next();
		
		/*
		 * Can retrieve the count using an alias
		 */
		//long count = result.getLong("countOfCities");
		
		/*
		 * Can retrieve the count using its index, which will be 1, since data starts at position 1, 1
		 */
		//long count = result.getLong(1);
		
		/*
		 * Can also use QueryForObject when getting a single value like the count
		 */
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		
		return count;
	}
	
	
	
}
