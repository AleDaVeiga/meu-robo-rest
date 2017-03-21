package com.meurobo.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class LimiteTerrenoException extends BadRequestException {
	private static final long serialVersionUID = 1L;

	public LimiteTerrenoException() {
		super(BAD_REQUEST);
	}
}