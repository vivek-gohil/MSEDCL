package com.msedcl.main.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.transaction.common.ApiResponse;
import com.msedcl.main.transaction.dto.TransactionContactInfoDTO;
import com.msedcl.main.transaction.dto.TransactionRequestDTO;
import com.msedcl.main.transaction.dto.TransactionResponseDTO;
import com.msedcl.main.transaction.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("transactionsapi")
public class TransactionController {

	@Autowired
	private TransactionContactInfoDTO transactionContactInfoDTO;

	@Autowired
	private TransactionService service;

	// Expression language
	@Value("${build.version}")
	private String buildVersion;

	@Autowired
	private Environment environment;

	/**
	 * Deposit Money
	 */
	@PostMapping("transactions/transaction/deposit")
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
	@PostMapping("transactions/transaction/withdraw")
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
	@GetMapping("transactions/account/{accountId}")
	public ResponseEntity<ApiResponse<List<TransactionResponseDTO>>> getTransactionHistory(
			@PathVariable Integer accountId) {

		List<TransactionResponseDTO> transactions = service.getTransactionsByAccount(accountId);

		ApiResponse<List<TransactionResponseDTO>> response = ApiResponse.<List<TransactionResponseDTO>>builder()
				.status("SUCCESS").message("Transaction history retrieved successfully").data(transactions).build();

		return ResponseEntity.ok(response);
	}

	@GetMapping("build-info")
	public ResponseEntity<String> getBuildInfo() {
		return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
	}

	@GetMapping("java-version")
	public ResponseEntity<String> getJavaVersion() {
		return ResponseEntity.status(HttpStatus.OK).body(environment.getProperty("JAVA_HOME"));
	}

	@GetMapping("contact-info")
	public ResponseEntity<TransactionContactInfoDTO> getContactInfo() {
		return ResponseEntity.status(HttpStatus.OK).body(transactionContactInfoDTO);
	}

}
