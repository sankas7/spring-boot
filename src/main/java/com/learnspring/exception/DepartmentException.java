package com.learnspring.exception;

public class DepartmentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1568718781545786938L;

	public DepartmentException(String message) {
		super(message);
	}

	public DepartmentException(String message, Throwable cause) {
		super(message, cause);
	}

}
