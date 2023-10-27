package com.homeservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

class GlobalExceptionHandlerTest {
    /**
     * Method under test: {@link GlobalExceptionHandler#handleMethodArgumentNotValidException(MethodArgumentNotValidException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleMethodArgumentNotValidException() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Constructor must not be null
        //   See https://diff.blue/R013 to resolve this issue.

        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        MethodParameter parameter = new MethodParameter((Constructor<?>) null, 1);

        globalExceptionHandler.handleMethodArgumentNotValidException(
                new MethodArgumentNotValidException(parameter, new BindException("Target", "Object Name")));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleMethodArgumentNotValidException(MethodArgumentNotValidException)}
     */
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

    /**
     * Method under test: {@link GlobalExceptionHandler#handleMethodArgumentNotValidException(MethodArgumentNotValidException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleMethodArgumentNotValidException3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.bind.MethodArgumentNotValidException.getBindingResult()" because "ex" is null
        //       at com.homeservice.exception.GlobalExceptionHandler.handleMethodArgumentNotValidException(GlobalExceptionHandler.java:20)
        //   See https://diff.blue/R013 to resolve this issue.

        (new GlobalExceptionHandler()).handleMethodArgumentNotValidException(null);
    }
}

