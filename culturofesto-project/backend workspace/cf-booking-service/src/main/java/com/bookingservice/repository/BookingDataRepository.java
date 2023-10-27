package com.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingservice.entity.BookingData;

public interface BookingDataRepository extends JpaRepository<BookingData, Long> {

}
