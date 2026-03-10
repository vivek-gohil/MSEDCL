package com.msedcl.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "savings_account_details")
//@PrimaryKeyJoinColumn(name = "account_id")
//@DiscriminatorValue("SAVINGS")
public class Savings extends Account {

	@Column(name = "minimum_balance")
	private double minimumBalance;

	public Savings() {
		// TODO Auto-generated constructor stub
	}

	public Savings(double minimumBalance) {
		super();
		this.minimumBalance = minimumBalance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	@Override
	public String toString() {
		return "Savings [minimumBalance=" + minimumBalance + "]";
	}

}
