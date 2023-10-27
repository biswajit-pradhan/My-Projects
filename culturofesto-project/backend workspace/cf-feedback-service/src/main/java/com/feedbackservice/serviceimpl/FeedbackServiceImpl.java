package com.feedbackservice.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackservice.entity.Feedback;
import com.feedbackservice.repository.FeedbackRepository;
import com.feedbackservice.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackServiceImpl.class);

	@Autowired
	FeedbackRepository feedbackRepository;

	@Override
	public String saveFeedback(Long userId, Long eventId, String feedbackText) {

		Optional<Feedback> feedbackCheckDuplicate = feedbackRepository.findAll().stream()
				.filter(f -> (f.getEventId().equals(eventId) && f.getUserId().equals(userId))).findAny();

		if (!feedbackCheckDuplicate.isPresent()) {
			Feedback feedback = new Feedback();
			feedback.setFeedbackText(feedbackText);
			feedback.setEventId(eventId);
			feedback.setUserId(userId);

			feedbackRepository.save(feedback);
			LOGGER.info("Feedback saved. UserId: {}, EventId: {}", userId, eventId);

			return "Feedback saved";

		} else {
			LOGGER.info("Feedback could not saved with UserId: {}, EventId: {} as user already given feedback", userId,
					eventId);
			return "Feedback could not saved with UserId:"+userId+" and EventId:"+eventId+" as user already given feedback";
		}

	}

	public Object getFeedbackByUserIdAndEventId(Long userId, Long eventId) {
		LOGGER.info("Fetching feedback. UserId: {}, EventId: {}", userId, eventId);
		
		Optional<Feedback> feedback= feedbackRepository.findAll().stream()
		.filter(f->(f.getUserId().equals(userId) && f.getEventId().equals(eventId)))
		.findAny();
		
		if(feedback.isPresent()) {
			return feedback.get();
		}else {
			return "Feedback not found with user id:"+userId+" and event id:"+eventId;
		}
	}
}
