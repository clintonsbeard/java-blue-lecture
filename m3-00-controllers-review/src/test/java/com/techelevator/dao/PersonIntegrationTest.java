package com.techelevator.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.dao.model.Person;


public class PersonIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	
	private PersonDao dao;
	private JdbcTemplate jdbcTemplate;
	
	@BeforeClass
	public static void createDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void destroyDataSource() {
		dataSource.destroy();
	}
	
	@After
	public void cleanup() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Before
	public void setupTest() {
		dao = new JDBCPersonDao(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Test
	public void select_all_contacts() {	
		List<Person> persons = dao.getMatchingPersons("");
		Assert.assertTrue(persons.size() > 0);		
	}
	
	@Test
	public void insert_contact() {
		int initialSize = dao.getMatchingPersons("").size();
		
		Person person = new Person();
		person.setFirstName("test");
		person.setLastName("test");
		person.setType("test");
		person.setDateAdded(LocalDate.now());
		
		dao.addPerson(person);
		
		int afterAddSize = dao.getMatchingPersons("").size();
		Assert.assertEquals(initialSize + 1, afterAddSize);
		Assert.assertTrue(person.getPersonId() > 0);
		
		int searchTermSize =  dao.getMatchingPersons("TEST").size();
		Assert.assertEquals(1, searchTermSize);
	}
	
}
