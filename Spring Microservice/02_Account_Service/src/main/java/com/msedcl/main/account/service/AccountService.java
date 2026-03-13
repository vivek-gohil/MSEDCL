package com.msedcl.main.account.service;

import java.util.List;

import com.msedcl.main.account.dto.AccountRequestDTO;
import com.msedcl.main.account.dto.AccountResponseDTO;

public interface AccountService {

	AccountResponseDTO createAccount(AccountRequestDTO dto);

	AccountResponseDTO getAccountById(Integer id);

	List<AccountResponseDTO> getAccountsByCustomer(Integer customerId);

}
