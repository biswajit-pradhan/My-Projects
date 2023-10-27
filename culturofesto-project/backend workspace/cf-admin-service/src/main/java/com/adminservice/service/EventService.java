package com.adminservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.adminservice.entity.Event;

public interface EventService {

	public List<Event> getAllEvents();

	public String addEvent(Event event, MultipartFile eventImage);

	public Object getEventByEventId(Long eventId);

	public Object updateEvent(Long eventIdToUpdate, Event event);
	
	public Object deleteEventById(Long eventIdToDelete);
}
