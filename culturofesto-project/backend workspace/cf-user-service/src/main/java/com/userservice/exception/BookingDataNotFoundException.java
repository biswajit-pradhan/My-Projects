package com.userservice.exception;

public class BookingDataNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookingDataNotFoundException(String message) {
		super(message);
	}

}
