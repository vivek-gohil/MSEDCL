package com.msedcl.main.mapper;

import com.msedcl.main.domain.Employee;
import com.msedcl.main.dto.EmployeeDTO;

public class EmployeeMapper {
	public static Employee mapToEmployee(EmployeeDTO employeeDTO, Employee employee) {
		employee.setEmployeeId(employeeDTO.getEmployeeId());
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setSalary(employeeDTO.getSalary());
		return employee;
	}

	public static EmployeeDTO mapTpEmployeeDTO(Employee employee, EmployeeDTO employeeDTO) {
		employeeDTO.setEmployeeId(employee.getEmployeeId());
		employeeDTO.setFirstName(employee.getFirstName());
		employeeDTO.setLastName(employee.getLastName());
		employeeDTO.setSalary(employee.getSalary());
		return employeeDTO;
	}
}