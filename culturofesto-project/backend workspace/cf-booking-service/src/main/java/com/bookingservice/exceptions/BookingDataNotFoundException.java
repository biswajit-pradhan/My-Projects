package com.bookingservice.exceptions;

public class BookingDataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookingDataNotFoundException(String message) {
		super(message);
	}
}
