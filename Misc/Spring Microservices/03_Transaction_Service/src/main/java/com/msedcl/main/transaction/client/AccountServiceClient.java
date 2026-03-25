package com.msedcl.main.transaction.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.msedcl.main.transaction.common.ApiResponse;
import com.msedcl.main.transaction.dto.AccountResponseDTO;
import com.msedcl.main.transaction.dto.BalanceUpdateRequestDTO;
import com.msedcl.main.transaction.exception.AccountNotFoundException;
import com.msedcl.main.transaction.exception.InsufficientBalanceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccountServiceClient {

	@Autowired
	private RestTemplate restTemplate;

	private static final String ACCOUNT_SERVICE_BASE_URL = "http://localhost:8282/accountsapi/accounts";

	/**
	 * Fetch Account Details
	 */
	public AccountResponseDTO getAccount(Integer accountId) {

		String url = ACCOUNT_SERVICE_BASE_URL + "/account/" + accountId;

		try {

			ResponseEntity<ApiResponse<AccountResponseDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<ApiResponse<AccountResponseDTO>>() {
					});

			return response.getBody().getData();

		} catch (HttpClientErrorException.NotFound e) {
			log.error("Account not found: {}", accountId);
			throw new AccountNotFoundException("Invalid Account Number :: " + accountId);

		} catch (HttpServerErrorException.InternalServerError e) {
			log.error("Account service internal error: {}", e.getMessage());
			throw new RuntimeException("Account Service unavailable");
		}
	}

	/**
	 * Update Account Balance (Deposit / Withdraw)
	 */
	public AccountResponseDTO updateBalance(BalanceUpdateRequestDTO request) {
		String url = ACCOUNT_SERVICE_BASE_URL + "/account/balance";
		try {
			HttpEntity<BalanceUpdateRequestDTO> entity = new HttpEntity<>(request);
			ResponseEntity<ApiResponse<AccountResponseDTO>> response = restTemplate.exchange(url, HttpMethod.PUT,
					entity, new ParameterizedTypeReference<ApiResponse<AccountResponseDTO>>() {
					});
			return response.getBody().getData();
		} catch (HttpClientErrorException.NotFound e) {
			log.error("Account not found while updating balance: {}", request.getAccountId());
			throw new AccountNotFoundException("Invalid Account Number :: " + request.getAccountId());

		} catch (HttpServerErrorException.InternalServerError e) {
			log.error("Account service internal error: {}", e.getMessage());
			throw new InsufficientBalanceException("Account Service unavailable");
		}
	}
}
