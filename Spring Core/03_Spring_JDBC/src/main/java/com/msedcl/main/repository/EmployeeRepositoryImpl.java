package com.msedcl.main.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msedcl.main.domain.Employee;
import com.msedcl.main.exceptions.EmployeeNotFoundException;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	// @Autowired or Parameterized Constructor
	private final JdbcTemplate jdbcTemplate;

	private static final String INSERT_EMPLOYEE = "INSERT INTO employee_details(first_name,last_name,salary) VALUES(?,?,?)";
	private static final String UPDATE_EMPLOYEE = "UPDATE employee_details SET first_name=?,last_name=?,salary=? WHERE employeeId=?";
	private static final String DELETE_EMPLOYEE = "DELETE FROM employee_details WHERE employee_id=?";
	private static final String SELECT_EMPLOYEE_BY_EMPLOYEE_ID = "SELECT * FROM employee_details WHERE employee_id = ?";
	private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee_details";

	public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		System.out.println("EmployeeRepositoryImpl object created with JdbcTemplate");
	}

	@Override
	@Transactional
	public boolean addNewEmployee(Employee employee) {
		int insertedRowCount = jdbcTemplate.update(INSERT_EMPLOYEE, employee.getFirstName(), employee.getLastName(),
				employee.getSalary());
		if (insertedRowCount > 0)
			return true;
		return false;
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		int updatedRowCount = jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getFirstName(), employee.getLastName(),
				employee.getSalary(), employee.getEmployeeId());
		if (updatedRowCount > 0)
			return employee;
		return null;
	}

	@Override
	@Transactional
	public boolean deleteEmployee(int employeeId) {
		int deletedRowCount = jdbcTemplate.update(DELETE_EMPLOYEE, employeeId);
		if (deletedRowCount > 0)
			return true;
		return false;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		try {
			EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
			Employee employee = jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BY_EMPLOYEE_ID, employeeRowMapper,
					employeeId);
			return employee;
		} catch (EmptyResultDataAccessException e) {
			throw new EmployeeNotFoundException("Invalid EmployeeId :: " + employeeId);
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		List<Employee> employeeList = jdbcTemplate.query(SELECT_ALL_EMPLOYEES, employeeRowMapper);
		return employeeList;
	}

}
