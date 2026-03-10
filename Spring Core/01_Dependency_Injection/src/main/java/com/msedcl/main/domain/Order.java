package com.msedcl.main.domain;

public class Order {
	private int orderId;
	private String productName;
	private double price;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, String productName, double price) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productName=" + productName + ", price=" + price + "]";
	}

}
