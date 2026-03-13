package com.msedcl.main.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
public class ResponseDTO {
	private HttpStatus responseCode;
	private String responseMessage;
}
