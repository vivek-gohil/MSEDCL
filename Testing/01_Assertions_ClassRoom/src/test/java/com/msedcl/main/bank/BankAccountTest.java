package com.msedcl.main.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class BankAccountTest {

	private BankAccount account;

	// Runs once before all tests
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All Tests Executed");
	}

	// Runs before each test
	@BeforeEach
	void setUp() {
		account = new BankAccount("Vivek", 1000);
		System.out.println("New BankAccount created with balance 1000");
	}

	// Test deposit
	@Test
	@DisplayName("Test Deposit")
	void testDeposit() {
		account.deposit(500);
		assertEquals(1500, account.getBalance());
	}

	// Test withdraw (valid case)
	@Test
	@DisplayName("Test Withdraw Valid")
	void testWithdraw() {
		account.withdraw(300);
		assertEquals(700, account.getBalance());
	}

	// Test withdraw (insufficient balance)
	@Test
	@DisplayName("Test Withdraw Insufficient Balance")
	void testWithdrawInsufficientBalance() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			account.withdraw(2000);
		});

		assertEquals("Insufficient balance", exception.getMessage());
	}

	// Test get balance
	@Test
	@DisplayName("Test Get Balance")
	void testGetBalance() {
		assertEquals(1000, account.getBalance());
	}

	// Test reset account
	@Test
	@DisplayName("Test Reset Account")
	void testResetAccount() {
		account.resetAccount();
		assertEquals(0, account.getBalance());
	}

	// Negative deposit test
	@Test
	@DisplayName("Test Negative Deposit")
	void testNegativeDeposit() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			account.deposit(-100);
		});

		assertEquals("Deposit amount must be positive", exception.getMessage());
	}

	// Runs after each test
	@AfterEach
	void tearDown() {
		System.out.println("Test Completed");
	}

	// Runs once after all tests
	@AfterAll
	static void afterAll() {
		System.out.println("All Tests Completed");
	}
}