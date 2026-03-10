package com.msedcl.main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.msedcl.main.domain.Person;

public class ForEachMain {
	public static void main(String[] args) {
		Person person1 = new Person("Swapnil", "Jadhav", 35);
		Person person2 = new Person("Pratibha", "Nannaware", 40);
		Person person3 = new Person("Rajshri", "Deshmukh", 35);
		Person person4 = new Person("Sneha", "Nalawade", 35);
		Person person5 = new Person("Rajendra", "Bhoyar", 50);

		List<Person> people = Arrays.asList(person1, person2, person3, person4, person5);

		for (Person person : people) {
			System.out.println(person);
		}

		System.out.println();

		people.forEach(new Consumer<Person>() {
			@Override
			public void accept(Person p) {
				System.out.println(p);
			}
		});
		
		System.out.println();
		
		people.forEach((p) -> System.out.println(p));

	}
}
