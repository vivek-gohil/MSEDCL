package com.msedcl.main.transaction.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDTO {

	private Integer transactionId;
	private Integer accountId;
	private String transactionType;
	private Double amount;
	private LocalDate transactionDate;

}
