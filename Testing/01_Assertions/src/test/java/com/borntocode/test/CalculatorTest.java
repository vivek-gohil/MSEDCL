package com.borntocode.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.borntocode.main.util.Calculator;

class CalculatorTest {

	Calculator calc;

	@BeforeAll
	static void initAll() {
		System.out.println("🔵 Before All - Initialize resources (DB, files)");
	}

	@BeforeEach
	void setup() {
		System.out.println("🟢 Before Each - Create fresh object");
		calc = new Calculator();
	}

	@Test
	void testAdd1() {
		System.out.println("✅ Running testAdd1");
		assertEquals(5, calc.add(2, 3));
	}

	@Test
	void testAdd2() {
		System.out.println("✅ Running testAdd2");
		assertEquals(7, calc.add(3, 4));
	}

	@AfterEach
	void tearDown() {
		System.out.println("🟡 After Each - Cleanup after test");
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("🔴 After All - Release resources");
	}
}
