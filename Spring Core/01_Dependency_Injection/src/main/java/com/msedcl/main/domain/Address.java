package com.msedcl.main.domain;

import org.springframework.stereotype.Component;

@Component
public class Address {
	private int addressId;
	private String city;
	private String pin;

	public Address() {
		System.out.println("default constructor of Address");
	}

	public Address(int addressId, String city, String pin) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.pin = pin;
		System.out.println("parameterized constructor of Address");
	}

	public int getAddressId() {
		System.out.println("getAddressId");
		return addressId;
	}

	public void setAddressId(int addressId) {
		System.out.println("setAddressId");
		this.addressId = addressId;
	}

	public String getCity() {
		System.out.println("getCity");
		return city;
	}

	public void setCity(String city) {
		System.out.println("setCity");
		this.city = city;
	}

	public String getPin() {
		System.out.println("getPin");
		return pin;
	}

	public void setPin(String pin) {
		System.out.println("setPin");
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", pin=" + pin + "]";
	}

}
