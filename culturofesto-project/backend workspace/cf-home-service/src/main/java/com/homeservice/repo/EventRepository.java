package com.homeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeservice.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}