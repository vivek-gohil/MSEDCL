package com.msedcl.main.customer.service;

import java.util.List;

import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;

public interface CustomerService {

	CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);

	CustomerResponseDTO getCustomerById(Integer id);

	List<CustomerResponseDTO> getAllCustomers();

}
