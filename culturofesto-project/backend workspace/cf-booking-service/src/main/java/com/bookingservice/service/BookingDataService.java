package com.bookingservice.service;

import com.bookingservice.entity.BookingData;

public interface BookingDataService {

	public Object getBookingDataByEventAndUserId(Long eventId, Long userId);
	public String addBookingDataByEventAndUserId(BookingData bookingData,Long eventId, Long userId);
}
