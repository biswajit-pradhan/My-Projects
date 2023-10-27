package com.bookingservice.service;

import com.bookingservice.entity.PaymentData;

public interface PaymentDataService {
	public Object getPaymentDataByBookingId(Long bookingId);
	public String addPaymentDataByBookingId(PaymentData paymentData, Long bookingId);
	public void saveBookingManagement(PaymentData paymentData,Long bookingId);

}
