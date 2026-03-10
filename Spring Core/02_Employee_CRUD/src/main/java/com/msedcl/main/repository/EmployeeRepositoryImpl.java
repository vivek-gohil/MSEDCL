package com.msedcl.main.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.msedcl.main.domain.Employee;
import com.msedcl.main.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

	// private List<Employee> employeeList = new ArrayList<>();

	@Override
	public boolean addNewEmployee(Employee employee) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		entityManager.close();
		if (employee.getEmployeeId() > 0)
			return true;
		else
			return false;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee existingEmployee = entityManager.find(Employee.class, employee.getEmployeeId());

		// 2. existingEmployeeDetails object = state = Persistence
		if (existingEmployee != null) {
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
			entityManager.close();
			return employee;
		} else {
			entityManager.close();
			return null;
		}

	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee existingEmployee = entityManager.find(Employee.class, employeeId); // Persistent
		boolean deleteFlag = false;
		if (existingEmployee != null) {
			entityTransaction.begin();
			entityManager.remove(existingEmployee); // Removed
			entityTransaction.commit();
			deleteFlag = true;
		} else
			deleteFlag = false;
		entityManager.close();
		return deleteFlag;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		Employee employee = entityManager.find(Employee.class, employeeId);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		List<Employee> employeeDetailsList = entityManager.createQuery("FROM Employee", Employee.class).getResultList();
		employeeDetailsList.forEach(e -> System.out.println(e));
		entityManager.close();
		return employeeDetailsList;
	}

}
