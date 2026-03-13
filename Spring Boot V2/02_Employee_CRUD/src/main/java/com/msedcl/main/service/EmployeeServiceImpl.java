package com.msedcl.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.msedcl.main.controller.GreetingsController;
import com.msedcl.main.domain.Employee;
import com.msedcl.main.dto.EmployeeDTO;
import com.msedcl.main.exceptions.EmployeeNotFoundException;
import com.msedcl.main.mapper.EmployeeMapper;
import com.msedcl.main.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDTO, new Employee());
		log.info(employee.toString());
		Employee insertedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapTpEmployeeDTO(insertedEmployee, new EmployeeDTO());
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		if (optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			employeeRepository.delete(employee);
			return true;
		} else
			throw new EmployeeNotFoundException("Invalid Employee Id :: " + employeeId);
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDTO, new Employee());
		Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployeeId());
		if (optionalEmployee.isPresent()) {
			Employee updatedEmployee = employeeRepository.save(employee);
			EmployeeDTO updateEmployeeDTO = EmployeeMapper.mapTpEmployeeDTO(updatedEmployee, new EmployeeDTO());
			return updateEmployeeDTO;
		} else
			throw new EmployeeNotFoundException("Invalid Employee Id :: " + employeeDTO.getEmployeeId());
	}

	@Override
	public EmployeeDTO getEmployeeByEmployeeId(int employeeId) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		if (optionalEmployee.isPresent()) {
			EmployeeDTO employeeDTO = EmployeeMapper.mapTpEmployeeDTO(optionalEmployee.get(), new EmployeeDTO());
			return employeeDTO;
		}
		throw new EmployeeNotFoundException("Invalid EmployeeId :: " + employeeId);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();

		for (Employee employee : employeeRepository.findAll()) {
			EmployeeDTO employeeDTO = EmployeeMapper.mapTpEmployeeDTO(employee, new EmployeeDTO());
			employeeDTOList.add(employeeDTO);
		}

		return employeeDTOList;
	}

}