package com.meurobo.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ComandoInvalidoException extends BadRequestException {
	private static final long serialVersionUID = 1L;

	public ComandoInvalidoException() {
		super(BAD_REQUEST);
	}
}