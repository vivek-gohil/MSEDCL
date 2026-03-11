package com.msedcl.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.config.SpringConfiguration;
import com.msedcl.main.service.UserService;

public class UserMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		UserService userService = applicationContext.getBean(UserService.class);

		userService.createUser("Mahesh!");

		System.out.println();

		userService.deleteUser("Vivek");
	}
}
