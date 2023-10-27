package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entity.BookingData;

public interface BookingDataRepository extends JpaRepository<BookingData, Long> {

}
