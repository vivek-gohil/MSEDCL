package com.msedcl.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.domain.Employee;
import com.msedcl.main.service.EmployeeService;
import com.msedcl.main.service.EmployeeServiceImpl;

public class EmployeeMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int employeeId;
		String name;
		double salary;
		Employee employee = null;
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.msedcl.main");

		EmployeeService employeeService = applicationContext.getBean("employeeServiceImpl", EmployeeServiceImpl.class);

		String continueChoice;
		do {
			System.out.println("Menu");
			System.out.println("1. Add New Employee Details");
			System.out.println("2. Get Employee Details By EmployeeId");
			System.out.println("3. Update First Name, Last Name, Salary");
			System.out.println("4. De-*lete Employee By EmployeeId");
			System.out.println("5. Get All Employees");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				System.out.println("Enter name");
				name = scanner.next();

				System.out.println("Enter salary");
				salary = scanner.nextDouble();

				employee = new Employee(employeeId, name, salary);
				if (employeeService.addNewEmployee(employee)) {
					System.out.println("Employee added successfully");
				} else {
					System.out.println("Fail to add employee");
				}
				break;
			case 2:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				employee = employeeService.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					System.out.println(employee);
				} else {
					System.out.println("Invalid Employee Id");
				}
				break;
			case 3:
				System.out.println("Enter exiting employee employeeId");
				employeeId = scanner.nextInt();
				System.out.println("Enter name");
				name = scanner.next();
				System.out.println("Enter salary");

				salary = scanner.nextDouble();
				employee = new Employee(employeeId, name, salary);
				employee = employeeService.updateEmployee(employee);
				if (employee != null) {
					System.out.println("Employee updated successfully");
				} else {
					System.out.println("Invalid EmployeeId ");
				}
				break;
			case 4:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				if (employeeService.deleteEmployee(employeeId))
					System.out.println("Employee deleted successfully");
				else
					System.out.println("Invalid employeeId");
				break;
			case 5:
				for (Employee e : employeeService.getAllEmployees()) {
					System.out.println(e);
				}
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue ?");
			continueChoice = scanner.next();
		} while (continueChoice.equalsIgnoreCase("yes"));
	}
}
