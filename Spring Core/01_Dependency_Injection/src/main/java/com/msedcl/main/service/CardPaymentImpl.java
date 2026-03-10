package com.msedcl.main.service;

import org.springframework.stereotype.Service;

@Service
public class CardPaymentImpl implements PaymentService {
	@Override
	public void doPayment() {
		System.out.println("Card payment processed successfully!");
	}
}
