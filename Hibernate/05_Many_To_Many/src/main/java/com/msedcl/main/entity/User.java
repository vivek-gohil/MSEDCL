package com.msedcl.main.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name", nullable = false, length = 50)
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_address_details", // table name
			joinColumns = @JoinColumn(name = "user_id"), // foreign key from current class
			inverseJoinColumns = @JoinColumn(name = "address_id") // foreign key from other class
	)
	private List<Address> addressList;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String name, List<Address> addressList) {
		super();
		this.userId = userId;
		this.name = name;
		this.addressList = addressList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", addressList=" + addressList + "]";
	}

}
