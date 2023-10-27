package com.userservice.entity;

import java.sql.Date;

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
public class BookingData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Long userId;
	
	@NotNull
	private Long eventId;
	
	@NotNull
	private Date bookingDate;
	
	@NotNull
	private Long numberOfAdults;
	
	@NotNull
	private Long numberOfChildren;
	
	@NotNull
	private Long numberOfBreakfast;
	
	@NotNull
	private Long numberOfLunch;
	
	@NotNull
	private Long numberOfDinner;
	
	@NotNull
	private Double totalPrice;
}
