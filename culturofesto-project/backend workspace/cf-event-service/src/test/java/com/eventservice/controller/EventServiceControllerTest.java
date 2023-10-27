package com.eventservice.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.eventservice.entity.Event;
import com.eventservice.exception.EventNotFoundException;
import com.eventservice.exception.PastEventsNotFoundException;
import com.eventservice.serviceImplementation.EventServiceImplementation;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EventServiceController.class})
@ExtendWith(SpringExtension.class)
class EventServiceControllerTest {
    @Autowired
    private EventServiceController eventServiceController;

    @MockBean
    private EventServiceImplementation eventServiceImplementation;

    
    @Test
    void testGetEventByEventId() throws Exception {
        when(eventServiceImplementation.getEventByEventId(Mockito.<Long>any())).thenReturn("Event By Event Id");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/event/{eventId}/{needImage}", 1L,
                1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventServiceController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Could not find any event"));
    }

   
    @Test
    void testGetEventByEventId2() throws Exception {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
        event.setEventName("?");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        when(eventServiceImplementation.getEventByEventId(Mockito.<Long>any())).thenReturn(event);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/event/{eventId}/{needImage}", 1L,
                1L);
        MockMvcBuilders.standaloneSetup(eventServiceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("image/png"))
                .andExpect(MockMvcResultMatchers.content().string("A\u0001A\u0001A\u0001A\u0001"));
    }

    
    @Test
    void testGetEventByEventId3() throws Exception {
        when(eventServiceImplementation.getEventByEventId(Mockito.<Long>any()))
                .thenThrow(new EventNotFoundException("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/event/{eventId}/{needImage}", 1L,
                1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventServiceController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("An error occurred"));
    }

  
    @Test
    void testGetEventByEventId4() throws Exception {
        when(eventServiceImplementation.getEventByEventId(Mockito.<Long>any()))
                .thenThrow(new PastEventsNotFoundException("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/event/{eventId}/{needImage}", 1L,
                1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventServiceController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Internal Server Error"));
    }

    @Test
    void testGetPastEvents() throws Exception {
        when(eventServiceImplementation.getPastEvents()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/event/past");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventServiceController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("No past events found"));
    }

   
    @Test
    void testGetPastEvents2() throws Exception {
        Time eventCloseTime = mock(Time.class);
        when(eventCloseTime.getTime()).thenReturn(10L);
        Date eventDate = mock(Date.class);
        when(eventDate.getTime()).thenReturn(10L);
        Time eventStartTime = mock(Time.class);
        when(eventStartTime.getTime()).thenReturn(10L);
        Date registrationCloseDate = mock(Date.class);
        when(registrationCloseDate.getTime()).thenReturn(10L);
        Date registrationOpenDate = mock(Date.class);
        when(registrationOpenDate.getTime()).thenReturn(10L);

        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(eventCloseTime);
        event.setEventDate(eventDate);
        event.setEventImage(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
        event.setEventName("?");
        event.setEventStartTime(eventStartTime);
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(registrationCloseDate);
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(registrationOpenDate);

        ArrayList<Event> eventList = new ArrayList<>();
        eventList.add(event);
        when(eventServiceImplementation.getPastEvents()).thenReturn(eventList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/event/past");
        MockMvcBuilders.standaloneSetup(eventServiceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"eventName\":\"?\",\"eventDate\":10,\"registrationOpenDate\":10,\"registrationCloseDate\":10,"
                                        + "\"eventStartTime\":10,\"eventCloseTime\":10,\"registrationFee\":10.0,\"eventCapacity\":1,\"breakfastPrice\":10"
                                        + ".0,\"lunchPrice\":10.0,\"dinnerPrice\":10.0,\"deleteStatus\":true,\"eventImage\":\"QQFBAUEBQQE=\"}]"));
    }

   
    @Test
    void testGetFutureEvents() throws Exception {
        when(eventServiceImplementation.getFutureEvents()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/event/future");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventServiceController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("No future events found"));
    }

   
    @Test
    void testGetFutureEvents2() throws Exception {
        Time eventCloseTime = mock(Time.class);
        when(eventCloseTime.getTime()).thenReturn(10L);
        Date eventDate = mock(Date.class);
        when(eventDate.getTime()).thenReturn(10L);
        Time eventStartTime = mock(Time.class);
        when(eventStartTime.getTime()).thenReturn(10L);
        Date registrationCloseDate = mock(Date.class);
        when(registrationCloseDate.getTime()).thenReturn(10L);
        Date registrationOpenDate = mock(Date.class);
        when(registrationOpenDate.getTime()).thenReturn(10L);

        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(eventCloseTime);
        event.setEventDate(eventDate);
        event.setEventImage(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
        event.setEventName("?");
        event.setEventStartTime(eventStartTime);
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(registrationCloseDate);
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(registrationOpenDate);

        ArrayList<Event> eventList = new ArrayList<>();
        eventList.add(event);
        when(eventServiceImplementation.getFutureEvents()).thenReturn(eventList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/event/future");
        MockMvcBuilders.standaloneSetup(eventServiceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"eventName\":\"?\",\"eventDate\":10,\"registrationOpenDate\":10,\"registrationCloseDate\":10,"
                                        + "\"eventStartTime\":10,\"eventCloseTime\":10,\"registrationFee\":10.0,\"eventCapacity\":1,\"breakfastPrice\":10"
                                        + ".0,\"lunchPrice\":10.0,\"dinnerPrice\":10.0,\"deleteStatus\":true,\"eventImage\":\"QQFBAUEBQQE=\"}]"));
    }
}

