package com.lcwd.user.service.UserService.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalUserExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<UserException> userIdNotFound(UserNotFoundException userNotFoundException){
		UserException userException = new UserException();
		userException.setHttpStatusCode(HttpStatus.OK);
		userException.setErrorMessage("User Not Found");
		userException.setLocaldatetime(LocalDateTime.now());
		return ResponseEntity.ok(userException);
	}

}
