package com.feedbackservice.controller;

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

import com.feedbackservice.entity.Feedback;
import com.feedbackservice.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = { "*" })
public class FeedbackController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);

	@Autowired
	FeedbackService feedbackService;

	// API TO POST FEEDBACK FROM USER TO DATABASE
	@PostMapping("/post-feedback/{userId}/{eventId}")
	public ResponseEntity<String> postFeedback(@PathVariable("userId") Long userId,
			@PathVariable("eventId") Long eventId, @RequestBody String feedbackText) {
		try {
			LOGGER.info("Feedback posting with UserId: {}, EventId: {}", userId, eventId);
			return ResponseEntity.ok(feedbackService.saveFeedback(userId, eventId, feedbackText));
		} catch (Exception e) {
			LOGGER.error("Failed to post feedback. UserId: {}, EventId: {}", userId, eventId, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to post feedback");
		}
	}

	// API TO FETCH FEEDBACK FROM DATABASE
	@GetMapping("/get-feedback/{userId}/{eventId}")
	public ResponseEntity<?> getFeedbackByUserIdAndEventId(@PathVariable("userId") Long userId,
			@PathVariable("eventId") Long eventId) {
		try {
			Object feedback = feedbackService.getFeedbackByUserIdAndEventId(userId, eventId);

			if (feedback instanceof Feedback) {
				LOGGER.info("Feedback fetched successfully. UserId: {}, EventId: {}", userId, eventId);
				return ResponseEntity.ok((Feedback) feedback);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((String) feedback);
			}
		} catch (Exception e) {
			LOGGER.error("Failed to fetch feedback. UserId: {}, EventId: {}", userId, eventId, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No Feedback Found");
		}
	}
}
