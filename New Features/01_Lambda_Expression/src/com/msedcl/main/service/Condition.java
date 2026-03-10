package com.msedcl.main.service;

import com.msedcl.main.domain.Person;

public interface Condition {
	boolean test(Person person);
}
