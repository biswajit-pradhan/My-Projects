package com.bookingservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingManagement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@NotNull
	private boolean cancelStatus;
	
	@NotNull
	private Long ticketNo;
	
	@NotNull
	private Long userId;
	
	@NotNull
	private Long eventId;
	
	@NotNull
	private Long bookingDataId;
	
	@NotNull
	private Long paymentDataId;
}
