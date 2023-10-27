package com.eventservice.serviceImplementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventservice.entity.Event;
import com.eventservice.repository.EventServiceRepository;
import com.eventservice.service.EventService;
import com.eventservice.utils.ImageUtils;

@Service
public class EventServiceImplementation implements EventService {

	@Autowired
    private EventServiceRepository eventRepository;

    
    public List<Event> getPastEvents() {
        Date currentDate = new Date(System.currentTimeMillis());
        return eventRepository.findByEventDateBefore(currentDate);
    }

    public List<Event> getFutureEvents() {
        Date currentDate = new Date(System.currentTimeMillis());
        return eventRepository.findByEventDateAfter(currentDate);
    }

    @Override
	public Object getEventByEventId(Long eventId) {
		Optional<Event> event = eventRepository.findById(eventId);
		if (event.isPresent()) {
			byte[] image = ImageUtils.decompressImage(event.get().getEventImage());
			event.get().setEventImage(image);
			return event.get();
		} else {
			return null;
		}
	}
}
