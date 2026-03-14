package com.msedcl.main.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;
import com.msedcl.main.customer.entity.Customer;
import com.msedcl.main.customer.exceptions.CustomerNotFoundException;
import com.msedcl.main.customer.mapper.CustomerMapper;
import com.msedcl.main.customer.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository repository;

	@Override
	public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {
		Customer customer = CustomerMapper.toEntity(dto);
		Customer savedCustomer = repository.save(customer);
		return CustomerMapper.toDTO(savedCustomer);
	}

	@Override
	public CustomerResponseDTO getCustomerById(Integer id) {
		Customer customer = repository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found for customerId :: " + id));

		return CustomerMapper.toDTO(customer);
	}

	@Override
	public List<CustomerResponseDTO> getAllCustomers() {
		return repository.findAll().stream().map(CustomerMapper::toDTO).toList();
	}

	@Override
	public CustomerResponseDTO getCustoemrByEmail(String email) {
		Customer customer = repository.findByEmail(email)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found for emailId :: " + email));
		return CustomerMapper.toDTO(customer);
	}
}
