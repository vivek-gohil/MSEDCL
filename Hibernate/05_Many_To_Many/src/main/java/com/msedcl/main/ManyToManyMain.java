package com.msedcl.main;

import java.util.Arrays;

import com.msedcl.main.entity.Address;
import com.msedcl.main.entity.User;
import com.msedcl.main.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ManyToManyMain {
	public static void main(String[] args) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		User user1 = new User(0, "rajendra", null); // 1
		User user2 = new User(0, "badrinath", null); // 2

		// for user1
		Address address1 = new Address(0, "Delhi", "123456", null); // 1
//		Address address2 = new Address(0, "Nashik", "543210", null); // 2

//		user1.setAddressList(Arrays.asList(address1, address2)); // 1 1 1 2
//		user2.setAddressList(Arrays.asList(address3, address4, address2)); // 2 2 3 4

//		address1.setUsersList(Arrays.asList(user1));
//		address2.setUsersList(Arrays.asList(user1));
//		address3.setUsersList(Arrays.asList(user2));
//		address4.setUsersList(Arrays.asList(user2));
//		address2.setUsersList(Arrays.asList(user2));

		address1.setUsersList(Arrays.asList(user1, user2));

		entityManager.persist(address1);

		entityManager.persist(user1);
		entityManager.persist(user2);

		entityTransaction.commit();
		entityManager.close();

	}
}
