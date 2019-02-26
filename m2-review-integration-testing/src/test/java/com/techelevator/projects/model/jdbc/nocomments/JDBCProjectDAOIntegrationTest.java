package com.techelevator.projects.model.jdbc.nocomments;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class JDBCProjectDAOIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	private ProjectDAO dao;
	private JdbcTemplate jdbcTemplate;
	private long employeeId;
	
	
	@BeforeClass
	public static void createDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		dataSource.setAutoCommit(false);
	}


	@AfterClass
	public static void destroyDataSource() {
		dataSource.destroy();
	}


	@Before
	public void setupTest() {	
		dao = new JDBCProjectDAO(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		String createDepartmentSql = "INSERT INTO department (department_id, name) VALUES (DEFAULT, 'Test Department') RETURNING department_id";	
		int departmentId = jdbcTemplate.queryForObject(createDepartmentSql, Integer.class);
		
		String createEmployeeSql = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date)"
				+ " VALUES (DEFAULT, ?, 'TestFirst', 'TestLast', '1953-07-15', 'M', '2001-04-01') RETURNING employee_id";
		employeeId = jdbcTemplate.queryForObject(createEmployeeSql, Integer.class, departmentId);
		
	}
	

	@After
	public void cleanup() throws SQLException {
		dataSource.getConnection().rollback();
	}
	

	/* **************************************************************
	 *    TESTS for getAllActiveProjects()
	 * ************************************************************** */
	@Test
	public void get_all_active_projects_gets_1_project() {
		
		// Arrange
		List<Project> projects = dao.getAllActiveProjects();
		int originalSize = projects.size();	
		insertProject("Test", getOffSetDate(20, false), getOffSetDate(20, true)); 
		
		// Act
		projects = dao.getAllActiveProjects();
		
		// Assert
		Assert.assertEquals("Wrong number of active projects returned", originalSize + 1, projects.size());
		
	}
	
	
	@Test
	public void inactive_projects_are_not_returned_in_active_project_list() {
		
		// Arrange
		List<Project> projects = dao.getAllActiveProjects();
		int originalSize = projects.size();
		int inactiveProjectId = insertProject("Test", getOffSetDate(20, false), getOffSetDate(10, false));
		
		// Act
		projects = dao.getAllActiveProjects();
		
		// Assert 
		Assert.assertEquals("The wrong number of projects returned", originalSize, projects.size());
		
		boolean inactiveProjectFound = false;
		for (Project project : projects) {
			if (project.getId() == inactiveProjectId) {
				inactiveProjectFound = true;
			}
		}
		Assert.assertFalse("Inactive Project returned in List", inactiveProjectFound);

	}
	
	
	@Test
	public void all_active_and_only_active_projects_returned() {
		// Arrange
		clearProjectsTable();
		
		LocalDate dateBeforeToday = getOffSetDate(20, false);
		LocalDate dateAfterToday = getOffSetDate(20, true);
		insertProject("Test-BetweenDate", dateBeforeToday, dateAfterToday);  
		insertProject("Test-NullToDate", dateBeforeToday, null);
		insertProject("Test-NullFromDate", null, dateAfterToday);  
		insertProject("Inactive", getOffSetDate(30, false), getOffSetDate(20, false)); 
			
		// Act
		List<Project> projects = dao.getAllActiveProjects();
		
		// Assert
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
		// Arrange
		long projectId = insertProject("Test", getOffSetDate(10, false), getOffSetDate(20, true));
		
		// Act 
		dao.addEmployeeToProject(projectId, employeeId);
		
		// Assert
		Assert.assertTrue("Employee is not assigned to Project", isEmployeeAssignedToProject(employeeId, projectId));
		
	}
	
	
	/* **************************************************************
	 *    TESTS for removeEmployeeFromProject()
	 * ************************************************************** */
	@Test
	public void remove_employee_from_a_project_after_adding_them() {
		// Arrange
		long projectId = insertProject("Test", getOffSetDate(10, false), getOffSetDate(20, true));
		dao.addEmployeeToProject(projectId, employeeId);
		Assert.assertTrue("Employee was not assigned to Project", isEmployeeAssignedToProject(employeeId, projectId));
		
		// Act
		dao.removeEmployeeFromProject(projectId, employeeId);
		
		// Assert
		Assert.assertFalse("Employee was not removed from Project", isEmployeeAssignedToProject(employeeId, projectId));
			
	}
	

	/*
	 * What other tests could be run for add or remove Employee from Project?  Are there any?
	 */
	
	
	/* **************************************************************
	 *    Private Helper methods
	 * ************************************************************** */

	private int insertProject(String name, LocalDate fromDate, LocalDate toDate) {
		String projectSql = "INSERT INTO project (project_id, name, from_date, to_date) VALUES (DEFAULT, ?, ?, ?) RETURNING project_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(projectSql, name, fromDate, toDate);
		results.next();
		return results.getInt(1);
		
	}
	

	private LocalDate getOffSetDate(int days, boolean future) {
		LocalDate today = LocalDate.now();
		LocalDate offsetDate;
		
		if (future) {  
			offsetDate = today.plusDays(days);
		} else {  
			offsetDate = today.minusDays(days);
		}
	
		return offsetDate;
		
	}
	

	private void clearProjectsTable() {
		String truncateProjectTableSql = "TRUNCATE project CASCADE";
		jdbcTemplate.update(truncateProjectTableSql);
		
	}
	
	
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
