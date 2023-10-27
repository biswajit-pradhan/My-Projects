package com.homeservice.service;

import java.util.List;

import com.homeservice.entity.Event;

public interface EventService {

	public  List<Event> getAllEvents();


	public Object getEventByEventId(Long eventId);


	
}