package com.msedcl.main.transaction.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountServiceHealthIndicator implements HealthIndicator {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Health health() {

		try {

			String url = "http://localhost:8282/actuator/health";

			restTemplate.getForObject(url, String.class);

			return Health.up().withDetail("account-service", "Available").build();

		} catch (Exception ex) {

			return Health.down().withDetail("account-service", "Unavailable").build();
		}
	}
}