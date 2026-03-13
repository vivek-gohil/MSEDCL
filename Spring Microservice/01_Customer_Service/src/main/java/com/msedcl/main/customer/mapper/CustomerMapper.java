package com.msedcl.main.customer.mapper;

import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;
import com.msedcl.main.customer.entity.Customer;

public class CustomerMapper {

	public static Customer toEntity(CustomerRequestDTO dto) {

		Customer customer = new Customer();

		customer.setName(dto.getName());
		customer.setEmail(dto.getEmail());
		customer.setMobileNumber(dto.getMobileNumber());

		return customer;
	}

	public static CustomerResponseDTO toDTO(Customer customer) {

		return new CustomerResponseDTO(customer.getCustomerId(), customer.getName(), customer.getEmail(),
				customer.getMobileNumber());
	}

}
