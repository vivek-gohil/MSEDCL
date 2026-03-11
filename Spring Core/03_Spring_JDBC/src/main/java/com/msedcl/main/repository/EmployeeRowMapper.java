package com.msedcl.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.msedcl.main.domain.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		int employeeId = rs.getInt("employee_id");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		double salary = rs.getDouble("salary");

		Employee employee = new Employee(employeeId, firstName, lastName, salary);
		return employee;
	}

}
