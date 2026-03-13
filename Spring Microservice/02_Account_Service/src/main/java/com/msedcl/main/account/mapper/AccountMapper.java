package com.msedcl.main.account.mapper;

import com.msedcl.main.account.dto.AccountRequestDTO;
import com.msedcl.main.account.dto.AccountResponseDTO;
import com.msedcl.main.account.entity.Account;

public class AccountMapper {

	public static Account toEntity(AccountRequestDTO dto) {

		Account account = new Account();

		account.setCustomerId(dto.getCustomerId());
		account.setAccountType(dto.getAccountType());

		return account;
	}

	public static AccountResponseDTO toDTO(Account account) {

		return new AccountResponseDTO(account.getAccountId(), account.getCustomerId(), account.getAccountType(),
				account.getBalance());
	}

}
