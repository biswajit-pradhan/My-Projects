package com.eventservice.service;

import java.util.List;

import com.eventservice.entity.Event;

public interface EventService {
	public Object getEventByEventId(Long eventId);
	public List<Event> getPastEvents();
	public List<Event> getFutureEvents();
	
}
