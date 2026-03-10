package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.main.entity.LoginDetails;
import com.msedcl.main.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LoginDetailsMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String password = "";
		System.out.println("Enter loginId");
		int loginId = scanner.nextInt();
		LoginDetails loginDetails = getLoginDetails(loginId);
		if (loginDetails != null) {
			if (loginDetails.getInvalidLoginCount() <= 3 && loginDetails.getLoginStatus().equals("ACTIVE")) {
				boolean continueFlag = true;
				do {
					System.out.println("Enter password");
					password = scanner.next();
					if (password.equals(loginDetails.getPassword())) {
						System.out.println("Login Successfull");
						continueFlag = false;
					} else {
						if (loginDetails.getInvalidLoginCount() < 3) {
							System.out.println("Invalid Password");
							updateInvalidLoginCount(loginId);
							loginDetails = getLoginDetails(loginId);
							System.out.println("Login Attempt Left :: " + (3 - loginDetails.getInvalidLoginCount()));
						} else {
							System.out.println("Account Blocked");
							updateLoginStatus(loginId);
							continueFlag = false;
						}
					}
				} while (continueFlag);
			} else {
				System.out.println("Invalid LoginCount :: " + loginDetails.getInvalidLoginCount());
				System.out.println("Login Status :: " + loginDetails.getLoginStatus());
			}
		} else {
			System.out.println("Invalid LoginId");
		}
		scanner.close();
	}

	public static LoginDetails getLoginDetails(int loginId) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		LoginDetails loginDetails = entityManager.find(LoginDetails.class, loginId);
		return loginDetails;
	}

	public static void updateInvalidLoginCount(int loginId) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		LoginDetails loginDetails = entityManager.find(LoginDetails.class, loginId);
		if (loginDetails != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			loginDetails.setInvalidLoginCount(loginDetails.getInvalidLoginCount() + 1);
			entityTransaction.commit();
		}
		entityManager.close();
	}

	public static void updateLoginStatus(int loginId) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		LoginDetails loginDetails = entityManager.find(LoginDetails.class, loginId);
		if (loginDetails != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			loginDetails.setLoginStatus("blocked");
			entityTransaction.commit();
		}
		entityManager.close();
	}
}
