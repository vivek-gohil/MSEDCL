package com.msedcl.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.config.SpringConfiguration;
import com.msedcl.main.domain.Employee;
import com.msedcl.main.service.EmployeeService;
import com.msedcl.main.service.EmployeeServiceImpl;

public class EmployeeCRUDMain {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		EmployeeService employeeService = applicationContext.getBean(EmployeeServiceImpl.class);

		Scanner scanner = new Scanner(System.in);
		int employeeId;
		String firstName, lastName;
		double salary;
		Employee employee = null;
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

				employee = new Employee(firstName, lastName, salary);
				if (employeeService.addNewEmployee(employee))
					System.out.println("New Employee Inserted Successfully!!");
				else
					System.out.println("Failed to add new employee");
				break;
			case 2:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				employee = employeeService.getEmployeeByEmployeeId(employeeId);
				if (employee != null)
					System.out.println(employee);
				else
					System.out.println("Invalid EmployeeId");
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
				employee = new Employee(employeeId, firstName, lastName, salary);
				employee = employeeService.updateEmployee(employee);
				if (employee != null) {
					System.out.println("Employee details updated successfully");
				} else
					System.out.println("Failed to update employee");
				break;
			case 4:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				if (employeeService.deleteEmployee(employeeId))
					System.out.println("Employee deleted successfuly");
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
