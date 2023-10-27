package com.feedbackservice.service;

import com.feedbackservice.entity.Feedback;

public interface FeedbackService {
	public String saveFeedback(Long userId, Long eventId, String feedbackText);

	public Object getFeedbackByUserIdAndEventId(Long userId, Long eventId);
}
