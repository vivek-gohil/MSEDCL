package com.msedcl.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.msedcl.main.domain.Person;

public class PersonLambdaMain {
	public static void main(String[] args) {
		Person person1 = new Person("Swapnil", "Jadhav", 35);
		Person person2 = new Person("Pratibha", "Nannaware", 40);
		Person person3 = new Person("Rajshri", "Deshmukh", 35);
		Person person4 = new Person("Sneha", "Nalawade", 35);
		Person person5 = new Person("Rajendra", "Bhoyar", 50);

		List<Person> people = Arrays.asList(person1, person2, person3, person4, person5);

		// with lambda expressions
		// Step 1 :: Sort the list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// Step 2 :: Create a method that prints all the elements from list
		System.out.println("Printing All After Sorting");
		printAll(people);

		System.out.println("---------------------------");
		// Step 3 :: Create a method that prints all people
		// that have last name starts with N
		System.out.println("Starts with N");
		printAllStartsWith(people, "J");

		System.out.println("---------------------------");
		// Step 4 :: Create a method that prints all people
		// that have first name end with a
		System.out.println("Ends with a");
		printAllEndsWith(people, "l");
	}

	public static void printAllEndsWith(List<Person> people, String s) {
		for (Person person : people) {
			if (person.getFirstName().endsWith(s))
				System.out.println(person);
		}
	}

	public static void printAllStartsWith(List<Person> people, String s) {
		for (Person person : people) {
			if (person.getLastName().startsWith(s))
				System.out.println(person);
		}
	}

	public static void printAll(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);
		}
	}
}
