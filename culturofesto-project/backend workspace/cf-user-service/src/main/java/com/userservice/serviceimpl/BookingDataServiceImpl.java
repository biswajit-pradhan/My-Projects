package com.userservice.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.entity.BookingData;
import com.userservice.repository.BookingDataRepository;
import com.userservice.repository.BookingManagementRepository;
import com.userservice.service.BookingDataService;

@Service
public class BookingDataServiceImpl implements BookingDataService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingDataServiceImpl.class);

	@Autowired
	private BookingManagementRepository bookingManagementRepository;

	@Autowired
	private BookingDataRepository bookingDataRepository;

	@Override
	public BookingData getBookingDataByUserIdandEventId(Long userId, Long eventId) {
		LOGGER.info("Fetching booking data for user with ID: {} and event with ID: {}", userId, eventId);

		Long bookingDataIdsBuUserIdAndEventId = bookingManagementRepository.getBookingDataIdsBuUserIdAndEventId(userId, eventId);
		BookingData bookingDataByUserIdAndEventId = bookingDataRepository.findById(bookingDataIdsBuUserIdAndEventId).get();

		LOGGER.info("Fetched booking data for user with ID: {} and event with ID: {}", userId, eventId);
		return bookingDataByUserIdAndEventId;
	}
}
