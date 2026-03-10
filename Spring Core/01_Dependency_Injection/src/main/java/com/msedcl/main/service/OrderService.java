package com.msedcl.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.msedcl.main.domain.Order;

@Service
@Scope("prototype")
public class OrderService {
	private CardPaymentImpl cardPaymentImpl;

//Constructor injection
	public OrderService(CardPaymentImpl cardPaymentImpl) {
		this.cardPaymentImpl = cardPaymentImpl;
	}
//or
// private PaymentService paymentService;
//	public OrderService(PaymentService paymentService) {
//		this.paymentService = paymentService;
//	}

	public void processOrder(Order order) {
		System.out.println("Order received");
		System.out.println(order);
		cardPaymentImpl.doPayment();
	}
}
