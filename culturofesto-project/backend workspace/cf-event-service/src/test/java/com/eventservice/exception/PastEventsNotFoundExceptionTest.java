package com.eventservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class PastEventsNotFoundExceptionTest {
   
    @Test
    void testConstructor() {
        PastEventsNotFoundException actualPastEventsNotFoundException = new PastEventsNotFoundException(
                "An error occurred");
        assertNull(actualPastEventsNotFoundException.getCause());
        assertEquals(0, actualPastEventsNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualPastEventsNotFoundException.getMessage());
        assertEquals("An error occurred", actualPastEventsNotFoundException.getLocalizedMessage());
    }
}

