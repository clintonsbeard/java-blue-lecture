package com.techelevator.projects.model.jdbc;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

/*
 * WANT TO INTEGRATION TEST, THEN DON'T START HERE, START with the JDBCDao methods
 * 1. What are you going to test for each public methods?
 * 2. How will you validate the private methods using the public methods?  How do the private 
 *    methods, like a map method, change how you need to test?
 * 3. What are the edge cases that could break things or need to work?
 * 4. What needs to exist in the database to test each method?   How will it be created?
 * 5. How will you verify the test caused the code to do what it was supposed to do?
 * 
 * GOOD tests start on paper.  Have answers to all of the above before you even create this class
 * and start writing test code. 
 * 
 * Understand the Test Lifecycle, so you can decide what to do in each segment.
 * 	@BeforeClass - runs one time before the object is instantiated
 *      @Before - runs before each test    \
 *      @Test  -  the test					|-  (@Before, @Test, @After repeats for each test in the file)
 *      @After -  runs after each test	   /
 *  @AfterClass - runs one time as the class is being destroyed
 * 
 */

public class JDBCProjectDAOIntegrationTest {

	/*
	 * A single singleConnectionDataSource is required so we can have a class level
	 * Transaction scope for our tests.
	 */
	private static SingleConnectionDataSource dataSource;
	
	/*
	 * The DAO to test --- this is what it is all about!
	 */
	private ProjectDAO dao;
	
	/*
	 * A JdbcTemplate, made class level so we don't need to create it over and over
	 */
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * An employer id is kept class level so we can work with it in our methods, after
	 * creating the employee in the Before.  If we needed more than just the ID, we could keep
	 * a full employee object here as well.
	 */
	private long employeeId;
	
