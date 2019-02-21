package com.techelevator.projects.model;

import java.util.List;

public interface EmployeeDAO {

	public List<Employee> getAllEmployees();
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch);
	public List<Employee> getEmployeesByDepartmentId(long id);
	public List<Employee> getEmployeesWithoutProjects();
	public List<Employee> getEmployeesByProjectId(Long projectId);
	public void changeEmployeeDepartment(Long employeeId, Long departmentId);			
}
