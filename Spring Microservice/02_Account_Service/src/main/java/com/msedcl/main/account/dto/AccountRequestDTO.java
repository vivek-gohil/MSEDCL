package com.msedcl.main.account.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequestDTO {

	@NotNull
	private Integer customerId;

	@NotBlank
	private String accountType;

}
