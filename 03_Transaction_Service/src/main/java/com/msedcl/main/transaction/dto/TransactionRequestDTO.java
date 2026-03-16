package com.msedcl.main.transaction.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequestDTO {

	@NotNull
	private Integer accountId;

	@NotNull
	private Double amount;

}
