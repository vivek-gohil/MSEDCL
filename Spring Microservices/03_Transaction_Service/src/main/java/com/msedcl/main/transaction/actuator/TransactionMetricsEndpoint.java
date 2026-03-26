package com.msedcl.main.transaction.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import com.msedcl.main.transaction.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.Map;

@Component
@Endpoint(id = "transaction-metrics")
public class TransactionMetricsEndpoint {

	@Autowired
	private TransactionRepository repository;

	@ReadOperation
	public Map<String, Object> metrics() {

		long todayTransactions = repository.countByTransactionDate(LocalDate.now());

		return Map.of("todayTransactions", todayTransactions);
	}
}