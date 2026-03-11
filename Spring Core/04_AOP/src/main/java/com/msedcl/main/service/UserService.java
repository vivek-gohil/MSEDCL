package com.msedcl.main.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	public void createUser(String name) {
		// logging - using aspect
		System.out.println("User Created :: " + name);
		// logging - using aspect
	}

	public void deleteUser(String name) {
		// logging - using aspect
		System.out.println("User Deleted :: " + name);
		// logging - using aspect
	}
}
