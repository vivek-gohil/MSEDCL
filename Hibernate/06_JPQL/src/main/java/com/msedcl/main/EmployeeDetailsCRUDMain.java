package com.msedcl.main;

import java.util.List;

import com.msedcl.main.entity.EmployeeDetails;
import com.msedcl.main.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class EmployeeDetailsCRUDMain {

	public static void main(String[] args) {
		// JPQL select example
		String query = "SELECT e FROM EmployeeDetails e WHERE e.salary between :start and :end ";

		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		TypedQuery<EmployeeDetails> typedQuery = entityManager.createQuery(query, EmployeeDetails.class);
		typedQuery.setParameter("start", 200000);
		typedQuery.setParameter("end", 500000);

		List<EmployeeDetails> employeeDetailsList = typedQuery.getResultList();

		employeeDetailsList.forEach(e -> System.out.println(e));

	}
}
