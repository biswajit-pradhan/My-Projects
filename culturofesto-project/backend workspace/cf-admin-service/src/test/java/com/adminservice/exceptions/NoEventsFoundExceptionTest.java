package com.adminservice.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class NoEventsFoundExceptionTest {

    @Test
    void testConstructor() {
        NoEventsFoundException actualNoEventsFoundException = new NoEventsFoundException("An error occurred");
        assertNull(actualNoEventsFoundException.getCause());
        assertEquals(0, actualNoEventsFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualNoEventsFoundException.getMessage());
        assertEquals("An error occurred", actualNoEventsFoundException.getLocalizedMessage());
    }
}

