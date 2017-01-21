package com.ing.training.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Customer Creation Failed Due to Some Conflict")
public class CustomerCreationException extends RuntimeException {
	
	public CustomerCreationException(String msg, Throwable cause)
	{
		super(msg, cause);
	}

}
