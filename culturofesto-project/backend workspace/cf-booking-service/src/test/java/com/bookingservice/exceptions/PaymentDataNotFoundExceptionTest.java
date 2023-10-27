package com.bookingservice.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class PaymentDataNotFoundExceptionTest {

    @Test
    void testConstructor() {
        PaymentDataNotFoundException actualPaymentDataNotFoundException = new PaymentDataNotFoundException(
                "An error occurred");
        assertNull(actualPaymentDataNotFoundException.getCause());
        assertEquals(0, actualPaymentDataNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualPaymentDataNotFoundException.getMessage());
        assertEquals("An error occurred", actualPaymentDataNotFoundException.getLocalizedMessage());
    }
}

