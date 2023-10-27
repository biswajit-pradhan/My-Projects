package com.userservice.service;

import com.userservice.entity.BookingData;

public interface BookingDataService {

	BookingData getBookingDataByUserIdandEventId(Long userId, Long eventId);

}
