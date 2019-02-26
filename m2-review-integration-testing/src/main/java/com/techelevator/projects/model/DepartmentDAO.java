package com.techelevator.projects.model;

import java.util.List;

public interface DepartmentDAO {

	public List<Department> getAllDepartments();
	public List<Department> searchDepartmentsByName(String nameSearch);
	public void updateDepartmentName(Long departmentId, String departmentName);
	public Department createDepartment(String departmentName);
	public Department getDepartmentById(Long id);
}
