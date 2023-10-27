package com.userservice.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.entity.BookingManagement;
import com.userservice.repository.BookingManagementRepository;
import com.userservice.service.BookingManagementService;

@Service
public class BookingManagementServiceImpl implements BookingManagementService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingManagementServiceImpl.class);

	@Autowired
	private BookingManagementRepository bookingManagementRepository;

	@Override
	public List<Long> getAllRegestdEventsBuUserId(Long userId) {
		LOGGER.info("Fetching registered events for user with ID: {}", userId);
		List<Long> eventIds = bookingManagementRepository.getEventidByUserId(userId);
		LOGGER.info("Fetched {} registered events for user with ID: {}", eventIds.size(), userId);
		return eventIds;
	}

	@Override
	public String cancelEventById(Long userId, Long eventId) {
		LOGGER.info("Canceling event with ID {} for user with ID: {}", eventId, userId);

		List<BookingManagement> bookingManagementDatas = bookingManagementRepository.getAllBookingManagementDataByUserId(userId);

		bookingManagementDatas.stream()
			.filter(bookingManagement -> bookingManagement.getEventId().equals(eventId))
			.forEach(bookingManagement -> bookingManagement.setCancelStatus(true));

		// Save the updated entities back to the database
		bookingManagementRepository.saveAll(bookingManagementDatas);

		LOGGER.info("Event with ID {} canceled for user with ID: {}", eventId, userId);
		return "Registered Event Successfully Canceled";
	}
}
