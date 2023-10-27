package com.feedbackservice.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.feedbackservice.entity.Feedback;
import com.feedbackservice.repository.FeedbackRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FeedbackServiceImpl.class})
@ExtendWith(SpringExtension.class)
class FeedbackServiceImplTest {
    @MockBean
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackServiceImpl feedbackServiceImpl;

   
    @Test
    void testSaveFeedback() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(1L);
        when(feedbackRepository.save(Mockito.<Feedback>any())).thenReturn(feedback);
        when(feedbackRepository.findAll()).thenReturn(new ArrayList<>());
        assertEquals("Feedback saved", feedbackServiceImpl.saveFeedback(1L, 1L, "Feedback Text"));
        verify(feedbackRepository).save(Mockito.<Feedback>any());
        verify(feedbackRepository).findAll();
    }

    
    @Test
    void testSaveFeedback2() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback saved. UserId: {}, EventId: {}");
        feedback2.setId(1L);
        feedback2.setUserId(1L);

        ArrayList<Feedback> feedbackList = new ArrayList<>();
        feedbackList.add(feedback2);
        when(feedbackRepository.save(Mockito.<Feedback>any())).thenReturn(feedback);
        when(feedbackRepository.findAll()).thenReturn(feedbackList);
        assertEquals("Feedback could not saved with UserId:1 and EventId:1 as user already given feedback",
                feedbackServiceImpl.saveFeedback(1L, 1L, "Feedback Text"));
        verify(feedbackRepository).findAll();
    }

   
    @Test
    void testSaveFeedback3() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback saved. UserId: {}, EventId: {}");
        feedback2.setId(1L);
        feedback2.setUserId(1L);

        Feedback feedback3 = new Feedback();
        feedback3.setEventId(2L);
        feedback3.setFeedbackText("Feedback Text");
        feedback3.setId(2L);
        feedback3.setUserId(2L);

        ArrayList<Feedback> feedbackList = new ArrayList<>();
        feedbackList.add(feedback3);
        feedbackList.add(feedback2);
        when(feedbackRepository.save(Mockito.<Feedback>any())).thenReturn(feedback);
        when(feedbackRepository.findAll()).thenReturn(feedbackList);
        assertEquals("Feedback could not saved with UserId:1 and EventId:1 as user already given feedback",
                feedbackServiceImpl.saveFeedback(1L, 1L, "Feedback Text"));
        verify(feedbackRepository).findAll();
    }

    
    @Test
    void testSaveFeedback4() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(1L);
        Feedback feedback2 = mock(Feedback.class);
        when(feedback2.getUserId()).thenReturn(-1L);
        when(feedback2.getEventId()).thenReturn(1L);
        doNothing().when(feedback2).setEventId(Mockito.<Long>any());
        doNothing().when(feedback2).setFeedbackText(Mockito.<String>any());
        doNothing().when(feedback2).setId(Mockito.<Long>any());
        doNothing().when(feedback2).setUserId(Mockito.<Long>any());
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback saved. UserId: {}, EventId: {}");
        feedback2.setId(1L);
        feedback2.setUserId(1L);

        ArrayList<Feedback> feedbackList = new ArrayList<>();
        feedbackList.add(feedback2);
        when(feedbackRepository.save(Mockito.<Feedback>any())).thenReturn(feedback);
        when(feedbackRepository.findAll()).thenReturn(feedbackList);
        assertEquals("Feedback saved", feedbackServiceImpl.saveFeedback(1L, 1L, "Feedback Text"));
        verify(feedbackRepository).save(Mockito.<Feedback>any());
        verify(feedbackRepository).findAll();
        verify(feedback2).getEventId();
        verify(feedback2).getUserId();
        verify(feedback2).setEventId(Mockito.<Long>any());
        verify(feedback2).setFeedbackText(Mockito.<String>any());
        verify(feedback2).setId(Mockito.<Long>any());
        verify(feedback2).setUserId(Mockito.<Long>any());
    }

    @Test
    void testGetFeedbackByUserIdAndEventId() {
        when(feedbackRepository.findAll()).thenReturn(new ArrayList<>());
        assertEquals("Feedback not found with user id:1 and event id:1",
                feedbackServiceImpl.getFeedbackByUserIdAndEventId(1L, 1L));
        verify(feedbackRepository).findAll();
    }

  
    @Test
    void testGetFeedbackByUserIdAndEventId2() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Fetching feedback. UserId: {}, EventId: {}");
        feedback.setId(1L);
        feedback.setUserId(1L);

        ArrayList<Feedback> feedbackList = new ArrayList<>();
        feedbackList.add(feedback);
        when(feedbackRepository.findAll()).thenReturn(feedbackList);
        assertSame(feedback, feedbackServiceImpl.getFeedbackByUserIdAndEventId(1L, 1L));
        verify(feedbackRepository).findAll();
    }

    
    @Test
    void testGetFeedbackByUserIdAndEventId3() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Fetching feedback. UserId: {}, EventId: {}");
        feedback.setId(1L);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(2L);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(2L);
        feedback2.setUserId(2L);

        ArrayList<Feedback> feedbackList = new ArrayList<>();
        feedbackList.add(feedback2);
        feedbackList.add(feedback);
        when(feedbackRepository.findAll()).thenReturn(feedbackList);
        assertSame(feedback, feedbackServiceImpl.getFeedbackByUserIdAndEventId(1L, 1L));
        verify(feedbackRepository).findAll();
    }

   
    @Test
    void testGetFeedbackByUserIdAndEventId4() {
        Feedback feedback = mock(Feedback.class);
        when(feedback.getEventId()).thenReturn(-1L);
        when(feedback.getUserId()).thenReturn(1L);
        doNothing().when(feedback).setEventId(Mockito.<Long>any());
        doNothing().when(feedback).setFeedbackText(Mockito.<String>any());
        doNothing().when(feedback).setId(Mockito.<Long>any());
        doNothing().when(feedback).setUserId(Mockito.<Long>any());
        feedback.setEventId(1L);
        feedback.setFeedbackText("Fetching feedback. UserId: {}, EventId: {}");
        feedback.setId(1L);
        feedback.setUserId(1L);

        ArrayList<Feedback> feedbackList = new ArrayList<>();
        feedbackList.add(feedback);
        when(feedbackRepository.findAll()).thenReturn(feedbackList);
        assertEquals("Feedback not found with user id:1 and event id:1",
                feedbackServiceImpl.getFeedbackByUserIdAndEventId(1L, 1L));
        verify(feedbackRepository).findAll();
        verify(feedback).getEventId();
        verify(feedback).getUserId();
        verify(feedback).setEventId(Mockito.<Long>any());
        verify(feedback).setFeedbackText(Mockito.<String>any());
        verify(feedback).setId(Mockito.<Long>any());
        verify(feedback).setUserId(Mockito.<Long>any());
    }
}

