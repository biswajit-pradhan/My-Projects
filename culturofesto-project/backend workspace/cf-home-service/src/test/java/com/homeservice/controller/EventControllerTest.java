package com.homeservice.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.homeservice.entity.Event;
import com.homeservice.exception.EventNotFoundException;
import com.homeservice.exception.NoEventsFoundException;
import com.homeservice.service.EventServiceImpl;

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

@ContextConfiguration(classes = {EventController.class})
@ExtendWith(SpringExtension.class)
class EventControllerTest {
    @Autowired
    private EventController eventController;

    @MockBean
    private EventServiceImpl eventServiceImpl;

    /**
     * Method under test: {@link EventController#getAllEvents()}
     */
    @Test
    void testGetAllEvents() throws Exception {
        when(eventServiceImpl.getAllEvents()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/home/event/search");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("No events are found in the database"));
    }

    /**
     * Method under test: {@link EventController#getAllEvents()}
     */
    @Test
    void testGetAllEvents2() throws Exception {
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
        when(eventServiceImpl.getAllEvents()).thenReturn(eventList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/home/event/search");
        MockMvcBuilders.standaloneSetup(eventController)
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

    /**
     * Method under test: {@link EventController#getEventByEventId(Long, Long)}
     */
    @Test
    void testGetEventByEventId() throws Exception {
        when(eventServiceImpl.getEventByEventId(Mockito.<Long>any())).thenReturn("Event By Event Id");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/home/event/search/{eventId}/{needImage}", 1L, 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Event not found with ID: 1"));
    }

    /**
     * Method under test: {@link EventController#getEventByEventId(Long, Long)}
     */
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
        when(eventServiceImpl.getEventByEventId(Mockito.<Long>any())).thenReturn(event);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/home/event/search/{eventId}/{needImage}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("image/png"))
                .andExpect(MockMvcResultMatchers.content().string("A\u0001A\u0001A\u0001A\u0001"));
    }

    /**
     * Method under test: {@link EventController#getEventByEventId(Long, Long)}
     */
    @Test
    void testGetEventByEventId3() throws Exception {
        when(eventServiceImpl.getEventByEventId(Mockito.<Long>any()))
                .thenThrow(new NoEventsFoundException("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/home/event/search/{eventId}/{needImage}", 1L, 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Internal Server Error"));
    }

    /**
     * Method under test: {@link EventController#getEventByEventId(Long, Long)}
     */
    @Test
    void testGetEventByEventId4() throws Exception {
        when(eventServiceImpl.getEventByEventId(Mockito.<Long>any()))
                .thenThrow(new EventNotFoundException("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/home/event/search/{eventId}/{needImage}", 1L, 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("An error occurred"));
    }
}

