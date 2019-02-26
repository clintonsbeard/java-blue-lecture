package com.techelevator.projects.model;

import java.util.List;

public interface ProjectDAO {

	public List<Project> getAllActiveProjects();

	public void removeEmployeeFromProject(Long projectId, Long employeeId);

	public void addEmployeeToProject(Long projectId, Long employeeId);
}
