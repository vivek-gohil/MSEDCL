package com.msedcl.main.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.account.common.ApiResponse;
import com.msedcl.main.account.dto.AccountContactInfoDTO;
import com.msedcl.main.account.dto.AccountRequestDTO;
import com.msedcl.main.account.dto.AccountResponseDTO;
import com.msedcl.main.account.dto.BalanceUpdateRequestDTO;
import com.msedcl.main.account.service.AccountService;

import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/accountsapi")

public class AccountController {

	@Autowired
	private AccountService service;
	
	@Autowired
	private AccountContactInfoDTO accountContactInfoDTO;
	
	//Expression Language
	@Value("${build.version}")
	private String buildVersion;

	@GetMapping("build-version")
	public ResponseEntity<String> getBuildVersion() {
		return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
	}
	
	@GetMapping("contact-info")
	public ResponseEntity<AccountContactInfoDTO> getAccountContactInfo() {
		return ResponseEntity.status(HttpStatus.OK).body(accountContactInfoDTO);
	}
	
	/**
	 * Create Account
	 */
	@PostMapping("accounts/account")
	public ResponseEntity<ApiResponse<AccountResponseDTO>> createAccount(@Valid @RequestBody AccountRequestDTO dto) {

		AccountResponseDTO account = service.createAccount(dto);
		ApiResponse<AccountResponseDTO> response = ApiResponse.<AccountResponseDTO>builder().status("SUCCESS")
				.message("Account created successfully").data(account).build();
		return ResponseEntity.ok(response);
	}

	/**
	 * Get Account by Account ID
	 */
	@GetMapping("accounts/account/{accountId}")
	public ResponseEntity<ApiResponse<AccountResponseDTO>> getAccountById(@PathVariable Integer accountId) {
		AccountResponseDTO account = service.getAccountById(accountId);
		ApiResponse<AccountResponseDTO> response = ApiResponse.<AccountResponseDTO>builder().status("SUCCESS")
				.message("Account retrieved successfully").data(account).build();
		return ResponseEntity.ok(response);
	}

	/**
	 * Get Accounts by Customer ID
	 */
	@GetMapping("accounts/customer/{customerId}")
	public ResponseEntity<ApiResponse<List<AccountResponseDTO>>> getAccountsByCustomer(
			@PathVariable Integer customerId) {
		List<AccountResponseDTO> accounts = service.getAccountsByCustomer(customerId);
		ApiResponse<List<AccountResponseDTO>> response = ApiResponse.<List<AccountResponseDTO>>builder()
				.status("SUCCESS").message("Accounts retrieved successfully").data(accounts).build();
		return ResponseEntity.ok(response);
	}

	@PutMapping("accounts/account/balance")
	public ResponseEntity<ApiResponse<AccountResponseDTO>> updateAccountBalance(
			@Valid @RequestBody BalanceUpdateRequestDTO request) {

		AccountResponseDTO account = service.updateAccountBalance(request);

		ApiResponse<AccountResponseDTO> response = ApiResponse.<AccountResponseDTO>builder().status("SUCCESS")
				.message("Account balance updated successfully").data(account).build();

		return ResponseEntity.ok(response);
	}

}