package com.msedcl.main;

import com.msedcl.main.entity.Address;
import com.msedcl.main.entity.User;
import com.msedcl.main.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OneToOneMain {

	public static void main(String[] args) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

//		User user = entityManager.find(User.class, 1);
//		System.out.println(user.getName());
//		System.out.println(user.getAddress());
		// System.out.println(user);

//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//
//		Address address = new Address(0, "Nagpur", "421100");
//		User user = new User(0, "pratibha", address);
//
//		entityManager.persist(address);
//		entityManager.persist(user);
//
//		entityTransaction.commit();
		entityManager.close();

	}

}
