package com.homeservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class NoEventsFoundExceptionTest {
    /**
     * Method under test: {@link NoEventsFoundException#NoEventsFoundException(String)}
     */
    @Test
    void testConstructor() {
        NoEventsFoundException actualNoEventsFoundException = new NoEventsFoundException("An error occurred");
        assertNull(actualNoEventsFoundException.getCause());
        assertEquals(0, actualNoEventsFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualNoEventsFoundException.getMessage());
        assertEquals("An error occurred", actualNoEventsFoundException.getLocalizedMessage());
    }
}

