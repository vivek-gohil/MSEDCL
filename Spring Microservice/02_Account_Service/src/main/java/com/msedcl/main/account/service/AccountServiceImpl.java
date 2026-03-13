package com.msedcl.main.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.account.client.CustomerServiceClient;
import com.msedcl.main.account.dto.AccountRequestDTO;
import com.msedcl.main.account.dto.AccountResponseDTO;
import com.msedcl.main.account.dto.CustomerResponseDTO;
import com.msedcl.main.account.entity.Account;
import com.msedcl.main.account.mapper.AccountMapper;
import com.msedcl.main.account.repository.AccountRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository repository;
	private CustomerServiceClient customerClient;

	@Override
	public AccountResponseDTO createAccount(AccountRequestDTO dto) {
		// Verify customer exists
		CustomerResponseDTO customerResponseDTO = customerClient.getCustomer(dto.getCustomerId());
		if (customerResponseDTO != null) {
			Account account = AccountMapper.toEntity(dto);
			account.setBalance(0.0);
			Account saved = repository.save(account);
			return AccountMapper.toDTO(saved);
		} else {
			log.info("in else");
			throw new RuntimeException("Invalid CustomerId :: " + dto.getCustomerId());
		}

	}

	@Override
	public AccountResponseDTO getAccountById(Integer id) {

		Account account = repository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
		return AccountMapper.toDTO(account);
	}

	@Override
	public List<AccountResponseDTO> getAccountsByCustomer(Integer customerId) {
		return repository.findByCustomerId(customerId).stream().map(AccountMapper::toDTO).toList();
	}

}
