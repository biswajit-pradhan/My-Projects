package com.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingservice.entity.BookingManagement;

public interface BookingManagementRepository extends JpaRepository<BookingManagement, Long>{

}
