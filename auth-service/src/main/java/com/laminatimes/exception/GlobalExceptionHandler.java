package com.laminatimes.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.laminatimes.login.response.LoginResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		LoginResponse loginRes = new LoginResponse();
		loginRes.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		loginRes.setDescription("login failed, Internal Server Error");
		loginRes.setErrorCode("500");
		String bodyOfResponse = loginRes.toString();
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
				request);
	}

	@ExceptionHandler(UserNotFoundRuntimeException.class)
	public ResponseEntity<ErrorResponse> userHandleNotFound(Exception ex, WebRequest request) {
		ErrorResponse errors = new ErrorResponse();
		errors.setErrorCode("404");
		errors.setDescription("User not found");
		errors.setStatus(HttpStatus.NOT_FOUND);
		errors.setTimestamp(LocalDateTime.now()); 
		
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ BadCredentialsException.class, IllegalArgumentException.class })
	public ResponseEntity<Object> handleBadCredentialsException(Exception ex, WebRequest request) {
		ErrorResponse errors = new ErrorResponse();
		errors.setErrorCode("404");
		errors.setDescription("User not found");
		errors.setStatus(HttpStatus.NOT_FOUND);
		errors.setTimestamp(LocalDateTime.now()); 
		
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ DisabledException.class })
	public ResponseEntity<Object> handleDisabledException(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>("Disabled credentials", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>("Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
	}

}
