package com.br.cadastro.view;

import lombok.Data;

@Data
public class ErrorView {

	private final String message;
	private final String errorCode;

	public ErrorView(String message, String errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}

}
