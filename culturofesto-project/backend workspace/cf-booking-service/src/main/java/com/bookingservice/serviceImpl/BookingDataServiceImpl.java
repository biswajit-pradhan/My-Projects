package com.bookingservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.entity.BookingData;
import com.bookingservice.repository.BookingDataRepository;
import com.bookingservice.service.BookingDataService;

@Service
public class BookingDataServiceImpl implements BookingDataService {

	@Autowired
	private BookingDataRepository bookingDataRepository;

	public Object getBookingDataByEventAndUserId(Long eventId, Long userId) {

		Object data=bookingDataRepository.findAll().stream()
				.filter(b -> (b.getEventId().equals(eventId) && b.getUserId().equals(userId))).findAny().orElse(null);
	
		return data;
	
	}

	public String addBookingDataByEventAndUserId(BookingData bookingData, Long eventId, Long userId) {

		Object status = getBookingDataByEventAndUserId(eventId, userId);
		if (!(status instanceof BookingData)) {
			try {
				bookingData.setEventId(eventId);
				bookingData.setUserId(userId);
				bookingDataRepository.save(bookingData);
				return "Taking you to payment page...";
			} catch (Exception e) {
				return e.getMessage();
			}
		}else {
			return "You already registered for this event";
		}

	}

}
