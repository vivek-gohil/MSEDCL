package com.msedcl.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.domain.Address;
import com.msedcl.main.domain.Employee;

public class EmployeeMain {
	public static void main(String[] args) {

		System.out.println("main start");

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.msedcl.main");
		
		Address address = applicationContext.getBean("address", Address.class);
		System.out.println(address);
		
		Employee employee = applicationContext.getBean("employee",Employee.class);
		System.out.println(employee);
		
		System.out.println("main end");

	}
}
