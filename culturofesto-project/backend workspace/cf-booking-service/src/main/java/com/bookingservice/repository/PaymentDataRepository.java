package com.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingservice.entity.PaymentData;

public interface PaymentDataRepository extends JpaRepository<PaymentData, Long> {

}
