package com.eventservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventservice.entity.Event;
import com.eventservice.exception.EventNotFoundException;
import com.eventservice.exception.FutureEventsNotFoundException;
import com.eventservice.exception.PastEventsNotFoundException;
import com.eventservice.serviceImplementation.EventServiceImplementation;

@RestController
@RequestMapping("/api/event")
@CrossOrigin("*")
public class EventServiceController {

	private static final Logger logger = LoggerFactory.getLogger(EventServiceController.class);

	@Autowired
	private EventServiceImplementation eventService;

	@GetMapping("{eventId}/{needImage}")
	public ResponseEntity<?> getEventByEventId(@PathVariable Long eventId, @PathVariable Long needImage) {
		try {
			logger.info("Fetching event with ID: {}", eventId);

			Object event = eventService.getEventByEventId(eventId);
			if (event instanceof Event) {
				if (needImage.equals(0L)) {
					logger.info("Returning event without image for ID: {}", eventId);
					return ResponseEntity.status(HttpStatus.OK).body(event);
				} else {
					logger.info("Returning event image for ID: {}", eventId);
					return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG)
							.body(((Event) event).getEventImage());
				}
			}

			logger.warn("Event not found for ID: {}", eventId);
			throw new EventNotFoundException("Could not find any event");
		} catch (EventNotFoundException e) {
			logger.error("Event not found for ID: {}", eventId, e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			logger.error("Failed to retrieve event for ID: {}", eventId, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
	}

	@GetMapping("/past")
	public ResponseEntity<?> getPastEvents() {
		try {
			logger.info("Fetching past events");

			List<Event> pastEvents = eventService.getPastEvents();
			if (pastEvents.isEmpty()) {
				logger.warn("No past events found");
				throw new PastEventsNotFoundException("No past events found");
			}

			if (logger.isInfoEnabled()) {
	            logger.info("Returning {} past events", pastEvents.size());
	        }
			return ResponseEntity.ok(pastEvents);
		} catch (PastEventsNotFoundException e) {
			logger.error("Past events not found", e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			logger.error("Failed to retrieve past events", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve past events");
		}
	}

	@GetMapping("/future")
	public ResponseEntity<?> getFutureEvents() {
		try {
			logger.info("Fetching future events");

			List<Event> futureEvents = eventService.getFutureEvents();
			if (futureEvents.isEmpty()) {
				logger.warn("No future events found");
				throw new FutureEventsNotFoundException("No future events found");
			}

			if (logger.isInfoEnabled()) {
	            logger.info("Returning {} future events", futureEvents.size());
	        }
			return ResponseEntity.ok(futureEvents);
		} catch (FutureEventsNotFoundException e) {
			logger.error("Future events not found", e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			logger.error("Failed to retrieve future events", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve future events");
		}
	}

}
