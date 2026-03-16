package com.msedcl.main.transaction.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msedcl.main.transaction.client.AccountServiceClient;
import com.msedcl.main.transaction.dto.AccountResponseDTO;
import com.msedcl.main.transaction.dto.BalanceUpdateRequestDTO;
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

		BalanceUpdateRequestDTO request = new BalanceUpdateRequestDTO();
		request.setAccountId(dto.getAccountId());
		request.setAmount(dto.getAmount());
		request.setTransactionType("DEPOSIT");

		accountClient.updateBalance(request);

		Transaction transaction = TransactionMapper.toEntity(dto, "DEPOSIT");

		transaction.setTransactionDate(LocalDate.now());

		Transaction saved = repository.save(transaction);

		return TransactionMapper.toDTO(saved);
	}

	@Override
	public TransactionResponseDTO withdraw(TransactionRequestDTO dto) {

		BalanceUpdateRequestDTO request = new BalanceUpdateRequestDTO();
		request.setAccountId(dto.getAccountId());
		request.setAmount(dto.getAmount());
		request.setTransactionType("WITHDRAW");

		accountClient.updateBalance(request);

		Transaction transaction = TransactionMapper.toEntity(dto, "WITHDRAW");

		transaction.setTransactionDate(LocalDate.now());

		Transaction saved = repository.save(transaction);

		return TransactionMapper.toDTO(saved);
	}

	@Override
	public List<TransactionResponseDTO> getTransactionsByAccount(Integer accountId) {
		return repository.findByAccountId(accountId).stream().map(TransactionMapper::toDTO).toList();
	}
}
