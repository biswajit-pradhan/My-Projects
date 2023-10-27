package com.bookingservice.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bookingservice.entity.BookingData;
import com.bookingservice.entity.PaymentData;
import com.bookingservice.enums.PaymentMethod;
import com.bookingservice.repository.BookingDataRepository;
import com.bookingservice.repository.PaymentDataRepository;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PaymentDataServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PaymentDataServiceImplTest {
    @MockBean
    private BookingDataRepository bookingDataRepository;

    @MockBean
    private PaymentDataRepository paymentDataRepository;

    @Autowired
    private PaymentDataServiceImpl paymentDataServiceImpl;

  


  


   


  


   

    
}

