package com.msedcl.main.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.customer.common.ApiResponse;
import com.msedcl.main.customer.dto.CustomerContactInfoDTO;
import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;
import com.msedcl.main.customer.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("customersapi")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Value("${build.version}")
	private String buildVersion;

	@Autowired
	private Environment environment;

	@Autowired
	private CustomerContactInfoDTO customerContactInfoDTO;

	@GetMapping("customers/customer/{customerId}")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> getCustomerByCustomerId(@PathVariable int customerId) {
		CustomerResponseDTO customerResponseDTO = customerService.getCustomerById(customerId);
		ApiResponse<CustomerResponseDTO> response = ApiResponse.<CustomerResponseDTO>builder().status("SUCCESS")
				.message("Customer Details Retrieved Successfully").data(customerResponseDTO).build();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("customers/customer/email/{email}")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> getCustomerByEmail(@PathVariable String email) {
		CustomerResponseDTO customerResponseDTO = customerService.getCustoemrByEmail(email);
		ApiResponse<CustomerResponseDTO> response = ApiResponse.<CustomerResponseDTO>builder().status("SUCCESS")
				.message("Customer Details Retrieved Successfully").data(customerResponseDTO).build();
		return ResponseEntity.status(HttpStatus.FOUND).body(response);
	}

	@Operation(summary = "Create Customer REST API", description = "REST API to create new Customer inside MyBank")
	@ApiResponses({
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "HTTP Status CREATED") })
	@PostMapping("customers/customer")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> createNewCustomer(
			@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
		log.info(customerRequestDTO.toString());
		CustomerResponseDTO customerResponseDTO = customerService.createCustomer(customerRequestDTO);
		ApiResponse<CustomerResponseDTO> response = ApiResponse.<CustomerResponseDTO>builder().status("SUCCESS")
				.message("New Customer Created Successfully").data(customerResponseDTO).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	@GetMapping("customers")
	public ResponseEntity<ApiResponse<List<CustomerResponseDTO>>> getAllCustomers() {
		List<CustomerResponseDTO> customers = customerService.getAllCustomers();
		ApiResponse<List<CustomerResponseDTO>> response = ApiResponse.<List<CustomerResponseDTO>>builder()
				.status("SUCCESS").message("Customers retrieved successfully").data(customers).build();
		return ResponseEntity.ok(response);
	}

	@GetMapping("build-info")
	public ResponseEntity<String> getBuildInfo() {
		return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
	}

	@GetMapping("java-version")
	public ResponseEntity<String> getJavaVersion() {
		return ResponseEntity.status(HttpStatus.OK).body(environment.getProperty("JAVA_HOME"));
	}

	@GetMapping("contact-info")
	public ResponseEntity<CustomerContactInfoDTO> getContactInfo() {
		return ResponseEntity.status(HttpStatus.OK).body(customerContactInfoDTO);
	}

}
