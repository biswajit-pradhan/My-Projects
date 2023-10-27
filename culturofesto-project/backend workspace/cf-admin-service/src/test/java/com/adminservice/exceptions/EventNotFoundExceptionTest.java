package com.adminservice.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class EventNotFoundExceptionTest {

    @Test
    void testConstructor() {
        EventNotFoundException actualEventNotFoundException = new EventNotFoundException("An error occurred");
        assertNull(actualEventNotFoundException.getCause());
        assertEquals(0, actualEventNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualEventNotFoundException.getMessage());
        assertEquals("An error occurred", actualEventNotFoundException.getLocalizedMessage());
    }
}

