package com.maia.excptions.services;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -6892082801934939425L;

	public ObjectNotFoundException() {
		super();
	}

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
