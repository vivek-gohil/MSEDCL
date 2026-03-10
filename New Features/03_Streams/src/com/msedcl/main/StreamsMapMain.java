package com.msedcl.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsMapMain {
	public static void main(String[] args) {
		List<String> alphabets = Arrays.asList("a", "b", "c", "d", "e");

		// Convert alphabets into upper case and store into new list

		List<String> upperCaseAlphabets = new ArrayList<>();

		for (String s : alphabets) {
			upperCaseAlphabets.add(s.toUpperCase());
		}

		// Print using Streams with lambda expression
		alphabets.stream().map((s) -> s.toUpperCase()).forEach((s) -> System.out.println(s));

		// Collect into list
		upperCaseAlphabets = alphabets.stream().map((s) -> s.toUpperCase()).collect(Collectors.toList());
		upperCaseAlphabets.forEach(s -> System.out.println(s));
	}
}