	/*
	 * BeforeClass is called prior to the Object being instantiated, which is why it is
	 * static.   Here we will setup the DataSource and change the autocommit to false
	 * to create the Transaction Scope, allowing us to Rollback our changes.
	 */
	@BeforeClass
	public static void createDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}

	/* 
	 * Called as the Object is being destroyed, which is why it is static.
	 * Cleans up the DataSource to disconnect from the database. 
	 */
	@AfterClass
	public static void destroyDataSource() {
		dataSource.destroy();
	}

	/*
	 * Runs before EVERY test.  The run lifecycle for every test is:
	 * 	@Before
	 * 	@Test
	 * 	@After
	 * 
	 * So we will add code we want repeated for every test here. 
	 * 
	 * In our Transaction scope, a new transaction will start each time this method is run.
	 */
	@Before
	public void setupTest() {
		dao = new JDBCProjectDAO(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		// A few of our tests need an Employee, so let's create one before each test..
		
		// But to create an employee properly we need a Department, so lets create one of those first
		// and get its ID to create our employee
		String createDepartmentSql = "INSERT INTO department (department_id, name) VALUES (DEFAULT, 'Test Department') RETURNING department_id";
		
		/*
		 * WAIT... where did queryForRowSet() go!  What is going on!   
		 * We can query for more than just a SqlRowSet.  In this case we plan to get back a department_id, which is just
		 * an integer.  We can use queryForRowSet(), or we can use queryForObject and tell it we want an Integer object returned,
		 * which is what this statement when it specifies Integer.class as an argument.  When queryForObject returns it returns
		 * our Single value as an Integer object, which java auto-unboxes for us into our long departmentId.  Which works
		 * because long is larger than Integer, so it can also implicitly cast it.   
		 * 
		 * This only works with Objects that SQL is familiar with and when we are getting a single value returned, and not
		 * a list of values.   PostgreSQL knows what an Integer is (same for Long, Double, etc.) so we can use this method
		 * to save a couple lines of code.  
		 * 
		 * If this is confusing, then don't focus on it, instead use queryForRowSet() and and retrieve the value using getInt().
		 */
		int departmentId = jdbcTemplate.queryForObject(createDepartmentSql, Integer.class);
		
		// Now create the Employee using the Department Id, and set the class level employeeId variable to the
		// the value of the returned employee_id so we can use it in other queries.
		String createEmployeeSql = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date)"
				+ " VALUES (DEFAULT, ?, 'TestFirst', 'TestLast', '1953-07-15', 'M', '2001-04-01') RETURNING employee_id";
		employeeId = jdbcTemplate.queryForObject(createEmployeeSql, Integer.class, departmentId);
		
	}
	
	/*
	 * Runs after each test.  Here we will Rollback the Transaction to cleanup our changes.
	 */
	@After
	public void cleanup() throws SQLException {
		dataSource.getConnection().rollback();
	}
	

	/* **************************************************************
	 *    TESTS for getAllActiveProjects()
	 * ************************************************************** */
	@Test
	public void get_all_active_projects_gets_1_project() {
		// Arrange - setup
			// Get the starting count of active projects
		List<Project> projects = dao.getAllActiveProjects();
		int originalSize = projects.size();
		
			// Create a New Project that is active
		//insertProject("Test", "2019-02-01", "2022-03-01");  // This is going fail in about 3 years
		insertProject("Test", getOffSetDate(20, false), getOffSetDate(20, true)); // Update to use Date Objects
		
		// Act - do the test, usually 1 line
		// Get All Active Projects
		projects = dao.getAllActiveProjects();
		
		// Assert - Verify that number of projects is 1 more than the original number of active projects
		Assert.assertEquals("Wrong number of active projects returned", originalSize + 1, projects.size());
	}
	
	@Test
	public void inactive_projects_are_not_returned_in_active_project_list() {
		
		// Arrange
			// Get the starting count of Active Projects
		List<Project> projects = dao.getAllActiveProjects();
		int originalSize = projects.size();
			//Create a new Project that is not active, so to and from dates are both prior to today
		int inactiveProjectId = insertProject("Test", getOffSetDate(20, false), getOffSetDate(10, false));
		
		// Act - Get All Active Projects
		projects = dao.getAllActiveProjects();
		
		// Assert 
			// Assert that the number of active projects returned has not increased
		Assert.assertEquals("The wrong number of projects returned", originalSize, projects.size());
		
			// The count may be enough, but what if we want to be sure?  We can check the list.
		boolean inactiveProjectFound = false;
		for (Project project : projects) {
			if (project.getId() == inactiveProjectId) {
				inactiveProjectFound = true;
			}
		}
		 	// Assert that the inactive Project Id was not found in the list
		Assert.assertFalse("Inactive Project returned in List", inactiveProjectFound);

	}
	
	@Test
	public void all_active_and_only_active_projects_returned() {
		// Arrange
			/*
			 *  Clear all data from the Projects Table.  This is in a Transaction so it is safe as long
			 *  everything goes as planned.  If not, then we have destroyed data in the test database.  
			 *  We'll take the risk this time!
			 */
			clearProjectsTable();
			// Create 4 projects - 3 Active and 1 Inactive
			LocalDate dateBeforeToday = getOffSetDate(20, false);
			LocalDate dateAfterToday = getOffSetDate(20, true);
			insertProject("Test-BetweenDate", dateBeforeToday, dateAfterToday);  // Active - Covers today between the from and to dates
			insertProject("Test-NullToDate", dateBeforeToday, null);  // Active - Covers null to_date
			insertProject("Test-NullFromDate", null, dateAfterToday);  // Active - Covers null from_date
			insertProject("Inactive", getOffSetDate(30, false), getOffSetDate(20, false));  // Inactive Project
			
			// Act - the test
			List<Project> projects = dao.getAllActiveProjects();
			
			
			// Assert the size is 3, only the active dates where found
			// We can just assert the count, because we cleared the table, so only our projects should be there.
			Assert.assertEquals("Wrong number of projects returned", 3, projects.size());		
	}
	
	/*
	 * What other tests could we do for getAllActiveProjects()?   What are the edge cases?
	 * What happens if the to_date or the from_date is TODAY?
	 * What happens if both dates are null?
	 * What happens if both dates are in the past?
	 * What happens if both dates are in the future?
	 */

	
	/* **************************************************************
	 *    TESTS for addEmployeeToProject()
	 * ************************************************************** */
	@Test
	public void add_an_employee_to_a_project() {
		
		// Arrange - Create a project.  We don't need to create an Employee as it was done in the @Before
		long projectId = insertProject("Test", getOffSetDate(10, false), getOffSetDate(20, true));
		
		// Act (the test)
		dao.addEmployeeToProject(projectId, employeeId);
		
		// Assert that the Employee is Assigned to the Project, we can use our private method to check!
		Assert.assertTrue("Employee is not assigned to Project", isEmployeeAssignedToProject(employeeId, projectId));
	}
	
	
	/* **************************************************************
	 *    TESTS for removeEmployeeFromProject()
	 * ************************************************************** */
	@Test
	public void remove_employee_from_a_project_after_adding_them() {
		
		// Arrange - there are a few steps here!
			//Create a project.  We don't need to create an Employee as it was done in the @Before
		long projectId = insertProject("Test", getOffSetDate(10, false), getOffSetDate(20, true));
		
			// Add the employee to the Project, since the Project DAO contains a method to add an employee
			// to a project, we will use it.  If it did not contain this method, we would need to write a query
			// to do the insert and execute it with the JdbcTemplate.
		dao.addEmployeeToProject(projectId, employeeId);
		
			// Verify the Employee has been added using our private method.
		Assert.assertTrue("Employee was not assigned to Project", isEmployeeAssignedToProject(employeeId, projectId));
		
		// Act - the test
		dao.removeEmployeeFromProject(projectId, employeeId);
		
		// Assert that the Employee is no longer assigned, again we can use our private method, which should now return FALSE
		Assert.assertFalse("Employee was not removed from Project", isEmployeeAssignedToProject(employeeId, projectId));
			
	}
	

	/*
	 * What other tests could be run for add or remove Employee from Project?  Are there any?
	 */
	
	
	/* **************************************************************
	 *    Private Helper methods
	 *    Integration Test Classes are just regular classes, so we can create Private methods to do
	 * 	  repetitive work
	 * ************************************************************** */
	
	/*
	 * A private method to Insert a Project for testing into the Projects table, and return the project_id
	 */
	private int insertProject(String name, LocalDate fromDate, LocalDate toDate) {
		/*
		 * NOTE: We could concatenate the Insert with our dates to make adding them easier in this case, because
		 * they are all hardcoded in this class, so there is no user input or outside dates to open us to SQL Injection
		 * 
		 * We used Strings for the Review.  This was done to avoid the time it would have taken to review usage of the
		 * Date object in the Review.
		 * 
		 * The correct, and easier way, is to use Date objects with parameters.
		 * This method has been updated to use Date objects instead of Strings.
		 * 
		 */
		String projectSql = "INSERT INTO project (project_id, name, from_date, to_date) VALUES (DEFAULT, ?, ?, ?) RETURNING project_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(projectSql, name, fromDate, toDate);
		results.next();
		return results.getInt(1);
	}
	
	/*
	 * A private method to allow us to create dates in the future or past for use in our inserts
	 * 
	 * The date will be offset by the value passed in the days argument
	 * If the boolean future is TRUE then a date in the future will be created
	 * If the boolean future is FALSE then a date in the past will be created
	 * 
	 * Example:  getOffSetDate(20, true) - will return a Date 20 days from today
	 *           getOffSetDate(10, false) - will return a Date 10 days in the past
	 * 
	 * This will allow our tests to run based on the current date, and removes the issue we talked about 
	 * in the review of a hardcoded future date eventually being in the past, causing the tests to fail.
	 */
	private LocalDate getOffSetDate(int days, boolean future) {
		LocalDate today = LocalDate.now();
		LocalDate offsetDate;
		
		if (future) {  // If future is true, then add the number of days
			offsetDate = today.plusDays(days);
		} else {   // If future is false, then subtract the number of days
			offsetDate = today.minusDays(days);
		}
	
		return offsetDate;
	}
	
	/*
	 * A private method that deletes all rows from the Projects table.  
	 * 
	 * WARNING: Doing this will remove all data from the Project table.  CASCADE will cause to also 
	 *          remove all data with referential integrity to the Projects Table.  This can be VERY dangerous.
	 *          This also can be very slow for a large dataset.  It also can have consequences we don't intend due
	 *          to the CASCADE.  
	 *          
	 *          For example, used on the Department table, the cascade will clear all data from the
	 *          entire database, since Employee has a Dependency on Department, and project_employee has a dependency on 
	 *          Employee, and Project has a dependency on project_employee.   The CASCADE will cause each of the 
	 *          dependent tables to be TRUNCATED as well, so everything!   
	 *          
	 *          Only use a Truncate if:
	 *          	1. You feel comfortable with the possibility of something going wrong and deleting all the data
	 *          	2. You understand what will be removed and how that affects your test
	 *              3. The dataset is not too large, which is subjective, but for example, for a table with a few 
	 *                 thousand rows it may be fine, but for a table with a few million it may be slow.
	 */
	private void clearProjectsTable() {
		String truncateProjectTableSql = "TRUNCATE project CASCADE";
		jdbcTemplate.update(truncateProjectTableSql);
	}
	
	
	/*
	 * Does a select for the given employee id and project id on the project_employee table
	 * If a value is returned, then the employee is assigned to the project so return true
	 * If no value is returned, then the employee is not assigned to the project so return false
	 * 
	 * This is done as a private method since we need this functionality in more than one test case.
	 */
	private boolean isEmployeeAssignedToProject(long empId, long projectId) {
		String selectProjectEmployeeSql = "SELECT project_id, employee_id FROM project_employee WHERE project_id = ? AND employee_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectProjectEmployeeSql, projectId, empId);
		
		if (results.next()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
}
