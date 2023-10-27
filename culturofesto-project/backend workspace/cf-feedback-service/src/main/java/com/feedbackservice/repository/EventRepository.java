package com.feedbackservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedbackservice.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
 