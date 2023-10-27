package com.adminservice.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adminservice.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
