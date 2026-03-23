package com.msedcl.main.customer.service;

import java.util.List;

import com.msedcl.main.customer.dto.CustomerDTO;

public interface CustomerService {

	CustomerDTO create(CustomerDTO dto);

	CustomerDTO getById(Long id);

	List<CustomerDTO> getAll();

	CustomerDTO update(Long id, CustomerDTO dto);

	void delete(Long id);
}