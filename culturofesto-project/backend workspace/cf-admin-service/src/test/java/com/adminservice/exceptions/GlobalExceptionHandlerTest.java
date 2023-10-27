package com.adminservice.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

class GlobalExceptionHandlerTest {

    @Test
    void testHandleMethodArgumentNotValidException2() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        ResponseEntity<?> actualHandleMethodArgumentNotValidExceptionResult = globalExceptionHandler
                .handleMethodArgumentNotValidException(
                        new MethodArgumentNotValidException(null, new BindException("Target", "Object Name")));
        assertTrue(((Map<Object, Object>) actualHandleMethodArgumentNotValidExceptionResult.getBody()).isEmpty());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualHandleMethodArgumentNotValidExceptionResult.getStatusCode());
        assertTrue(actualHandleMethodArgumentNotValidExceptionResult.getHeaders().isEmpty());
    }
}

