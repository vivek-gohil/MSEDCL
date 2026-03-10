package com.msedcl.main.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	private int employeeId;
	private String name;
	private double salary;

	private Address address;
	// private Address address = new Address();

//	public Employee() {
//		System.out.println("default constructor of Employee");
//	}

	public Employee(Address address) {
		this.address = address;
		System.out.println("only address - parameterized constructor of Employee");
	}

//	public Employee(int employeeId, String name, double salary, Address address) {
//		super();
//		this.employeeId = employeeId;
//		this.name = name;
//		this.salary = salary;
//		this.address = address;
//		System.out.println("parameterized constructor of Employee");
//	}

	public int getEmployeeId() {
		System.out.println("getEmployeeId");
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		System.out.println("setEmployeeId");
		this.employeeId = employeeId;
	}

	public String getName() {
		System.out.println("getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}

	public double getSalary() {
		System.out.println("getSalary");
		return salary;
	}

	public void setSalary(double salary) {
		System.out.println("setSalary");
		this.salary = salary;
	}

	public Address getAddress() {
		System.out.println("getAddress");
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("setAddress");
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", address=" + address
				+ "]";
	}

}
