package com.msedcl.main;

import java.util.List;

import com.msedcl.main.entity.EmployeeDetails;
import com.msedcl.main.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EmployeeDetailsCRUDMain {

	public static void main(String[] args) {
		// Criteria API
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmployeeDetails> criteriaQuery = criteriaBuilder.createQuery(EmployeeDetails.class);

		Root<EmployeeDetails> root = criteriaQuery.from(EmployeeDetails.class); // SELECT * FROM employee_details

		Predicate condition = criteriaBuilder.equal(root.get("firstName"), "Rajendra");

		criteriaQuery.select(root).where(condition);

		List<EmployeeDetails> employeeList = entityManager.createQuery(criteriaQuery).getResultList();

		for (EmployeeDetails employeeDetails : employeeList) {
			System.out.println(employeeDetails);
		}

	}
}
