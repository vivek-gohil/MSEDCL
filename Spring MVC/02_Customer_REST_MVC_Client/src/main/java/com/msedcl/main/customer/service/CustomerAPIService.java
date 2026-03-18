package com.msedcl.main.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msedcl.main.customer.common.ApiResponse;
import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;

@Service
public class CustomerAPIService {
	@Autowired
	private RestTemplate restTemplate;

	private final String BASE_URL = "http://localhost:8181/customersapi/customers";

	// ✅ Get All Customers
	public List<CustomerResponseDTO> getAllCustomers() {
		ResponseEntity<ApiResponse<List<CustomerResponseDTO>>> response = restTemplate.exchange(BASE_URL,
				HttpMethod.GET, null, new ParameterizedTypeReference<ApiResponse<List<CustomerResponseDTO>>>() {
				});

		return response.getBody().getData();
	}

	// ✅ Get Customer By ID
	public CustomerResponseDTO getCustomerById(int id) {
		String url = BASE_URL + "/customer/" + id;

		ResponseEntity<ApiResponse<CustomerResponseDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<ApiResponse<CustomerResponseDTO>>() {
				});

		return response.getBody().getData();
	}

	// ✅ Create Customer
	public CustomerResponseDTO createCustomer(CustomerRequestDTO request) {
		String url = BASE_URL + "/customer";

		HttpEntity<CustomerRequestDTO> entity = new HttpEntity<>(request);

		ResponseEntity<ApiResponse<CustomerResponseDTO>> response = restTemplate.exchange(url, HttpMethod.POST, entity,
				new ParameterizedTypeReference<ApiResponse<CustomerResponseDTO>>() {
				});

		return response.getBody().getData();
	}

	// ✅ Get Customer By Email
	public CustomerResponseDTO getCustomerByEmail(String email) {
		String url = BASE_URL + "/customer/email/" + email;

		ResponseEntity<ApiResponse<CustomerResponseDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<ApiResponse<CustomerResponseDTO>>() {
				});

		return response.getBody().getData();
	}

}
