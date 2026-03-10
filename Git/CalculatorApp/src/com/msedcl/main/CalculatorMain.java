package com.msedcl.main;

import com.msedcl.main.util.CalculatorUtil;

public class CalculatorMain {

	public static void main(String[] args) {
		CalculatorUtil calculatorUtil = new CalculatorUtil();
		System.out.println("Addition = " + calculatorUtil.addition(10, 20));
		//System.out.println("Subtraction = " + calculatorUtil.subtraction(10, 2));
		System.out.println("Multiplication = " + calculatorUtil.multiplication(10, 6));
	}

}
