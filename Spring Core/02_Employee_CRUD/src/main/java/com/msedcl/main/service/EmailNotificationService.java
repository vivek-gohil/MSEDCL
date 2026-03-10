package com.msedcl.main.service;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {

	@Override
	public void sendNotification() {
		System.out.println("Email notification sent!!");
	}
}
