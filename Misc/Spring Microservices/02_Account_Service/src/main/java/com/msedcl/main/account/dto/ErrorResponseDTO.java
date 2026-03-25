package com.msedcl.main.account.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ErrorResponseDTO {
	private String apiPath;
	private HttpStatus status;
	private String errorMessage;
	private LocalDateTime errorTime;
}
