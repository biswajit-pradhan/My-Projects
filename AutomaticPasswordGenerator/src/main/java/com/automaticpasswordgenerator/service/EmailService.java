package com.automaticpasswordgenerator.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.automaticpasswordgenerator.entity.PasswordEntry;

@Service
public class EmailService {

	private List<PasswordEntry> savedPasswords = new ArrayList<>();

	@Autowired
	private JavaMailSender javaMailSender;

	public String validateOtp(String otp) {
		removeExpiredPasswords();
		if (savedPasswords.stream().anyMatch(entry -> entry.getOtp().equals(otp))) {
			return "User is Valid";
		}
		return "User is Not Valid";
	}

	public String sendOtp(String firstName, String to, int times) {
		removeExpiredPasswords();
		try {
			for (int i = 0; i < times; i++) {
				String password = generatePassword();
				String text = "";
				if (!firstName.equals("")) {
					text = "Hello " + firstName + "\nYour freshly generated OTP is: " + password
							+ "\nYour OTP is valid for 2 minute only";
				} else {
					text = "Your freshly generated OTP is: " + password + "\nYour OTP is valid for 1 minute only";
				}
				SimpleMailMessage message = new SimpleMailMessage();
				message.setTo(to);
				message.setSubject("Your SpringBoot OTP");
				message.setText(text);

				// testing
//                savedPasswords.add(new PasswordEntry(password));
//                System.out.println(savedPasswords);

				// sending mail
				javaMailSender.send(message);
				savedPasswords.add(new PasswordEntry(password));
			}
			return "success";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	private void removeExpiredPasswords() {
		long currentTime = System.currentTimeMillis();
		savedPasswords.removeIf(entry -> currentTime - entry.getTimestamp() >= 2 * 60 * 1000);
	}

	private String generatePassword() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(characters.length());
			password.append(characters.charAt(index));
		}
		return password.toString();
	}

}

//public String sendEmail(EmailRequest emailRequest,int times) {
//SimpleMailMessage message = new SimpleMailMessage();
//message.setTo(emailRequest.getTo());
//message.setSubject(emailRequest.getSubject());
//message.setText(emailRequest.getText());
//
//try {
//	for (int i = 0; i < times; i++) {
//		javaMailSender.send(message);
//	}
//	return "success";
//} catch (Exception e) {
//	return e.getMessage();
//}
//
//}
