package com.msedcl.main.transaction.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msedcl.main.transaction.client.AccountServiceClient;
import com.msedcl.main.transaction.dto.BalanceUpdateRequestDTO;
import com.msedcl.main.transaction.dto.TransactionRequestDTO;
import com.msedcl.main.transaction.dto.TransactionResponseDTO;
import com.msedcl.main.transaction.entity.Transaction;
import com.msedcl.main.transaction.mapper.TransactionMapper;
import com.msedcl.main.transaction.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		log.info("Balance updated for :: accountId" + request.getAccountId());

		Transaction transaction = TransactionMapper.toEntity(dto, "DEPOSIT");
		transaction.setTransactionDate(LocalDate.now());
		Transaction saved = repository.save(transaction);
		log.info("Transaction details saved into table with transactionId :: " + saved.getTransactionId());

		TransactionResponseDTO transactionResponseDTO = TransactionMapper.toDTO(saved);

		// Adding AccountResponseDTO object into TransactionResponseDTO object
		transactionResponseDTO.setAccount(accountClient.getAccount(request.getAccountId()));

		return transactionResponseDTO;
	}

	@Override
	public TransactionResponseDTO withdraw(TransactionRequestDTO dto) {

		BalanceUpdateRequestDTO request = new BalanceUpdateRequestDTO();
		request.setAccountId(dto.getAccountId());
		request.setAmount(dto.getAmount());
		request.setTransactionType("WITHDRAW");

		accountClient.updateBalance(request);
		log.info("Balance updated for :: accountId" + request.getAccountId());

		Transaction transaction = TransactionMapper.toEntity(dto, "WITHDRAW");
		transaction.setTransactionDate(LocalDate.now());
		Transaction saved = repository.save(transaction);
		log.info("Transaction details saved into table with transactionId :: " + saved.getTransactionId());

		TransactionResponseDTO transactionResponseDTO = TransactionMapper.toDTO(saved);

		// Adding AccountResponseDTO object into TransactionResponseDTO object
		transactionResponseDTO.setAccount(accountClient.getAccount(request.getAccountId()));

		return transactionResponseDTO;
	}

	@Override
	public List<TransactionResponseDTO> getTransactionsByAccount(Integer accountId) {
		// return
		// repository.findByAccountId(accountId).stream().map(TransactionMapper::toDTO).toList();
		List<Transaction> transactionList = repository.findByAccountId(accountId);

		List<TransactionResponseDTO> transactionResponseDTOList = new ArrayList<>();

		for (Transaction transaction : transactionList) {
			TransactionResponseDTO transactionResponseDTO = TransactionMapper.toDTO(transaction);
			// Adding AccountResponseDTO object into TransactionResponseDTO object
			transactionResponseDTO.setAccount(accountClient.getAccount(accountId));
			transactionResponseDTOList.add(transactionResponseDTO);
		}

		return transactionResponseDTOList;

	}
}
