package com.lcwd.user.service.UserService.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;

public class UserException {
	
	private HttpStatusCode httpStatusCode; 
	
	private String errorMessage;
	
	private LocalDateTime localdatetime;

	public HttpStatusCode getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(HttpStatusCode httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public LocalDateTime getLocaldatetime() {
		return localdatetime;
	}

	public void setLocaldatetime(LocalDateTime localdatetime) {
		this.localdatetime = localdatetime;
	}

}
