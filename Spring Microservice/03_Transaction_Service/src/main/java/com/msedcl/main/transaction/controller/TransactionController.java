package com.msedcl.main.transaction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.transaction.common.ApiResponse;
import com.msedcl.main.transaction.dto.TransactionRequestDTO;
import com.msedcl.main.transaction.dto.TransactionResponseDTO;
import com.msedcl.main.transaction.service.TransactionService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("transactionsapi")
public class TransactionController {

	private TransactionService service;

	/**
	 * Deposit Money
	 */
	@PostMapping("transaction/deposit")
	public ResponseEntity<ApiResponse<TransactionResponseDTO>> depositMoney(
			@Valid @RequestBody TransactionRequestDTO dto) {

		TransactionResponseDTO transaction = service.deposit(dto);

		ApiResponse<TransactionResponseDTO> response = ApiResponse.<TransactionResponseDTO>builder().status("SUCCESS")
				.message("Money deposited successfully").data(transaction).build();

		return ResponseEntity.ok(response);
	}

	/**
	 * Withdraw Money
	 */
	@PostMapping("transaction/withdraw")
	public ResponseEntity<ApiResponse<TransactionResponseDTO>> withdrawMoney(
			@Valid @RequestBody TransactionRequestDTO dto) {

		TransactionResponseDTO transaction = service.withdraw(dto);

		ApiResponse<TransactionResponseDTO> response = ApiResponse.<TransactionResponseDTO>builder().status("SUCCESS")
				.message("Money withdrawn successfully").data(transaction).build();

		return ResponseEntity.ok(response);
	}

	/**
	 * View Transaction History by Account
	 */
	@GetMapping("transaction/account/{accountId}")
	public ResponseEntity<ApiResponse<List<TransactionResponseDTO>>> getTransactionHistory(
			@PathVariable Integer accountId) {

		List<TransactionResponseDTO> transactions = service.getTransactionsByAccount(accountId);

		ApiResponse<List<TransactionResponseDTO>> response = ApiResponse.<List<TransactionResponseDTO>>builder()
				.status("SUCCESS").message("Transaction history retrieved successfully").data(transactions).build();

		return ResponseEntity.ok(response);
	}

}
