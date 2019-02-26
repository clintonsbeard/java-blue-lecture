package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> allDepartments = new ArrayList<>();
		String sqlGetAllDepartments = "SELECT department_id, name FROM department";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllDepartments);
		while (results.next()) {
			Department departmentResult = mapRowToDepartment(results);
			allDepartments.add(departmentResult);
		}
		return allDepartments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		List<Department> foundDepartments = new ArrayList<>();
		nameSearch = "%" + nameSearch + "%";
		String sqlGetFoundDepartments = "SELECT department_id, name FROM department WHERE name LIKE ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetFoundDepartments, nameSearch);
		while (results.next()) {
			Department departmentResult = mapRowToDepartment(results);
			foundDepartments.add(departmentResult);
		}
		return foundDepartments;

	}

	@Override
	public void updateDepartmentName(Long departmentId, String departmentName) {
		String sqlUpdateDepartmentName = "UPDATE department SET name=? WHERE department_id=?";
		
		jdbcTemplate.update(sqlUpdateDepartmentName, departmentName, departmentId);
	}

	@Override
	public Department createDepartment(String departmentName) {
		String sqlCreateDepartment = "INSERT INTO department (name) VALUES (?) RETURNING department_id";
		Long id = jdbcTemplate.queryForObject(sqlCreateDepartment, new Object[] {departmentName}, Long.class);
		
		return getDepartmentById(id);
	}

	@Override
	public Department getDepartmentById(Long id) {
		String sqlGetDepartment = "SELECT department_id, name FROM department WHERE department_id=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDepartment, id);
		if (results.next()) {
			return mapRowToDepartment(results);
		} else {
			return null;
		}
	}
	
	private Department mapRowToDepartment(SqlRowSet results) {
		Department department = new Department();
		department.setId(results.getLong("department_id"));
		department.setName(results.getString("name"));
		return department;
	}

}
