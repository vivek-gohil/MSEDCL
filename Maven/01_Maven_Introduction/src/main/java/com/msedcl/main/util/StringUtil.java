package com.msedcl.main.util;

public class StringUtil {

	public void print(String s) {
		if (s != null && s.equals("")) {
			System.out.println("Invalid String");
		} else {
			System.out.println(s);
			System.out.println("Length :: " + s.length());
			System.out.println("Upper Case :: " + s.toUpperCase());
			System.out.println("Lower Case :: " + s.toLowerCase());
		}

	}
}
