package com.msedcl.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
	private NotificationService notificationService;

	public LibraryService(NotificationService notificationService) {
		super();
		this.notificationService = notificationService;
	}

	public void borrowBook() {
		System.out.println("Book borrowed successfully");
		notificationService.sendNotification();
	}
}
