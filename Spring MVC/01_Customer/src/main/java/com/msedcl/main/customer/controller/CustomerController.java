package com.msedcl.main.customer.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;
import com.msedcl.main.customer.exceptions.CustomerNotFoundException;
import com.msedcl.main.customer.service.CustomerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class CustomerController {

	private CustomerService service;

	// 👉 Show form
	@GetMapping("/customers/new")
	public String showForm(Model model) {
		model.addAttribute("customer", new CustomerRequestDTO());
		return "customer-form";
	}

	// 👉 Save customer
	@PostMapping("/customers")
	public String saveCustomer(@Valid @ModelAttribute("customer") CustomerRequestDTO dto, BindingResult result) {

		if (result.hasErrors()) {
			return "customer-form";
		}

		service.createCustomer(dto);
		return "redirect:/customers";
	}

	// 👉 Get all customers
	@GetMapping("/customers")
	public String getAllCustomers(Model model) {
		List<CustomerResponseDTO> customers = service.getAllCustomers();
		model.addAttribute("customers", customers);
		return "customer-list";
	}

	// 👉 Get customer by ID
	@GetMapping("/customers/{id}")
	public String getCustomerById(@PathVariable Integer id, Model model) {
		CustomerResponseDTO customer = service.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "customer-view";
	}

	// 👉 Search by Email
	@GetMapping("/customers/search")
	public String searchByEmail(@RequestParam String email, Model model) {
		try {
			CustomerResponseDTO customer = service.getCustoemrByEmail(email);
			model.addAttribute("customer", customer);
			return "customer-view";
		} catch (CustomerNotFoundException ex) {
			model.addAttribute("errorMessage", ex.getMessage());
			return "customer-list"; // back to list
		}
	}
}