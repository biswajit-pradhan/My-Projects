package com.automaticpasswordgenerator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordEntry {
	private String otp;
	private long timestamp;

	public PasswordEntry(String otp) {
		this.otp = otp;
		this.timestamp = System.currentTimeMillis();
	}
}