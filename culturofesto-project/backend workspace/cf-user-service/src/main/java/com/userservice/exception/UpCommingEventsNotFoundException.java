package com.userservice.exception;

public class UpCommingEventsNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UpCommingEventsNotFoundException(String message) {
		super(message);
	}
}
