package com.msedcl.main;

import java.util.List;

import com.msedcl.main.entity.EmployeeDetails;
import com.msedcl.main.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class EmployeeDetailsCRUDMain {

	public static void main(String[] args) {
		// Print All
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		EmployeeDetails employeeDetails = entityManager.find(EmployeeDetails.class, 1);

		System.out.println(employeeDetails);

		System.out.println(employeeDetails.getEmployeeId());
		System.out.println(employeeDetails.getFirstName());
		System.out.println(employeeDetails.getLastName());
		System.out.println(employeeDetails.getSalary());

		System.out.println();

		employeeDetails = entityManager.find(EmployeeDetails.class, 2);

		System.out.println(employeeDetails);

		entityManager.close();

//		EntityManager entityManager = EntityManagerUtil.getEntityManager();
//
//		TypedQuery<EmployeeDetails> typedQuery = entityManager.createNamedQuery("EmployeeDetails.findAll",
//				EmployeeDetails.class);
//
//		List<EmployeeDetails> employeeDetailsList = typedQuery.getResultList();
//
//		employeeDetailsList.forEach(e -> System.out.println(e));
//
//		System.out.println("-".repeat(80));
//
//		TypedQuery<EmployeeDetails> typedQuery2 = entityManager.createNamedQuery("EmployeeDetails.findByName",
//				EmployeeDetails.class);
//
//		typedQuery2.setParameter("name", "Mahesh");
//
//		employeeDetailsList = typedQuery2.getResultList();
//
//		employeeDetailsList.forEach(e -> System.out.println(e));
	}
}
