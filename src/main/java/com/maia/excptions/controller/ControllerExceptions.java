package com.maia.excptions.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maia.excptions.services.ObjectNotFoundException;
import com.maia.excptions.services.RuntimeExceptionError;

@ControllerAdvice
public class ControllerExceptions {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<TemplateErrorApi> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		TemplateErrorApi error = new TemplateErrorApi(System.currentTimeMillis(), status.value(), "Não encontrado",
				e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(error);

	}

	@ExceptionHandler(RuntimeExceptionError.class)
	public ResponseEntity<TemplateErrorApi> runtimeExceptionError(RuntimeExceptionError e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		TemplateErrorApi error = new TemplateErrorApi(System.currentTimeMillis(), status.value(), "Error Interno",
				e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(error);

	}

}
