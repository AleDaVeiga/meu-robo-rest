package com.meurobo.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private HttpStatus status;

	public BadRequestException(HttpStatus status) {
		this.status = status;
	}

	public String getMensagem() {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append(this.status.value());
		mensagem.append(" ");
		mensagem.append(this.status.getReasonPhrase());
		return mensagem.toString();
	}
}
