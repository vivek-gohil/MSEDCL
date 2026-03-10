package com.msedcl.main;

import com.msedcl.main.service.Calculations;

public class CalculationsMain {
	public static void main(String[] args) {
		Calculations add = (double number1, double number2) -> {
			return number1 + number2;
		};
		double result = add.doCalculations(10, 20);
		System.out.println("Addition = " + result);

		Calculations sub = (n1, n2) -> n1 - n2;
		result = sub.doCalculations(10, 20);
		System.out.println("Subtraction = " + result);

		printResult((n1, n2) -> n1 * n2, 2, 3);

		printResult((n1, n2) -> n1 / n2, 4, 2);

	}

	public static void printResult(Calculations calculations, 
			double n1, double n2) {
		double result = calculations.doCalculations(n1, n2);
		System.out.println(result);
	}
}
