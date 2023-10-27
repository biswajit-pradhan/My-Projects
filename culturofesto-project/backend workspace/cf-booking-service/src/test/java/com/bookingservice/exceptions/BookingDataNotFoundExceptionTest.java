package com.bookingservice.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class BookingDataNotFoundExceptionTest {

    @Test
    void testConstructor() {
        BookingDataNotFoundException actualBookingDataNotFoundException = new BookingDataNotFoundException(
                "An error occurred");
        assertNull(actualBookingDataNotFoundException.getCause());
        assertEquals(0, actualBookingDataNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualBookingDataNotFoundException.getMessage());
        assertEquals("An error occurred", actualBookingDataNotFoundException.getLocalizedMessage());
    }
}

