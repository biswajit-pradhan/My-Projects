package com.userservice.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.entity.Event;
import com.userservice.repository.BookingManagementRepository;
import com.userservice.repository.EventRepository;
import com.userservice.service.BookingManagementService;
import com.userservice.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private BookingManagementRepository bookingManagementRepository;

	@Autowired
	private BookingManagementService bookingManagementService;

	@Override
	public List<Event> getEventsByIds(List<Long> eventIds) {
		LOGGER.info("Fetching events by IDs: {}", eventIds);

		List<Event> events = eventRepository.findAllById(eventIds);

		LOGGER.info("Fetched {} events by IDs: {}", events.size(), eventIds);
		return events;
	}

	@Override
	public List<Event> getRegisteredPastEvent(List<Event> allRegstdEventDetails) {
		LOGGER.info("Filtering registered past events");

		List<Event> registeredPastEventData = allRegstdEventDetails.stream()
				.filter(event -> event.getEventDate().toLocalDate().isBefore(LocalDate.now()))
				.collect(Collectors.toList());

		LOGGER.info("Filtered {} registered past events", registeredPastEventData.size());
		return registeredPastEventData;
	}

	@Override
	public List<Event> getRegisteredUpCommingEvent(List<Event> allRegstdEventDetails) {
		LOGGER.info("Filtering registered upcoming events");

		List<Event> registeredUpcomingEventData = allRegstdEventDetails.stream()
				.filter(event -> event.getEventDate().toLocalDate().isAfter(LocalDate.now()))
				.collect(Collectors.toList());

		LOGGER.info("Filtered {} registered upcoming events", registeredUpcomingEventData.size());
		return registeredUpcomingEventData;
	}

}
