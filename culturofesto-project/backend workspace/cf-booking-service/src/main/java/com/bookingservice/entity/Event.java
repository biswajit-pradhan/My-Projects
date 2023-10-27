package com.bookingservice.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "Event name is required")
	private String eventName;
	
	@NotNull(message = "Event date is required")
	@Future(message = "Event date must be in the future")
	private Date eventDate;

	@NotNull(message = "Registration open date is required")
	@Future(message = "Registration open date must be in the future")
	private Date registrationOpenDate;

	@NotNull(message = "Registration close date is required")
	@Future(message = "Registration close date must be in the future")
	private Date registrationCloseDate;

	@NotNull(message = "Event start time is required")
	private Time eventStartTime;

	@NotNull(message = "Event close time is required")
	private Time eventCloseTime;

	@NotNull(message = "Registration fee is required")
	@PositiveOrZero(message = "Registration fee must be a positive or zero value")
	private Double registrationFee;

	@NotNull(message = "Event capacity is required")
	@Positive(message = "Event capacity must be a positive value")
	private Long eventCapacity;

	@NotNull(message = "Breakfast price is required")
	@PositiveOrZero(message = "Breakfast price must be a positive or zero value")
	private Double breakfastPrice;

	@NotNull(message = "Lunch price is required")
	@PositiveOrZero(message = "Lunch price must be a positive or zero value")
	private Double lunchPrice;

	@NotNull(message = "Dinner price is required")
	@PositiveOrZero(message = "Dinner price must be a positive or zero value")
	private Double dinnerPrice;

	private Boolean deleteStatus;

	@Lob
	@Column(length = 1000)
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] eventImage;

}
