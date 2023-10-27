package com.homeservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class EventUpdateExceptionTest {
    /**
     * Method under test: {@link EventUpdateException#EventUpdateException(String)}
     */
    @Test
    void testConstructor() {
        EventUpdateException actualEventUpdateException = new EventUpdateException("An error occurred");
        assertNull(actualEventUpdateException.getCause());
        assertEquals(0, actualEventUpdateException.getSuppressed().length);
        assertEquals("An error occurred", actualEventUpdateException.getMessage());
        assertEquals("An error occurred", actualEventUpdateException.getLocalizedMessage());
    }
}

