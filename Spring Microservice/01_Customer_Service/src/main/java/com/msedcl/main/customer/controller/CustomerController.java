package com.msedcl.main.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.customer.common.ApiResponse;
import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;
import com.msedcl.main.customer.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customersapi")
public class CustomerController {

	@Autowired
	private CustomerService service;

	/**
	 * Create Customer
	 */
	@PostMapping("customers/customer")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> createCustomer(@Valid @RequestBody CustomerRequestDTO dto) {
		CustomerResponseDTO customer = service.createCustomer(dto);
		ApiResponse<CustomerResponseDTO> response = ApiResponse.<CustomerResponseDTO>builder().status("SUCCESS")
				.message("Customer created successfully").data(customer).build();
		return ResponseEntity.ok(response);
	}

	/**
	 * Get Customer by ID
	 */
	@GetMapping("customers/customer/{id}")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> getCustomerById(@PathVariable Integer id) {
		CustomerResponseDTO customer = service.getCustomerById(id);
		ApiResponse<CustomerResponseDTO> response = ApiResponse.<CustomerResponseDTO>builder().status("SUCCESS")
				.message("Customer retrieved successfully").data(customer).build();
		return ResponseEntity.ok(response);
	}

	/**
	 * Get All Customers
	 */
	@GetMapping("customers")
	public ResponseEntity<ApiResponse<List<CustomerResponseDTO>>> getAllCustomers() {
		List<CustomerResponseDTO> customers = service.getAllCustomers();
		ApiResponse<List<CustomerResponseDTO>> response = ApiResponse.<List<CustomerResponseDTO>>builder()
				.status("SUCCESS").message("Customers retrieved successfully").data(customers).build();
		return ResponseEntity.ok(response);
	}

}
