package com.bookingservice.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.bookingservice.entity.PaymentData;
import com.bookingservice.enums.PaymentMethod;
import com.bookingservice.serviceImpl.PaymentDataServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigInteger;
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

@ContextConfiguration(classes = {PaymentDataController.class})
@ExtendWith(SpringExtension.class)
class PaymentDataControllerTest {
    @Autowired
    private PaymentDataController paymentDataController;

    @MockBean
    private PaymentDataServiceImpl paymentDataServiceImpl;


    @Test
    void testGetPaymentDataByBookingId() throws Exception {
        when(paymentDataServiceImpl.getPaymentDataByBookingId(Mockito.<Long>any()))
                .thenReturn("Payment Data By Booking Id");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/booking/getpaymentdatabybookingid/{bookingId}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(paymentDataController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Payment data not found with booking id 1"));
    }


    @Test
    void testGetPaymentDataByBookingId2() throws Exception {
        Date expiryDate = mock(Date.class);
        when(expiryDate.getTime()).thenReturn(10L);

        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(expiryDate);
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);
        when(paymentDataServiceImpl.getPaymentDataByBookingId(Mockito.<Long>any())).thenReturn(paymentData);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/booking/getpaymentdatabybookingid/{bookingId}", 1L);
        MockMvcBuilders.standaloneSetup(paymentDataController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"bookingId\":1,\"paymentMethod\":\"CREDIT\",\"cardNumber\":1,\"expiryDate\":10,\"cvvNumber\":10,\"totalPrice"
                                        + "\":10.0}"));
    }


    @Test
    void testAddPaymentDataByBookingId() throws Exception {
        when(paymentDataServiceImpl.addPaymentDataByBookingId(Mockito.<PaymentData>any(), Mockito.<Long>any()))
                .thenReturn("42");
        Date expiryDate = mock(Date.class);
        when(expiryDate.getTime()).thenReturn(10L);

        PaymentData paymentData = new PaymentData();
        paymentData.setBookingId(1L);
        paymentData.setCardNumber(BigInteger.valueOf(1L));
        paymentData.setCvvNumber(10);
        paymentData.setExpiryDate(expiryDate);
        paymentData.setId(1L);
        paymentData.setPaymentMethod(PaymentMethod.CREDIT);
        paymentData.setTotalPrice(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(paymentData);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/booking/addpaymentdatabybookingid/{bookingId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(paymentDataController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }
}

