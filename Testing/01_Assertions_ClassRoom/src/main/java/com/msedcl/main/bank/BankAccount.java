package com.msedcl.main.bank;

public class BankAccount {

	private String accountHolderName;
	private double balance;

	// Constructor
	public BankAccount(String accountHolderName, double balance) {
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	// Deposit method
	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Deposit amount must be positive");
		}
		balance += amount;
	}

	// Withdraw method
	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Withdraw amount must be positive");
		}
		if (amount > balance) {
			throw new RuntimeException("Insufficient balance");
		}
		balance -= amount;
	}

	// Get balance
	public double getBalance() {
		return balance;
	}

	// Reset account
	public void resetAccount() {
		balance = 0;
	}
}
