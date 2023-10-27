package com.feedbackservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedbackservice.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
		
}
