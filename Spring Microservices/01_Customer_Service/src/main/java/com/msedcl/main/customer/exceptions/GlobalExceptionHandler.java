package com.msedcl.main.customer.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.msedcl.main.customer.common.ApiResponse;
import com.msedcl.main.customer.dto.ErrorResponseDTO;

import jakarta.annotation.Nullable;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		Map<String, String> validationErrors = new HashMap<>();

		// Load all errors
		List<ObjectError> errors = ex.getBindingResult().getAllErrors();

		// adding field name and error message into map
		for (ObjectError objectError : errors) {
			String field = ((FieldError) objectError).getField(); // key
			String message = objectError.getDefaultMessage(); // value
			validationErrors.put(field, message);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ApiResponse<ErrorResponseDTO>> handleEmployeeNotFoundException(
			CustomerNotFoundException customerNotFoundException, WebRequest request) {
//		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
//		problemDetail.setDetail(customerNotFoundException.getMessage());
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setApiPath(request.getDescription(false));
		errorResponseDTO.setErrorMessage("Invalid CustomerId");
		errorResponseDTO.setStatus(HttpStatus.NOT_FOUND);
		errorResponseDTO.setErrorTime(LocalDateTime.now());
		
		ApiResponse<ErrorResponseDTO> errorDetails = new ApiResponse<ErrorResponseDTO>("NOT Found", customerNotFoundException.getMessage(), errorResponseDTO);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<ErrorResponseDTO>> handleEmployeeNotFoundException(
			Exception customerNotFoundException, WebRequest request) {
//		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
//		problemDetail.setDetail(customerNotFoundException.getMessage());
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setApiPath(request.getDescription(false));
		errorResponseDTO.setErrorMessage("Invalid CustomerId");
		errorResponseDTO.setStatus(HttpStatus.NOT_FOUND);
		errorResponseDTO.setErrorTime(LocalDateTime.now());
		
		ApiResponse<ErrorResponseDTO> errorDetails = new ApiResponse<ErrorResponseDTO>("NOT Found", customerNotFoundException.getMessage(), errorResponseDTO);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
	}

}