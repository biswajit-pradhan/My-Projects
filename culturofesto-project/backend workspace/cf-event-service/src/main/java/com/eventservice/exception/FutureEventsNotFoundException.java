package com.eventservice.exception;

public class FutureEventsNotFoundException extends RuntimeException {
    public FutureEventsNotFoundException(String message) {
        super(message);
    }
}