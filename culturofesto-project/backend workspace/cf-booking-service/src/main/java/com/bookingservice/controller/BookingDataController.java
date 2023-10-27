package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.entity.BookingData;
import com.bookingservice.serviceImpl.BookingDataServiceImpl;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = {"*"})
public class BookingDataController {

	@Autowired
	private BookingDataServiceImpl bookingDataServiceImpl;
	
	@GetMapping("/getbooking/{eventId}/{userId}")
	public ResponseEntity<?> getBookingDataByEventAndUserId(@PathVariable Long eventId,@PathVariable Long userId){
		Object data=bookingDataServiceImpl.getBookingDataByEventAndUserId(eventId,userId);
		if(data instanceof BookingData) {
			return ResponseEntity.status(HttpStatus.OK).body((BookingData)data);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Booking data not found with userId "+userId+" and eventId "+eventId);
		}
		
	}
	
	@PostMapping("/addbooking/{eventId}/{userId}")
	public ResponseEntity<?> addBookingDataByEventAndUserId(@RequestBody BookingData bookingData,@PathVariable Long eventId,@PathVariable Long userId){
		
		return ResponseEntity.status(HttpStatus.OK).body(bookingDataServiceImpl.addBookingDataByEventAndUserId(bookingData,eventId,userId));
	}
}
