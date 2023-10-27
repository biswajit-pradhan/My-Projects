package com.automaticpasswordgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.automaticpasswordgenerator.service.EmailService;

@RestController
@CrossOrigin(origins = {"*"})
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/sendOtp")
	public ResponseEntity<?> sendOtp(@RequestParam(value = "firstName", defaultValue = "") String firstName,
			@RequestParam(value = "to") String to, @RequestParam(value = "times", defaultValue = "1") int times) {
		return ResponseEntity.ok(emailService.sendOtp(firstName, to, times));
	}
	
	@GetMapping("/validateOtp")
	public ResponseEntity<?> validateOtp(@RequestParam(value = "otp") String otp){
		return ResponseEntity.ok(emailService.validateOtp(otp));
	}

//	@PostMapping("/send")
//	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest,
//			@RequestParam(value = "times", defaultValue = "1") int times) {
//		return ResponseEntity.ok(emailService.sendEmail(emailRequest, times));
//	}
}