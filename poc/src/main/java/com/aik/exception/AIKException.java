package com.aik.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AIKException extends RuntimeException {
	public AIKException(String exception) {
		super(exception);
	}
}
