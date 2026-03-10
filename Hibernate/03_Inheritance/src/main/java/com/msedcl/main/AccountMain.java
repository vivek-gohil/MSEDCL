package com.msedcl.main;

import com.msedcl.main.entity.Current;
import com.msedcl.main.entity.Savings;
import com.msedcl.main.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AccountMain {
	public static void main(String[] args) {
		System.out.println("Main start");
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		// Saving object
		Savings savings = new Savings();
		savings.setAccountId(101);
		savings.setName("Suhas");
		savings.setBalance(800000);
		savings.setMinimumBalance(5000);

		// Current object
		Current current = new Current();
		current.setAccountId(102);
		current.setName("Amit");
		current.setBalance(900000);
		current.setOverdraftBalance(1000000);

		entityManager.persist(savings);
		entityManager.persist(current);

		entityTransaction.commit();
		entityManager.close();

		System.out.println("main end");
	}
}
