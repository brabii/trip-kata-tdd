package com.kata.tdd.exception;

public class DependendClassCallDuringUnitTestException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DependendClassCallDuringUnitTestException() {
		super();
	}

	public DependendClassCallDuringUnitTestException(String message) {
		super(message);
	}
}
