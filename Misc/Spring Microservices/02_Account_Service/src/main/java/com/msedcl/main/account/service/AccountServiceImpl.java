package com.msedcl.main.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.account.client.CustomerServiceClient;
import com.msedcl.main.account.dto.AccountRequestDTO;
import com.msedcl.main.account.dto.AccountResponseDTO;
import com.msedcl.main.account.dto.BalanceUpdateRequestDTO;
import com.msedcl.main.account.dto.CustomerResponseDTO;
import com.msedcl.main.account.entity.Account;
import com.msedcl.main.account.exception.AccountNotFoundException;
import com.msedcl.main.account.exception.CustomerNotFoundException;
import com.msedcl.main.account.exception.InsufficientBalanceException;
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
		CustomerResponseDTO customerResponseDTO = customerClient.getCustomerById(dto.getCustomerId());

		log.info(customerResponseDTO.toString());
		if (customerResponseDTO != null) {
			Account account = AccountMapper.toEntity(dto);
			account.setBalance(0.0);
			Account saved = repository.save(account);
			return AccountMapper.toDTO(saved, customerResponseDTO);
		} else {
			throw new CustomerNotFoundException("Customer Not Found with CustomerId :: " + dto.getCustomerId());
		}

	}

	@Override
	public AccountResponseDTO getAccountById(Integer id) {

		Account account = repository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account Not Found with AccountId :: " + id));

		CustomerResponseDTO customerResponseDTO = customerClient.getCustomerById(account.getCustomerId());
		return AccountMapper.toDTO(account, customerResponseDTO);
	}

	@Override
	public List<AccountResponseDTO> getAccountsByCustomer(Integer customerId) {
		CustomerResponseDTO customerResponseDTO = customerClient.getCustomerById(customerId);
//		return repository.findByCustomerId(customerId).stream().map(new Function<Object, AccountResponseDTO>() {
//			@Override
//			public AccountResponseDTO apply(Account account) {
//				return AccountMapper.toDTO(account, response.getData());
//			}
//		}).toList();
//		
//		
//		Object object = new CustomerResponseDTO();
		return repository.findByCustomerId(customerId).stream().map(a -> AccountMapper.toDTO(a, customerResponseDTO))
				.toList();

	}

	@Override
	public AccountResponseDTO updateAccountBalance(BalanceUpdateRequestDTO request) {
		Account account = repository.findById(request.getAccountId()).orElseThrow(
				() -> new AccountNotFoundException("Account not found for AccountId" + request.getAccountId()));
		double currentBalance = account.getBalance();
		double amount = request.getAmount();
		if ("DEPOSIT".equalsIgnoreCase(request.getTransactionType())) {
			account.setBalance(currentBalance + amount);
		}
		if ("WITHDRAW".equalsIgnoreCase(request.getTransactionType())) {
			if (currentBalance < amount) {
				throw new InsufficientBalanceException("Insufficient balance");
			}
			account.setBalance(currentBalance - amount);
		}
		Account updatedAccount = repository.save(account);
		CustomerResponseDTO customerResponseDTO = customerClient.getCustomerById(account.getCustomerId());
		return AccountMapper.toDTO(updatedAccount, customerResponseDTO);
	}

}