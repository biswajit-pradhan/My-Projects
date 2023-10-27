package com.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.userservice.entity.BookingManagement;


public interface BookingManagementRepository extends JpaRepository<BookingManagement,Long> {
	//find all event_id where user id is this query 
	
	@Query("SELECT e.eventId FROM BookingManagement e WHERE e.userId = :userId AND e.cancelStatus = false")
	List<Long> getEventidByUserId (@Param("userId")Long userId);

	@Query("SELECT e FROM BookingManagement e WHERE e.userId = :userId")
	List<BookingManagement> getAllBookingManagementDataByUserId(Long userId);

	@Query("SELECT e.bookingDataId FROM BookingManagement e WHERE e.userId = :userId AND e.eventId = :eventId")
	Long getBookingDataIdsBuUserIdAndEventId(Long userId, Long eventId);
}
