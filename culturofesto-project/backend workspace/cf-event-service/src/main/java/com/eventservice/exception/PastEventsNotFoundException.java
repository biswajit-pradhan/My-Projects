package com.eventservice.exception;

public class PastEventsNotFoundException extends RuntimeException {
    public PastEventsNotFoundException(String message) {
        super(message);
    }
}
