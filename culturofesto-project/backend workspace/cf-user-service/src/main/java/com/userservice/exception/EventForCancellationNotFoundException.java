package com.userservice.exception;

public class EventForCancellationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EventForCancellationNotFoundException(String message) {
		super(message);
	}
	
}
