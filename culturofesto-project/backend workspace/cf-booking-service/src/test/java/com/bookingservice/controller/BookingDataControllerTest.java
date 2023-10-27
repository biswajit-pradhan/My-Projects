package com.bookingservice.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.bookingservice.entity.BookingData;
import com.bookingservice.serviceImpl.BookingDataServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BookingDataController.class})
@ExtendWith(SpringExtension.class)
class BookingDataControllerTest {
    @Autowired
    private BookingDataController bookingDataController;

    @MockBean
    private BookingDataServiceImpl bookingDataServiceImpl;

    @Test
    void testGetBookingDataByEventAndUserId() throws Exception {
        when(bookingDataServiceImpl.getBookingDataByEventAndUserId(Mockito.<Long>any(), Mockito.<Long>any()))
                .thenReturn("Booking Data By Event And User Id");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/booking/getbooking/{eventId}/{userId}", 1L, 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookingDataController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Booking data not found with userId 1 and eventId 1"));
    }


    @Test
    void testGetBookingDataByEventAndUserId2() throws Exception {
        Date bookingDate = mock(Date.class);
        when(bookingDate.getTime()).thenReturn(10L);

        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(bookingDate);
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(2L);
        bookingData.setNumberOfBreakfast(2L);
        bookingData.setNumberOfChildren(2L);
        bookingData.setNumberOfDinner(2L);
        bookingData.setNumberOfLunch(2L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);
        when(bookingDataServiceImpl.getBookingDataByEventAndUserId(Mockito.<Long>any(), Mockito.<Long>any()))
                .thenReturn(bookingData);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/booking/getbooking/{eventId}/{userId}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(bookingDataController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"userId\":1,\"eventId\":1,\"bookingDate\":10,\"numberOfAdults\":2,\"numberOfChildren\":2,\"numberOfBreakfast"
                                        + "\":2,\"numberOfLunch\":2,\"numberOfDinner\":2,\"totalPrice\":10.0}"));
    }


    @Test
    void testAddBookingDataByEventAndUserId() throws Exception {
        when(bookingDataServiceImpl.addBookingDataByEventAndUserId(Mockito.<BookingData>any(), Mockito.<Long>any(),
                Mockito.<Long>any())).thenReturn("42");
        Date bookingDate = mock(Date.class);
        when(bookingDate.getTime()).thenReturn(10L);

        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(bookingDate);
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);
        String content = (new ObjectMapper()).writeValueAsString(bookingData);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/booking/addbooking/{eventId}/{userId}", 1L, 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookingDataController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }
}

