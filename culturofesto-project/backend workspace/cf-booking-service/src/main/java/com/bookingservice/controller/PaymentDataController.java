package com.bookingservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.bookingservice.entity.PaymentData;
import com.bookingservice.serviceImpl.PaymentDataServiceImpl;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = { "*" })
public class PaymentDataController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentDataController.class);

	@Autowired
	private PaymentDataServiceImpl paymentDataServiceImpl;

	@GetMapping("/getpaymentdatabybookingid/{bookingId}")
	public ResponseEntity<?> getPaymentDataByBookingId(@PathVariable Long bookingId) {
		logger.info("Received request to get payment data for bookingId: {}", bookingId);
		Object paymentData = paymentDataServiceImpl.getPaymentDataByBookingId(bookingId);
		if (!(paymentData instanceof PaymentData)) {
			logger.warn("Payment data not found with booking id: {}", bookingId);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Payment data not found with booking id " + bookingId);
		} else {
			logger.info("Payment data found with booking id: {}", bookingId);
			return ResponseEntity.status(HttpStatus.OK).body(paymentData);
		}
	}

	@PostMapping("/addpaymentdatabybookingid/{bookingId}")
	public ResponseEntity<?> addPaymentDataByBookingId(@RequestBody PaymentData paymentData,
			@PathVariable Long bookingId) {
		logger.info("Received request to add payment data for bookingId: {}", bookingId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(paymentDataServiceImpl.addPaymentDataByBookingId(paymentData, bookingId));
	}
}
