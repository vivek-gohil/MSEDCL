package com.msedcl.main.account.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequestDTO {

	@NotNull(message = "CustomerId is required")
	private Integer customerId;

	@NotBlank(message = "Account type cannot be blank")
	private String accountType;

}
