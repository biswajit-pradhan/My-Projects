package com.userservice.exception;

public class PastRegisteredEventsNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PastRegisteredEventsNotFoundException(String message) {
		super(message);
	}

}
