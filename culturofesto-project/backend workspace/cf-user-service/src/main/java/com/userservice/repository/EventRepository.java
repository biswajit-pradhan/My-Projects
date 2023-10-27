package com.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> getAllEventsByIdIn(List<Long> eventIds);
	
	

}
