package com.msedcl.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.config.SpringConfiguration;
import com.msedcl.main.service.LibraryService;

public class LibraryMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		LibraryService libraryService = applicationContext.getBean(LibraryService.class);

		libraryService.borrowBook();

	}
}
