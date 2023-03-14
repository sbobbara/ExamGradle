package com.online.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(AuthorizedUserRoleNotFoundException.class)
	public String handleAuthorizedUserRoleNotFound(AuthorizedUserRoleNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
	@ExceptionHandler(AuthenticationFailedException.class)
	public String handleAuthorizedFailed(AuthenticationFailedException e) {
		return e.getMessage();
	}
	
	
	
	
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(UserAlreadyExistException.class)
	public String handleUserAlreadyExist(UserAlreadyExistException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidUserRoleException.class)
	public String handleInvalidUserRole(InvalidUserRoleException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserNotFoundException.class)
	public String handleAddressNotFound(UserNotFoundException e) {
		return e.getMessage();
	}
	
	

	@ResponseStatus(HttpStatus.LOCKED)
	@ExceptionHandler(NotLoggedInException.class)
	public String handleNotLoggedIn(NotLoggedInException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler(Exception.class)
	public String handlerError(Exception e) {
		e.printStackTrace();
		return e.getMessage();
	}
}
