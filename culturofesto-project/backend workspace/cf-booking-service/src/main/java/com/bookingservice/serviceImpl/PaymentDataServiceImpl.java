package com.bookingservice.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.entity.BookingData;
import com.bookingservice.entity.BookingManagement;
import com.bookingservice.entity.PaymentData;
import com.bookingservice.repository.BookingDataRepository;
import com.bookingservice.repository.BookingManagementRepository;
import com.bookingservice.repository.PaymentDataRepository;
import com.bookingservice.service.PaymentDataService;

@Service
public class PaymentDataServiceImpl implements PaymentDataService {

	private static final Logger logger = LoggerFactory.getLogger(PaymentDataServiceImpl.class);

	@Autowired
	private PaymentDataRepository paymentDataRepository;

	@Autowired
	private BookingDataRepository bookingDataRepository;

	@Autowired
	private BookingManagementRepository bookingManagementRepository;

	public Object getPaymentDataByBookingId(Long bookingId) {
		logger.info("Fetching payment data for bookingId: {}", bookingId);

//        BookingManagement bookingManagement=new BookingManagement();
//        bookingManagement.setBookingDataId(bookingId);
//        bookingManagement.setEventId(bookingId);
		return paymentDataRepository.findAll().stream().filter(p -> p.getBookingId().equals(bookingId)).findAny()
				.orElse(null);
	}

	public String addPaymentDataByBookingId(PaymentData paymentData, Long bookingId) {
		Object status = getPaymentDataByBookingId(bookingId);

		Double totalPrice = bookingDataRepository.findById(bookingId).get().getTotalPrice();
		paymentData.setTotalPrice(totalPrice);

		if (!(status instanceof PaymentData)) {
			try {
				paymentData.setBookingId(bookingId);
				paymentDataRepository.save(paymentData);
				saveBookingManagement(paymentData, bookingId);
				logger.info("Payment data added successfully for bookingId: {}", bookingId);
				return "Payment data added successfully";
			} catch (Exception e) {
				logger.error("Failed to add payment data for bookingId: {}", bookingId, e);
				return e.getMessage();
			}
		} else {
			logger.warn("Booking amount is already paid for bookingId: {}", bookingId);
			return "Booking amount is already paid";
		}
	}

	public void saveBookingManagement(PaymentData paymentData, Long bookingId) {
		BookingManagement bookingManagement = new BookingManagement();
		BookingData bookingData = bookingDataRepository.findById(bookingId).get();

		bookingManagement.setBookingDataId(bookingId);
		bookingManagement.setCancelStatus(false);
		bookingManagement.setTicketNo(bookingId);
		bookingManagement.setEventId(bookingData.getEventId());
		bookingManagement.setPaymentDataId(paymentData.getId());
		bookingManagement.setUserId(bookingData.getUserId());
		bookingManagementRepository.save(bookingManagement);

	}
}
