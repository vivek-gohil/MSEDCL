package com.msedcl.main.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculationUtilTestV2 {

	CalculationUtil calculationUtil;
	
	@BeforeAll
	static void initAll() {
		System.out.println("initAll :: BeforeAll");
	}

	@BeforeEach
	void setup() {
		System.out.println("setup :: BeforeEach");
		calculationUtil = new CalculationUtil();
	}

	@Test
	void testOne() {
		System.out.println("testOne :: Test");
		assertEquals(5, calculationUtil.add(3, 2));
	}

	@Test
	void testTwo() {
		System.out.println("testTwo :: Test");
		assertTrue(calculationUtil.isPositive(9));
	}

	@AfterEach
	void tearDown() {
		System.out.println("tearDown :: AfterEach");
		calculationUtil = null;
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("tearDownAll :: AfterAll");
	}

}
