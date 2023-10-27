package com.homeservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeservice.entity.Event;
import com.homeservice.exception.EventNotFoundException;
import com.homeservice.repo.EventRepository;
import com.homeservice.utils.ImageUtils;

@Service
public class EventServiceImpl implements EventService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        List<Event> list = eventRepository.findAll();
        List<Event> filteredList = list.stream()
                .filter(e -> e.getDeleteStatus().equals(Boolean.FALSE))
                .collect(Collectors.toList());
        filteredList.forEach(e -> e.setEventImage(ImageUtils.decompressImage(e.getEventImage())));

        LOGGER.info("Retrieved all events successfully");
        return filteredList;
    }

    @Override
    public Object getEventByEventId(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            event.setEventImage(ImageUtils.decompressImage(event.getEventImage()));

            LOGGER.info("Retrieved event with ID '{}' successfully", eventId);
            return event;
        } else {
        	LOGGER.error("Event not found with ID: {}", eventId);
            throw new EventNotFoundException("Event not found with ID: " + eventId);
        }
    }
}
