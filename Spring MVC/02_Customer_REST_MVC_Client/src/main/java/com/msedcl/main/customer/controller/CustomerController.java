package com.msedcl.main.customer.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;
import com.msedcl.main.customer.exceptions.CustomerNotFoundException;
import com.msedcl.main.customer.service.CustomerAPIService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/customers") // ✅ Added base mapping (clean URL design)
public class CustomerController {

	private final CustomerAPIService service; // ✅ final (best practice)

	// 👉 Show form
	@GetMapping("/new")
	public String showForm(Model model) {
		model.addAttribute("customer", new CustomerRequestDTO());
		return "customer-form";
	}

	// 👉 Save customer
	@PostMapping
	public String saveCustomer(@Valid @ModelAttribute("customer") CustomerRequestDTO dto, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "customer-form";
		}

		try {
			service.createCustomer(dto); // 🔥 calls REST API now
			return "redirect:/customers";
		} catch (Exception ex) {
			model.addAttribute("errorMessage", "Failed to create customer");
			return "customer-form";
		}
	}

	// 👉 Get all customers
	@GetMapping
	public String getAllCustomers(Model model) {
		List<CustomerResponseDTO> customers = service.getAllCustomers(); // 🔥 API call
		model.addAttribute("customers", customers);
		return "customer-list";
	}

	// 👉 Get customer by ID
	@GetMapping("/{id}")
	public String getCustomerById(@PathVariable Integer id, Model model) {
		try {
			CustomerResponseDTO customer = service.getCustomerById(id); // 🔥 API call
			model.addAttribute("customer", customer);
			return "customer-view";
		} catch (CustomerNotFoundException ex) {
			model.addAttribute("errorMessage", ex.getMessage());
			return "customer-list";
		}
	}

	// 👉 Search by Email
	@GetMapping("/search")
	public String searchByEmail(@RequestParam String email, Model model) {
		try {
			CustomerResponseDTO customer = service.getCustomerByEmail(email); // ✅ fixed typo
			model.addAttribute("customer", customer);
			return "customer-view";
		} catch (CustomerNotFoundException ex) {
			model.addAttribute("errorMessage", ex.getMessage());
			return "customer-list";
		}
	}
}