package com.msedcl.main.transaction.mapper;

import com.msedcl.main.transaction.dto.TransactionRequestDTO;
import com.msedcl.main.transaction.dto.TransactionResponseDTO;
import com.msedcl.main.transaction.entity.Transaction;

public class TransactionMapper {

	public static Transaction toEntity(TransactionRequestDTO dto, String type) {

		Transaction transaction = new Transaction();

		transaction.setAccountId(dto.getAccountId());
		transaction.setAmount(dto.getAmount());
		transaction.setTransactionType(type);

		return transaction;
	}

	public static TransactionResponseDTO toDTO(Transaction transaction) {

		return new TransactionResponseDTO(transaction.getTransactionId(), transaction.getAccountId(),
				transaction.getTransactionType(), transaction.getAmount(), transaction.getTransactionDate());
	}
}
