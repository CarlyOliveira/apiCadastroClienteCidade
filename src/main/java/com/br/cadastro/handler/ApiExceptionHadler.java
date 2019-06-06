package com.br.cadastro.handler;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.br.cadastro.exception.CadastroException;
import com.br.cadastro.view.ErrorView;

@ControllerAdvice
public class ApiExceptionHadler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ErrorView fieldsException(MethodArgumentNotValidException ex) {
		return new ErrorView(ex.getBindingResult().getFieldError().getDefaultMessage(),
				HttpStatus.BAD_REQUEST.toString());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CadastroException.class)
	@ResponseBody
	public ErrorView cadastroException(CadastroException ex) {
		return new ErrorView(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ErrorView constraintViolationException(ConstraintViolationException ex) {
		return new ErrorView(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorView handleException(Exception ex) {
		return new ErrorView(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
	}

}
