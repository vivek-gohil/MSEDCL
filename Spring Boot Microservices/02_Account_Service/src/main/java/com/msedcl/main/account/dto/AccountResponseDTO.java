package com.msedcl.main.account.dto;

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
public class AccountResponseDTO {

	private Integer accountId;
	private CustomerResponseDTO customer;
	private String accountType;
	private Double balance;

}