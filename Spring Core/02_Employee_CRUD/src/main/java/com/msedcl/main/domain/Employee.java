package com.msedcl.main.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_details")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String name;
	private double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String name, double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}

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

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + "]";
	}

}
