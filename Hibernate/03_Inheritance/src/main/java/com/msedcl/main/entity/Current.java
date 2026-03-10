package com.msedcl.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "current_account_details")
//@DiscriminatorValue("CURRENT")
//@PrimaryKeyJoinColumn(name = "account_id")
public class Current extends Account {

	@Column(name = "overdraft_balance")
	private double overdraftBalance;

	public Current() {
		// TODO Auto-generated constructor stub
	}

	public Current(double overdraftBalance) {
		super();
		this.overdraftBalance = overdraftBalance;
	}

	public double getOverdraftBalance() {
		return overdraftBalance;
	}

	public void setOverdraftBalance(double overdraftBalance) {
		this.overdraftBalance = overdraftBalance;
	}

	@Override
	public String toString() {
		return "Current [overdraftBalance=" + overdraftBalance + "]";
	}

}
