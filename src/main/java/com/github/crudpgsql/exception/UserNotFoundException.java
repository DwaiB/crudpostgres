package com.github.crudpgsql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1816016340508303937L;
	public UserNotFoundException(String message) {
		super(message);
	}
}
