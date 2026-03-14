package com.msedcl.main.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerRequestDTO {
	@NotBlank(message = "Name cannot be blank")
	private String name;

	@Email(message = "Invalid email")
	private String email;

	@NotBlank(message = "Mobile number cannot be blank")
	private String mobileNumber;
}
