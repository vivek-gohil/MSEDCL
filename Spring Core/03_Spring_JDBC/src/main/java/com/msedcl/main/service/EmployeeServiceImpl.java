package com.msedcl.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.domain.Employee;
import com.msedcl.main.exceptions.EmployeeNotFoundException;
import com.msedcl.main.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
		System.out.println("EmployeeServiceImpl object created and EmployeeRepository object injected");
	}

	@Override
	public boolean addNewEmployee(Employee employee) {
		System.out.println("addNewEmployee :: service class");
		return employeeRepository.addNewEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		return employeeRepository.deleteEmployee(employeeId);
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		try {
			return employeeRepository.getEmployeeByEmployeeId(employeeId);
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}

}
