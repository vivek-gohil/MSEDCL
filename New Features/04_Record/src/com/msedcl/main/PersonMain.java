package com.msedcl.main;

import java.util.ArrayList;
import java.util.List;

import com.msedcl.main.domain.Person;
import com.msedcl.main.domain.PersonRecord;

public class PersonMain {
	public static void main(String[] args) {
		Person p = new Person("Badrinath", "F", 35);

		System.out.println(p.getFirstName());
		System.out.println(p.getLastName());
		System.out.println(p.getAge());
		
		
		p.setFirstName("Badri");
		
		System.out.println("---------------------------");
		
		PersonRecord pr = new PersonRecord("Santosh", "A", 35);
		System.out.println(pr.firstName());
		System.out.println(pr.lastName());
		System.out.println(pr.age());
		
		PersonRecord pr2 = new PersonRecord("Vivek", "G", 35);
		
		List<PersonRecord> recordList = new ArrayList<>();
		recordList.add(pr);
		recordList.add(pr2);
		System.out.println(recordList);
		
		
		
	}
}
