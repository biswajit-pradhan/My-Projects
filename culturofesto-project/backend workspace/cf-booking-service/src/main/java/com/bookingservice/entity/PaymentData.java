package com.bookingservice.entity;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.bookingservice.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Long bookingId;
	
	@NotNull
	private PaymentMethod paymentMethod;
	
	@NotNull
	@Column(columnDefinition = "BIGINT")
	private BigInteger cardNumber;
	
	@NotNull
	private Date expiryDate;
	
	@NotNull
	private Integer cvvNumber;
	
	@NotNull
	private Double totalPrice;
}
