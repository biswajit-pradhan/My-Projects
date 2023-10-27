package com.feedbackservice.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedbackservice.entity.Feedback;
import com.feedbackservice.service.FeedbackService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FeedbackController.class})
@ExtendWith(SpringExtension.class)
class FeedbackControllerTest {
    @Autowired
    private FeedbackController feedbackController;

    @MockBean
    private FeedbackService feedbackService;

    @Test
    void testGetFeedbackByUserIdAndEventId() throws Exception {
        when(feedbackService.getFeedbackByUserIdAndEventId(Mockito.<Long>any(), Mockito.<Long>any()))
                .thenReturn("Feedback By User Id And Event Id");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/feedback/get-feedback/{userId}/{eventId}", 1L, 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(feedbackController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Feedback By User Id And Event Id"));
    }

   
    @Test
    void testGetFeedbackByUserIdAndEventId2() throws Exception {
        Feedback feedback = new Feedback();
        feedback.setEventId(1L);
        feedback.setFeedbackText("?");
        feedback.setId(1L);
        feedback.setUserId(1L);
        when(feedbackService.getFeedbackByUserIdAndEventId(Mockito.<Long>any(), Mockito.<Long>any()))
                .thenReturn(feedback);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/feedback/get-feedback/{userId}/{eventId}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(feedbackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"id\":1,\"userId\":1,\"eventId\":1,\"feedbackText\":\"?\"}"));
    }

   
    @Test
    void testGetFeedbackByUserIdAndEventId3() throws Exception {
        when(feedbackService.getFeedbackByUserIdAndEventId(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/feedback/get-feedback/{userId}/{eventId}", 1L, 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(feedbackController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("No Feedback Found"));
    }
    @Test
    void testPostFeedback() throws Exception {
        when(feedbackService.saveFeedback(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn("Save Feedback");
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/api/feedback/post-feedback/{userId}/{eventId}", 1L, 1L)
                .contentType(MediaType.APPLICATION_JSON);
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString("foo"));
        MockMvcBuilders.standaloneSetup(feedbackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Save Feedback"));
    }
}

