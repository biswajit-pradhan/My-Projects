package com.homeservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class EventNotFoundExceptionTest {
    /**
     * Method under test: {@link EventNotFoundException#EventNotFoundException(String)}
     */
    @Test
    void testConstructor() {
        EventNotFoundException actualEventNotFoundException = new EventNotFoundException("An error occurred");
        assertNull(actualEventNotFoundException.getCause());
        assertEquals(0, actualEventNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualEventNotFoundException.getMessage());
        assertEquals("An error occurred", actualEventNotFoundException.getLocalizedMessage());
    }
}

