package com.cloudifiers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cloudifiers.model.Error;
import com.cloudifiers.model.UserEntityResponse;

@ControllerAdvice
public class CloudifiersExceptionHandler {

	@ExceptionHandler(value = { NoUserFoundException.class })
	public ResponseEntity<UserEntityResponse> handleNoUserFoundError() {
		return new ResponseEntity<UserEntityResponse>(
				new UserEntityResponse(Boolean.FALSE, Error.USER_NOT_FOUND.getErrorCode(), null),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Void> handleInternalServerError() {
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
