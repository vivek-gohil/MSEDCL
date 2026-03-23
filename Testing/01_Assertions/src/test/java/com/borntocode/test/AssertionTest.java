package com.borntocode.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.borntocode.main.util.Calculator;

public class AssertionTest {
	@Test
	void testAssertEquals() {
		Calculator calc = new Calculator();
		assertEquals(5, calc.add(2, 3));
	}

	@Test
	void testAssertNotEquals() {
		Calculator calc = new Calculator();
		assertNotEquals(6, calc.add(2, 3));
	}

	@Test
	void testAssertTrue() {
		Calculator calc = new Calculator();
		assertTrue(calc.isPositive(10));
	}

	@Test
	void testAssertFalse() {
		Calculator calc = new Calculator();
		assertFalse(calc.isPositive(-5));
	}

	@Test
	void testAssertNull() {
		Calculator calc = new Calculator();
		assertNull(calc.getNullValue());
	}

	@Test
	void testAssertNotNull() {
		Calculator calc = new Calculator();
		assertNotNull(calc.getName());
	}

	@Test
	void testAssertAll() {
		Calculator calc = new Calculator();

		assertAll(() -> assertEquals(5, calc.add(2, 3)), () -> assertTrue(calc.isPositive(5)),
				() -> assertNotNull(calc.getName()));
	}

	@Test
	void testAssertThrows() {
		assertThrows(ArithmeticException.class, () -> {
			int result = 10 / 0;
		});
	}

	@Test
	void testAssertTimeout() {
		assertTimeout(Duration.ofSeconds(2), () -> {
			Thread.sleep(1000);
		});
	}
}
