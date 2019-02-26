package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JDBCCityDAOIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ";
	
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JDBCCityDAO dao;
	
	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);
		dao = new JDBCCityDAO(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
<<<<<<< HEAD
	public void save_new_city_and_read_it_back() throws SQLException {
		
		/* Arrange */
		City theCity = getCity("SQL Station", "South Dakota", "USA", 65535);
		
		/* Act 1: Insert */
		dao.save(theCity);
		
		/* Act 2: Select */
		City savedCity = dao.findCityById(theCity.getId());
		
		/* Assert */
=======
	public void save_new_city_and_read_it_back()  {
		
		// Arrange
		City theCity = getCity("SQL Station", "South Dakota", "USA", 65535);
		
		// Act 1 : Insert
		dao.save(theCity);
		
		// Act 2 : Select
		City savedCity = dao.findCityById(theCity.getId());
		
		// Assert
>>>>>>> 9d13d3c3274b7664b35bfa7caf16879e22e18e3c
		assertNotEquals(null, theCity.getId());
		assertCitiesAreEqual(theCity, savedCity);
	}

	@Test
	public void returns_cities_by_country_code() {
		
<<<<<<< HEAD
		/* Arrange */
		City theCity = getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);
		dao.save(theCity);
		
		/* Act */
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		
		/* Assert */
=======
		// Arrange
		City theCity = getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);
		dao.save(theCity);
		
		// Act
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		
		// Assert
>>>>>>> 9d13d3c3274b7664b35bfa7caf16879e22e18e3c
		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}
	
	@Test
	public void returns_multiple_cities_by_country_code() {

<<<<<<< HEAD
		/* Arrange */
		dao.save(getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535));
		dao.save(getCity("Postgres Point", "North Dakota", TEST_COUNTRY, 65535));
		
		/* Act */
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		
		/* Assert */
=======
		// Arrange
		dao.save(getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535));
		dao.save(getCity("Postgres Point", "North Dakota", TEST_COUNTRY, 65535));
		
		// Act
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		
		// Assert
>>>>>>> 9d13d3c3274b7664b35bfa7caf16879e22e18e3c
		assertNotNull(results);
		assertEquals(2, results.size());
	}
	
	@Test
	public void returns_cities_by_district() {
		
<<<<<<< HEAD
		/* Arrange */
=======
		// Arrange
>>>>>>> 9d13d3c3274b7664b35bfa7caf16879e22e18e3c
		String testDistrict = "Tech Elevator";
		City theCity = getCity("SQL Station", testDistrict, TEST_COUNTRY, 65535);
		dao.save(theCity);
		
<<<<<<< HEAD
		/* Act */
		List<City> results = dao.findCityByDistrict(testDistrict);
		
		/* Assert */
=======
		// Act
		List<City> results = dao.findCityByDistrict(testDistrict);
		
		
		// Assert
>>>>>>> 9d13d3c3274b7664b35bfa7caf16879e22e18e3c
		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}
	
	private City getCity(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}

	private void assertCitiesAreEqual(City expected, City actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDistrict(), actual.getDistrict());
		assertEquals(expected.getCountryCode(), actual.getCountryCode());
		assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
