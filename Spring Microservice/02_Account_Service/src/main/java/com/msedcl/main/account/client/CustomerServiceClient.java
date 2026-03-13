package com.msedcl.main.account.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.msedcl.main.account.dto.CustomerResponseDTO;
import com.msedcl.main.account.exception.CustomerNotFoundException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class CustomerServiceClient {

	private RestTemplate restTemplate;

	public CustomerResponseDTO getCustomer(Integer customerId) {

		String url = "http://localhost:8181/customersapi/customers/customer/" + customerId;
		try {
			return restTemplate.getForObject(url, CustomerResponseDTO.class);
		} catch (HttpClientErrorException.NotFound e) {
			log.info("CustomerServiceClient catch");
			throw new CustomerNotFoundException("Invalid CustomerId ::  " + customerId);
		}

	}

}
