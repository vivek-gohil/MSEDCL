package com.msedcl.main;

import java.util.ArrayList;
import java.util.List;

import com.msedcl.main.entity.Address;
import com.msedcl.main.entity.User;
import com.msedcl.main.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OneToManyMain {
	public static void main(String[] args) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//
//		Address address1 = new Address(0, "Nagpur", "421100", null);
//		Address address2 = new Address(0, "Mumbai", "400012", null);
//
//		List<Address> addressList = new ArrayList<>();
//		addressList.add(address2);
//		addressList.add(address1);
//
//		User user = new User(0, "Seema", addressList);
//
//		address1.setUser(user);
//		address2.setUser(user);
//
//		entityManager.persist(address1);
//		entityManager.persist(address2);
//		entityManager.persist(user);
//
//		entityTransaction.commit();

		User user = entityManager.find(User.class, 1);
		String name = user.getName();
		int userId = user.getUserId();
		System.out.println("userId :: " + userId);
		System.out.println("Name :: " + name);
		System.out.println("List of addresses");
		List<Address> addressList = user.getAddressList();
		for (Address address : addressList) {
			System.out.println("Address id :: " + address.getAddressId());
			System.out.println("City :: " + address.getCity());
			System.out.println("Pin :: " + address.getPin());
			System.out.println("-".repeat(80));
		}

		entityManager.close();
	}
}
