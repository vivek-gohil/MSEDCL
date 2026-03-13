package com.msedcl.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.domain.Employee;
import com.msedcl.main.dto.EmployeeDTO;
import com.msedcl.main.dto.ResponseDTO;
import com.msedcl.main.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@RestController
@Slf4j
@RequestMapping("employeecrudapi")
@AllArgsConstructor
public class EmployeeCRUDController {
	private final EmployeeService employeeService;

	@DeleteMapping("employees/employee/{employeeId}")
	public ResponseEntity<ResponseDTO> removeEmployee(@PathVariable int employeeId) {
		if (employeeService.deleteEmployeeByEmployeeId(employeeId)) {
			ResponseDTO responseDTO = new ResponseDTO(HttpStatus.OK, "Employee Deleted Successfully");
			return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
		} else {
			ResponseDTO responseDTO = new ResponseDTO(HttpStatus.OK, "Employee Delete Successfully");
			return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
		}
	}

	@PutMapping("employees/employee")
	public ResponseEntity<ResponseDTO> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		log.info(employeeDTO.toString());
		EmployeeDTO updatedEmployee = employeeService.updateEmployee(employeeDTO);
		ResponseDTO responseDTO = new ResponseDTO(HttpStatus.OK, "Employee Updated Successfully");
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);

	}

	@GetMapping("employees/employee/{employeeId}")
	public ResponseEntity<EmployeeDTO> singleEmployee(@PathVariable int employeeId) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeByEmployeeId(employeeId));
	}

	@GetMapping("employees")
	public ResponseEntity<List<EmployeeDTO>> allEmployees() {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
	}

	// http://localhost:8181/employeecrudapi/employees/employee
	@PostMapping("employees/employee")
	public ResponseEntity<ResponseDTO> newEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		log.info(employeeDTO.toString());
		EmployeeDTO insertedEmployeeDTO = employeeService.addNewEmployee(employeeDTO);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,
				"Employee added with employeeId :: " + insertedEmployeeDTO.getEmployeeId()));
	}
}
