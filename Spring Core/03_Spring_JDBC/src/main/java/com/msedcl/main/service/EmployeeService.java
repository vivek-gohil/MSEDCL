package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.domain.Employee;

public interface EmployeeService {
	boolean addNewEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	boolean deleteEmployee(int employeeId);

	Employee getEmployeeByEmployeeId(int employeeId);

	List<Employee> getAllEmployees();
}
