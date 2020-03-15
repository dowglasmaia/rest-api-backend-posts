package com.maia.excptions.services;

public class RuntimeExceptionError extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RuntimeExceptionError() {
		super();
	}

	public RuntimeExceptionError(String msg) {
		super(msg);
	}

}
