package com.homeservice.exception;


public class NoEventsFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoEventsFoundException(String message) {
		super(message);
	}
}