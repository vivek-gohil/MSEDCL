package com.msedcl.main;

import java.util.List;
import java.util.Scanner;

import com.msedcl.main.entity.EmployeeDetails;
import com.msedcl.main.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeDetailsCRUDMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int employeeId;
		String firstName, lastName;
		double salary;
		EmployeeDetails employeeDetails = null;
		String continueChoice;
		do {
			System.out.println("Menu");
			System.out.println("1. Add New Employee Details");
			System.out.println("2. Get Employee Details By EmployeeId");
			System.out.println("3. Update First Name, Last Name, Salary");
			System.out.println("4. Delete Employee By EmployeeId");
			System.out.println("5. Get All Employees");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter first name");
				firstName = scanner.next();
				System.out.println("Enter last name");
				lastName = scanner.next();
				System.out.println("Enter salary");
				salary = scanner.nextDouble();

				employeeDetails = new EmployeeDetails(firstName, lastName, salary);
				addNewEmployeeDetails(employeeDetails);
				break;
			case 2:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				getEmployeeDetailsByEmployeeId(employeeId);
				break;
			case 3:
				System.out.println("Enter exiting employee employeeId");
				employeeId = scanner.nextInt();
				System.out.println("Enter new first name");
				firstName = scanner.next();
				System.out.println("Enter new last name");
				lastName = scanner.next();
				System.out.println("Enter new salary");
				salary = scanner.nextDouble();
				employeeDetails = new EmployeeDetails(employeeId, firstName, lastName, salary);
				updateEmployeeDetails(employeeDetails);
				break;
			case 4:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				deleteEmployeeDetailsByEmployeeId(employeeId);
				break;
			case 5:
				getAllEmployeeDetails();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue ?");
			continueChoice = scanner.next();
		} while (continueChoice.equalsIgnoreCase("yes"));
	}

	public static void getAllEmployeeDetails() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		List<EmployeeDetails> employeeDetailsList = entityManager
				.createQuery("FROM EmployeeDetails", EmployeeDetails.class).getResultList();
		employeeDetailsList.forEach(e -> System.out.println(e));
		entityManager.close();
	}

	public static void deleteEmployeeDetailsByEmployeeId(int employeeId) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		EmployeeDetails existingEmployeeDetails = entityManager.find(EmployeeDetails.class, employeeId); // Persistent
		if (existingEmployeeDetails != null) {
			entityTransaction.begin();
			entityManager.remove(existingEmployeeDetails); // Removed
			entityTransaction.commit();
			System.out.println("Employee Details Deleted Successfully!!");
		} else
			System.out.println("Invalid EmployeeId");
		entityManager.close();
	}

	public static void updateEmployeeDetails(EmployeeDetails employeeDetails) {
		// 1. employeeDetails object = state = Transient

		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		EmployeeDetails existingEmployeeDetails = entityManager.find(EmployeeDetails.class,
				employeeDetails.getEmployeeId());

		// 2. existingEmployeeDetails object = state = Persistence
		if (existingEmployeeDetails != null) {
			entityTransaction.begin();

			entityManager.merge(employeeDetails);
//			existingEmployeeDetails.setFirstName(employeeDetails.getFirstName());
//			existingEmployeeDetails.setLastName(employeeDetails.getLastName());
//			existingEmployeeDetails.setSalary(employeeDetails.getSalary());
			entityTransaction.commit();
			System.out.println("Employee Details Updated Successfully!!");
		} else
			System.out.println("Invalid EmployeeId");
		entityManager.close();
	}

	public static void getEmployeeDetailsByEmployeeId(int employeeId) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		EmployeeDetails employeeDetails = entityManager.find(EmployeeDetails.class, employeeId);
		if (employeeDetails != null)
			System.out.println(employeeDetails);
		else
			System.out.println("Invalid EmployeeId");
		entityManager.close();
	}

	public static void addNewEmployeeDetails(EmployeeDetails employeeDetails) {

		// Entity States :: 1. Transient , 2. Persistent , 3. Detached , 4. Removed

		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		System.out.println(employeeDetails);
		entityManager.persist(employeeDetails); // Persistent
		entityTransaction.commit();
		System.out.println("EmployeeId = " + employeeDetails.getEmployeeId());
		entityManager.close(); // Detached
		System.out.println("New employee details added successfully!!");
	}

}
