package com.msedcl.main.transaction.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.msedcl.main.transaction.dto.AccountResponseDTO;
import com.msedcl.main.transaction.exception.AccountNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccountServiceClient {

	@Autowired
	private RestTemplate restTemplate;

	public AccountResponseDTO getAccount(Integer accountId) {

		String url = "http://localhost:8282/accountsapi/accounts/account/" + accountId;
		try {
			AccountResponseDTO accountResponseDTO = restTemplate.getForObject(url, AccountResponseDTO.class);

			return accountResponseDTO;
		} catch (HttpClientErrorException.NotFound e) {
			log.info(e.getMessage());
			throw new AccountNotFoundException("Invalid Account Number ::  " + accountId);
		} catch (HttpServerErrorException.InternalServerError e) {
			log.info(e.getMessage());
			throw new AccountNotFoundException("Invalid Account Number ::  " + accountId);
		}

	}
}
