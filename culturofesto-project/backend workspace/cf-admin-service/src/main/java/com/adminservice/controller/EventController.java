package com.adminservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adminservice.entity.Event;
import com.adminservice.exceptions.EventNotFoundException;
import com.adminservice.exceptions.NoEventsFoundException;
import com.adminservice.serviceimpl.EventServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/admin/event")
@CrossOrigin(origins = { "*" })
public class EventController {

	private static final Logger logger = LoggerFactory.getLogger(EventController.class);

	@Autowired  
	private EventServiceImpl eventService;
	
	

	@PutMapping("/deleteevent/{eventIdToDelete}")
	public ResponseEntity<?> deleteEventById(@PathVariable Long eventIdToDelete) {
		logger.debug("Deleting event with eventId: {}", eventIdToDelete);
		eventService.deleteEventById(eventIdToDelete);
		return ResponseEntity.status(HttpStatus.OK).body("Event deleted successfully");
	}

	@GetMapping("/eventlist")
	public ResponseEntity<?> getAllEvents() {
		try {
			logger.trace("Fetching all events");
			List<Event> events = this.eventService.getAllEvents();
			if (events.isEmpty()) {
				throw new NoEventsFoundException("No events are there in the database");
			}
			return ResponseEntity.status(HttpStatus.OK).body(events);
		} catch (NoEventsFoundException e) {
			if (logger.isWarnEnabled()) {
			    logger.warn("NoEventsFoundException occurred: {}", e.getMessage());
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occurred: {}", e.getMessage());
			}			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
	}

	@PostMapping(value = "/newevent", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> addEvent(@RequestPart("event") String eventData,
			@RequestPart("eventImage") MultipartFile eventImage) throws JsonMappingException, JsonProcessingException {
		try {
			logger.debug("Adding a new event");
			Event event = new ObjectMapper().readValue(eventData, Event.class);
			return ResponseEntity.status(HttpStatus.OK).body(eventService.addEvent(event, eventImage));
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occurred while adding event: {}", e.getMessage());
			}			
			return ResponseEntity.status(HttpStatus.OK).body("Errors are there in the form data. Check it properly!!");
		}
	}

	@GetMapping("/placeholder/eventedit/{eventId}/{needImage}")
	public ResponseEntity<?> getEventByEventId(@PathVariable Long eventId, @PathVariable Long needImage) {
		try {
			logger.trace("Fetching event by eventId: {}", eventId);
			Object event = eventService.getEventByEventId(eventId);
			if (event instanceof Event) {
				if (needImage.equals(0L)) {
					return ResponseEntity.status(HttpStatus.OK).body(event);
				} else {
					logger.trace("Fetching event image by eventId: {}", eventId);
					return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG)
							.body(((Event) event).getEventImage());
				}

			}
			throw new EventNotFoundException("Could not find any event");
		} catch (EventNotFoundException e) {
			if (logger.isWarnEnabled()) {
				logger.warn("EventNotFoundException occurred: {}", e.getMessage());
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occurred: {}", e.getMessage());
			}			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
	}

	@PutMapping(value = "/eventedit/{eventIdToUpdate}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> updateEvent(@PathVariable Long eventIdToUpdate,
	        @RequestPart("event") @Valid String eventData) {
	    try {
	        logger.debug("Updating event with eventId: {}", eventIdToUpdate);
	        Event event = new ObjectMapper().readValue(eventData, Event.class);
	        return ResponseEntity.status(HttpStatus.OK)
	                .body(eventService.updateEvent(eventIdToUpdate, event));
	    } catch (Exception e) {
	        if (logger.isErrorEnabled()) {
	            logger.error("Exception occurred while updating event: {}", e.getMessage());
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
	    }
	}
}
