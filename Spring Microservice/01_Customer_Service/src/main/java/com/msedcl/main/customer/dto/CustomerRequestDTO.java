package com.msedcl.main.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDTO {

	@NotBlank
	private String name;

	@Email
	private String email;

	@NotBlank
	private String mobileNumber;

}
