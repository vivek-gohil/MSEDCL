package com.msedcl.main.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_details")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;

	@Column(name = "city", nullable = false, length = 50)
	private String city;

	@Column(name = "pin", nullable = false, length = 10)
	private String pin;

	@ManyToMany(mappedBy = "addressList", cascade = CascadeType.ALL)
	private List<User> usersList;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String city, String pin, List<User> usersList) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.pin = pin;
		this.usersList = usersList;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", pin=" + pin + ", usersList=" + usersList + "]";
	}

}
