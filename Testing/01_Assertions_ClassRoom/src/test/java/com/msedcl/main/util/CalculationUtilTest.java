package com.msedcl.main.util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CalculationUtilTest {
	@Test
	void testAssertEqual() {
		CalculationUtil calculationUtil = new CalculationUtil();
		assertEquals(5, calculationUtil.add(3, 2));
	}

	@Test
	void testAssertNotEqual() {
		CalculationUtil calculationUtil = new CalculationUtil();
		assertNotEquals(6, calculationUtil.add(2, 3));
	}

	@Test
	void testAssertTrue() {
		CalculationUtil calculationUtil = new CalculationUtil();
		assertTrue(calculationUtil.isPositive(9));
	}

	@Test
	void testAssertFalse() {
		CalculationUtil calculationUtil = new CalculationUtil();
		assertFalse(calculationUtil.isPositive(-9));
	}

	@Test
	void testAssertNull() {
		CalculationUtil calculationUtil = new CalculationUtil();
		assertNull(calculationUtil.getNullValue());
		// assertNull(calculationUtil.getName());
	}

	@Test
	void testAssertNotNull() {
		CalculationUtil calculationUtil = new CalculationUtil();
		assertNotNull(calculationUtil.getName());
	}

	@Test
	void testAssertAll() {
		CalculationUtil calculationUtil = new CalculationUtil();
		assertAll(() -> assertEquals(5, calculationUtil.add(3, 2)), () -> assertTrue(calculationUtil.isPositive(5)));
	}

	@Test
	void testAssertThrows() {
		CalculationUtil calculationUtil = new CalculationUtil();
		assertThrows(ArithmeticException.class, () -> {
			calculationUtil.divide(6,2);
		});
	}

}
