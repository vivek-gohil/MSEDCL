package com.msedcl.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.msedcl.main.domain.Person;
import com.msedcl.main.service.Condition;

public class PersonLambdaMain2 {
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
		printConditionally(people, (p) -> true, 
				(p) -> System.out.println(p.getFirstName() + " " + p.getLastName()));

		System.out.println("---------------------------");
		// Step 3 :: Create a method that prints all people
		// that have last name starts with N
		printConditionally(people, (p) -> p.getLastName().startsWith("N"), 
				(p) -> System.out.println(p.getLastName()));

		System.out.println("---------------------------");
		// Step 4 :: Create a method that prints all people
		// that have first name end with a
		printConditionally(people, (p) -> p.getFirstName().endsWith("a"),
				(p) -> System.out.println(p.getFirstName()));
	}

	public static void printConditionally(List<Person> people, 
				Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person person : people) {
			if (predicate.test(person)) {
				consumer.accept(person);
			}

		}
	}

}
