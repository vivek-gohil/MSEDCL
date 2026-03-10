package com.msedcl.main;

import java.util.Arrays;
import java.util.List;

public class StreamFilterMain {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Laxman", "Rajendra", "Badrinath", "Mahesh", "Suhas");

		// Print all except Mahesh - without lambda
		for (String s : names) {
			if (!s.equals("Mahesh"))
				System.out.println(s);
		}

		// Print all except Mahesh - using streams

		names.stream().filter((s) -> !s.equals("Mahesh"))
			.forEach(p -> System.out.println(p));
	}

}
