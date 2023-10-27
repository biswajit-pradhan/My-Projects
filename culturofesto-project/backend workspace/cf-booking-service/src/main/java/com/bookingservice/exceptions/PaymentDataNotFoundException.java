package com.bookingservice.exceptions;

public class PaymentDataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PaymentDataNotFoundException(String message) {
		super(message);
	}
}
