package com.homeservice.controller;

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

import com.homeservice.entity.Event;
import com.homeservice.exception.EventNotFoundException;
import com.homeservice.exception.NoEventsFoundException;
import com.homeservice.service.EventServiceImpl;

@RestController
@RequestMapping("api/home/event")
@CrossOrigin(origins = {"*"})
public class EventController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventServiceImpl eventService;

    // API FOR GETTING ALL EVENTS
    @GetMapping("/search")
    public ResponseEntity<?> getAllEvents() {
        try {
            List<Event> events = eventService.getAllEvents();
            if (events.isEmpty()) {
                throw new NoEventsFoundException("No events are found in the database");
            }
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("All events retrieved successfully");
            }
            return ResponseEntity.status(HttpStatus.OK).body(events);
        } catch (NoEventsFoundException e) {
        	if (LOGGER.isErrorEnabled()) {
                LOGGER.error("NoEventsFoundException: {}", e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
        	if (LOGGER.isErrorEnabled()) {
                LOGGER.error("Exception occurred while getting all events", e);
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    // API FOR GETTING PARTICULAR EVENT DETAILS
    @GetMapping("/search/{eventId}/{needImage}")
    public ResponseEntity<?> getEventByEventId(@PathVariable Long eventId, @PathVariable Long needImage) {
        try {
            Object event = eventService.getEventByEventId(eventId);
            if (event instanceof Event) {
                if (needImage.equals(0L)) {
                	if (LOGGER.isInfoEnabled()) {
                        LOGGER.info("Event with ID '{}' retrieved successfully", eventId);
                    }
                    return ResponseEntity.status(HttpStatus.OK).body(event);
                } else {
                	if (LOGGER.isInfoEnabled()) {
                        LOGGER.info("Event image with ID '{}' retrieved successfully", eventId);
                    }
                    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG)
                            .body(((Event) event).getEventImage());
                }

            }
            throw new EventNotFoundException("Event not found with ID: " + eventId);
        } catch (EventNotFoundException e) {
        	if (LOGGER.isErrorEnabled()) {
                LOGGER.error("EventNotFoundException: {}", e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
        	if (LOGGER.isErrorEnabled()) {
                LOGGER.error("Exception occurred while getting event by ID", e);
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}
