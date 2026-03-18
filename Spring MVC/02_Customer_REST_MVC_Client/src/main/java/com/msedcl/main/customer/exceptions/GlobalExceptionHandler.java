package com.msedcl.main.customer.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//	@Override
//	protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//
//		Map<String, String> validationErrors = new HashMap<>();
//
//		// Load all errors
//		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
//
//		// adding field name and error message into map
//		for (ObjectError objectError : errors) {
//			String field = ((FieldError) objectError).getField(); // key
//			String message = objectError.getDefaultMessage(); // value
//			validationErrors.put(field, message);
//		}
//
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
//	}
//
//	@ExceptionHandler(CustomerNotFoundException.class)
//	public ResponseEntity<ErrorResponseDTO> handleEmployeeNotFoundException(
//			CustomerNotFoundException customerNotFoundException, WebRequest request) {
	//// ProblemDetail problemDetail =
	/// ProblemDetail.forStatus(HttpStatus.NOT_FOUND); problemDetail.setDetail(customerNotFoundException.getMessage());
//		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
//		errorResponseDTO.setApiPath(request.getDescription(false));
//		errorResponseDTO.setErrorMessage("Invalid CustomerId");
//		errorResponseDTO.setStatus(HttpStatus.NOT_FOUND);
//		errorResponseDTO.setErrorTime(LocalDateTime.now());
//
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
//	}

}