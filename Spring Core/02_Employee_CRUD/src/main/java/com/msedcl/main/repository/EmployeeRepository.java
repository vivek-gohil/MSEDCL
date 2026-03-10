package com.msedcl.main.repository;

import java.util.List;

import com.msedcl.main.domain.Employee;

public interface EmployeeRepository {
	boolean addNewEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	boolean deleteEmployee(int employeeId);

	Employee getEmployeeByEmployeeId(int employeeId);

	List<Employee> getAllEmployees();
}
