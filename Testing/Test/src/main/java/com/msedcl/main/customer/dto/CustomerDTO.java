package com.msedcl.main.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerDTO {

	private Long id;

	@NotBlank
	private String name;

	@Email
	private String email;
}
