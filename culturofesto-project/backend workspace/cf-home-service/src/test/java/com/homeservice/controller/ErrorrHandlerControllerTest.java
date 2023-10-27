package com.homeservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ErrorrHandlerController.class})
@ExtendWith(SpringExtension.class)
class ErrorrHandlerControllerTest {
    @Autowired
    private ErrorrHandlerController errorrHandlerController;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link ErrorrHandlerController}
     *   <li>{@link ErrorrHandlerController#getErrorPath()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("/error", (new ErrorrHandlerController()).getErrorPath());
    }

    /**
     * Method under test: {@link ErrorrHandlerController#customError()}
     */
    @Test
    void testCustomError() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/error");
        MockMvcBuilders.standaloneSetup(errorrHandlerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("The link you followed may be broken, or the page may have been removed."));
    }

    /**
     * Method under test: {@link ErrorrHandlerController#customError()}
     */
    @Test
    void testCustomError2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/error", "Uri Variables");
        MockMvcBuilders.standaloneSetup(errorrHandlerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("The link you followed may be broken, or the page may have been removed."));
    }
}

