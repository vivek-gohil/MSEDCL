package com.msedcl.main.account.actuator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import com.msedcl.main.account.repository.AccountRepository;

@Component
@Endpoint(id = "totalsavings-metrics")
public class SavingsAccountTypeMetricsEndpoint {
	@Autowired
	private AccountRepository accountRepository;

	@ReadOperation
	public Map<String, Object> metrics() {
		
		int totalSavingsAccounts = accountRepository.countByAccountType("SAVINGS");

		return Map.of("totalSavingsAccount", totalSavingsAccounts);
	}
}
