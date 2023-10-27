package com.adminservice.exceptions;

public class EventUpdateException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EventUpdateException(String message) {
		super(message);
	}
}
