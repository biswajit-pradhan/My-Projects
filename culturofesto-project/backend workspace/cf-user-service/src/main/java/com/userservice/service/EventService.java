package com.userservice.service;

import java.util.List;

import com.userservice.entity.Event;


public interface EventService {
	public List<Event> getEventsByIds(List<Long> eventIds);

	public List<Event> getRegisteredPastEvent(List<Event> allRegstdEventDetails);

	public List<Event> getRegisteredUpCommingEvent(List<Event> allRegstdEventDetails);

	
}
