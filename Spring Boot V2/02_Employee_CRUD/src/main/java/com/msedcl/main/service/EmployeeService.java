package com.msedcl.main.service;

import java.util.List;
import java.util.Optional;

import com.msedcl.main.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO);

	boolean deleteEmployeeByEmployeeId(int employeeId);

	EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

	EmployeeDTO getEmployeeByEmployeeId(int employeeId);

	List<EmployeeDTO> getAllEmployees();
}
