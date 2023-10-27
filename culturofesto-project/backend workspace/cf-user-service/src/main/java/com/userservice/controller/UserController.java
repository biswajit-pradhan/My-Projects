package com.userservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.entity.BookingData;
import com.userservice.entity.Event;
import com.userservice.exception.EventForCancellationNotFoundException;
import com.userservice.exception.PastRegisteredEventsNotFoundException;
import com.userservice.exception.UpCommingEventsNotFoundException;
import com.userservice.exception.UserIdNotFoundException;
import com.userservice.service.BookingDataService;
import com.userservice.service.BookingManagementService;
import com.userservice.service.EventService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = { "*" })
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private BookingManagementService bookingManagementService;

	@Autowired
	private EventService eventService;

	@Autowired
	private BookingDataService bookingDataService;

	@GetMapping("/uc-events/regstd/{userid}")
	public ResponseEntity<?> getUserRegisteredUpCommingEvent(@PathVariable("userid") Long userId) {
		LOGGER.info("Fetching upcoming events for user with ID: {}", userId);

		List<Long> allRegstdEventIds;
		try {
			allRegstdEventIds = bookingManagementService.getAllRegestdEventsBuUserId(userId);
		} catch (UserIdNotFoundException e) {
			LOGGER.error("User ID not found: {}", userId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

		List<Event> allRegstdEventDetails = eventService.getEventsByIds(allRegstdEventIds);

		try {
			List<Event> registeredUpCommingEvent = eventService.getRegisteredUpCommingEvent(allRegstdEventDetails);

			if (registeredUpCommingEvent.isEmpty()) {
				LOGGER.info("No upcoming events found for user with ID: {}", userId);
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("No Upcoming Events found for User no. " + userId);
			}

			LOGGER.info("Fetched {} upcoming events for user with ID: {}", registeredUpCommingEvent.size(), userId);
			return ResponseEntity.status(HttpStatus.OK).body(registeredUpCommingEvent);
		} catch (UpCommingEventsNotFoundException e) {
			LOGGER.error("Upcoming events not found for user with ID: {}", userId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@GetMapping("/pst-events/regstd/{userid}")
	public ResponseEntity<?> getUserRegisteredPastEvent(@PathVariable("userid") Long userId) {
		LOGGER.info("Fetching past events for user with ID: {}", userId);

		List<Long> allRegstdEventIds = bookingManagementService.getAllRegestdEventsBuUserId(userId);

		List<Event> allRegstdEventDetails = eventService.getEventsByIds(allRegstdEventIds);

		try {
			List<Event> registeredPastEvents = eventService.getRegisteredPastEvent(allRegstdEventDetails);
			if (registeredPastEvents.isEmpty()) {
				LOGGER.info("No registered past events found for user with ID: {}", userId);
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("No Registered Past Events found for User no. " + userId);
			}

			LOGGER.info("Fetched {} registered past events for user with ID: {}", registeredPastEvents.size(), userId);
			return ResponseEntity.status(HttpStatus.OK).body(registeredPastEvents);
		} catch (PastRegisteredEventsNotFoundException e) {
			LOGGER.error("Registered past events not found for user with ID: {}", userId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PutMapping("regstd/cancel/{userid}/{eventId}")
	public ResponseEntity<?> cancelEventById(@PathVariable("userid") Long userId,
			@PathVariable("eventId") Long eventId) {
		LOGGER.info("Canceling event with ID {} for user with ID: {}", eventId, userId);

		try {
			String rtnmsg = bookingManagementService.cancelEventById(userId, eventId);
			return ResponseEntity.status(HttpStatus.OK).body(rtnmsg);
		} catch (EventForCancellationNotFoundException e) {
			LOGGER.error("Event with ID {} cannot be canceled for user with ID: {}", eventId, userId);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Event No. " + eventId + " cannot be canceled for user No. " + userId);
		}
	}

	@GetMapping("regstd/event/booking-details/{userid}/{eventid}")
	public ResponseEntity<?> getBookingDataByUserIdandEventId(@PathVariable("userid") Long userId,
			@PathVariable("eventid") Long eventId) {
		LOGGER.info("Fetching booking data for event with ID {} and user with ID: {}", eventId, userId);

		try {
			BookingData bookingDataDetails = bookingDataService.getBookingDataByUserIdandEventId(userId, eventId);
			return ResponseEntity.status(HttpStatus.OK).body(bookingDataDetails);
		} catch (Exception e) {
			LOGGER.error("Booking data not found for event with ID {} and user with ID: {}", eventId, userId);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("No booking data found for the Event No. " + eventId);
		}
	}
}
