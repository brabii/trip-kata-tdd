package com.kata.tdd.exception;

public class CollaboratorCallException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CollaboratorCallException() {
		super();
	}

	public CollaboratorCallException(String message, Throwable cause) {
		super(message, cause);
	}

	public CollaboratorCallException(String message) {
		super(message);
	}

	public CollaboratorCallException(Throwable cause) {
		super(cause);
	}

}
