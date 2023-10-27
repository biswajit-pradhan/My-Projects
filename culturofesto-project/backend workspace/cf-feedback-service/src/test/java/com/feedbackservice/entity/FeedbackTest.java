package com.feedbackservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FeedbackTest {
  
    @Test
    void testCanEqual() {
        assertFalse((new Feedback()).canEqual("Other"));
    }

 
    @Test
    void testCanEqual2() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUserId(1L);
        assertTrue(feedback.canEqual(feedback2));
    }

    
    @Test
    void testConstructor() {
        Feedback actualFeedback = new Feedback();
        actualFeedback.setEventId(1L);
        actualFeedback.setFeedbackText("Feedback Text");
        actualFeedback.setId(1L);
        actualFeedback.setUserId(1L);
        String actualToStringResult = actualFeedback.toString();
        assertEquals(1L, actualFeedback.getEventId().longValue());
        assertEquals("Feedback Text", actualFeedback.getFeedbackText());
        assertEquals(1L, actualFeedback.getId().longValue());
        assertEquals(1L, actualFeedback.getUserId().longValue());
        assertEquals("Feedback(id=1, userId=1, eventId=1, feedbackText=Feedback Text)", actualToStringResult);
    }

   
    @Test
    void testConstructor2() {
        Feedback actualFeedback = new Feedback(1L, 1L, 1L, "Feedback Text");
        actualFeedback.setEventId(1L);
        actualFeedback.setFeedbackText("Feedback Text");
        actualFeedback.setId(1L);
        actualFeedback.setUserId(1L);
        String actualToStringResult = actualFeedback.toString();
        assertEquals(1L, actualFeedback.getEventId().longValue());
        assertEquals("Feedback Text", actualFeedback.getFeedbackText());
        assertEquals(1L, actualFeedback.getId().longValue());
        assertEquals(1L, actualFeedback.getUserId().longValue());
        assertEquals("Feedback(id=1, userId=1, eventId=1, feedbackText=Feedback Text)", actualToStringResult);
    }

    
    @Test
    void testEquals() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(1L);
        assertNotEquals(feedback, null);
    }

   
    @Test
    void testEquals2() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(1L);
        assertNotEquals(feedback, "Different type to Feedback");
    }

   
    @Test
    void testEquals3() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(1L);
        assertEquals(feedback, feedback);
        int expectedHashCodeResult = feedback.hashCode();
        assertEquals(expectedHashCodeResult, feedback.hashCode());
    }

  
    @Test
    void testEquals4() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUserId(1L);
        assertEquals(feedback, feedback2);
        int expectedHashCodeResult = feedback.hashCode();
        assertEquals(expectedHashCodeResult, feedback2.hashCode());
    }

    
    @Test
    void testEquals5() {
        Feedback feedback = new Feedback();
        feedback.setEventId(2L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUserId(1L);
        assertNotEquals(feedback, feedback2);
    }

   
    @Test
    void testEquals6() {
        Feedback feedback = new Feedback();
        feedback.setEventId(null);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUserId(1L);
        assertNotEquals(feedback, feedback2);
    }

   
    @Test
    void testEquals7() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText(null);
        feedback.setId(1L);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUserId(1L);
        assertNotEquals(feedback, feedback2);
    }

   
    @Test
    void testEquals8() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("com.feedbackservice.entity.Feedback");
        feedback.setId(1L);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUserId(1L);
        assertNotEquals(feedback, feedback2);
    }

  
    @Test
    void testEquals9() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(2L);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUserId(1L);
        assertNotEquals(feedback, feedback2);
    }

   
    @Test
    void testEquals10() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(null);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUserId(1L);
        assertNotEquals(feedback, feedback2);
    }

  
    @Test
    void testEquals11() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(2L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUserId(1L);
        assertNotEquals(feedback, feedback2);
    }

   
    @Test
    void testEquals12() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(null);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUserId(1L);
        assertNotEquals(feedback, feedback2);
    }

   
    @Test
    void testEquals13() {
        Feedback feedback = new Feedback();
        feedback.setEventId(null);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(null);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(1L);
        feedback2.setUserId(1L);
        assertEquals(feedback, feedback2);
        int expectedHashCodeResult = feedback.hashCode();
        assertEquals(expectedHashCodeResult, feedback2.hashCode());
    }

  
    @Test
    void testEquals14() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText(null);
        feedback.setId(1L);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText(null);
        feedback2.setId(1L);
        feedback2.setUserId(1L);
        assertEquals(feedback, feedback2);
        int expectedHashCodeResult = feedback.hashCode();
        assertEquals(expectedHashCodeResult, feedback2.hashCode());
    }

    @Test
    void testEquals15() {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(null);
        feedback.setUserId(1L);

        Feedback feedback2 = new Feedback();
        feedback2.setEventId(1L);
        feedback2.setFeedbackText("Feedback Text");
        feedback2.setId(null);
        feedback2.setUserId(1L);
        assertEquals(feedback, feedback2);
        int expectedHashCodeResult = feedback.hashCode();
        assertEquals(expectedHashCodeResult, feedback2.hashCode());
    }
}

