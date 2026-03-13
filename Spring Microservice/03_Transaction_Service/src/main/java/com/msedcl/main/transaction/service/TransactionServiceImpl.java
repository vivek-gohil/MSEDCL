package com.msedcl.main.transaction.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msedcl.main.transaction.client.AccountServiceClient;
import com.msedcl.main.transaction.dto.AccountResponseDTO;
import com.msedcl.main.transaction.dto.TransactionRequestDTO;
import com.msedcl.main.transaction.dto.TransactionResponseDTO;
import com.msedcl.main.transaction.entity.Transaction;
import com.msedcl.main.transaction.exception.AccountNotFoundException;
import com.msedcl.main.transaction.mapper.TransactionMapper;
import com.msedcl.main.transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;

	@Autowired
	private AccountServiceClient accountClient;

	@Override
	public TransactionResponseDTO deposit(TransactionRequestDTO dto) {

		// verify account exists
		AccountResponseDTO accountResponseDTO = accountClient.getAccount(dto.getAccountId());

		if (accountResponseDTO != null) {
			Transaction transaction = TransactionMapper.toEntity(dto, "DEPOSIT");

			transaction.setTransactionDate(LocalDate.now());

			Transaction saved = repository.save(transaction);

			return TransactionMapper.toDTO(saved);
		} else {
			throw new AccountNotFoundException("Invalid AccountId :: " + dto.getAccountId());
		}
	}

	@Override
	public TransactionResponseDTO withdraw(TransactionRequestDTO dto) {
		AccountResponseDTO accountResponseDTO = accountClient.getAccount(dto.getAccountId());

		if (accountResponseDTO != null) {
			accountClient.getAccount(dto.getAccountId());

			Transaction transaction = TransactionMapper.toEntity(dto, "WITHDRAW");

			transaction.setTransactionDate(LocalDate.now());

			Transaction saved = repository.save(transaction);

			return TransactionMapper.toDTO(saved);
		} else {
			throw new AccountNotFoundException("Invalid AccountId :: " + dto.getAccountId());
		}
	}

	@Override
	public List<TransactionResponseDTO> getTransactionsByAccount(Integer accountId) {

		return repository.findByAccountId(accountId).stream().map(TransactionMapper::toDTO).toList();
	}
}
