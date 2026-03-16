package com.msedcl.main.account.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.msedcl.main.account.common.ApiResponse;
import com.msedcl.main.account.dto.CustomerResponseDTO;
import com.msedcl.main.account.exception.CustomerNotFoundException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomerServiceClient {
	private final RestTemplate restTemplate;

	public CustomerResponseDTO getCustomerById(Integer customerId) {
		String url = "http://localhost:8181/customersapi/customers/customer/" + customerId;
		try {
//			ApiResponse<CustomerResponseDTO> response = restTemplate.getForObject(url, ApiResponse.class);
//			return response;

			ResponseEntity<ApiResponse<CustomerResponseDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<ApiResponse<CustomerResponseDTO>>() {
					});

			return response.getBody().getData();
		} catch (HttpClientErrorException.NotFound e) {
			throw new CustomerNotFoundException("Invalid CustomerId :: " + customerId);
		}

	}
}
