package com.adminservice.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

import com.adminservice.entity.Event;
import com.adminservice.exceptions.EventNotFoundException;
import com.adminservice.exceptions.NoEventsFoundException;
import com.adminservice.serviceimpl.EventServiceImpl;

@ContextConfiguration(classes = {EventController.class})
@ExtendWith(SpringExtension.class)
class EventControllerTest {
    @Autowired
    private EventController eventController;

    @MockBean
    private EventServiceImpl eventServiceImpl;

    @Test
    void testAddEvent() throws Exception {
        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.post("/api/admin/event/newevent")
                .param("eventData", "foo");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("eventImage", String.valueOf((Object) null));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
    }


    @Test
    void testDeleteEventById() throws Exception {
        when(eventServiceImpl.deleteEventById(Mockito.<Long>any())).thenReturn("Delete Event By Id");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/admin/event/deleteevent/{eventIdToDelete}", 1L);
        MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Event deleted successfully"));
    }

 
    @Test
    void testGetAllEvents() throws Exception {
        when(eventServiceImpl.getAllEvents()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/admin/event/eventlist");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("No events are there in the database"));
    }


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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/admin/event/eventlist");
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


    @Test
    void testGetAllEvents3() throws Exception {
        Time eventCloseTime = mock(Time.class);
        when(eventCloseTime.getTime()).thenReturn(10L);
        Date eventDate = mock(Date.class);
        when(eventDate.getTime()).thenReturn(10L);
        Time eventStartTime = mock(Time.class);
        when(eventStartTime.getTime()).thenReturn(10L);
        Date registrationCloseDate = mock(Date.class);
        when(registrationCloseDate.getTime()).thenReturn(10L);
        Date registrationOpenDate = mock(Date.class);
        when(registrationOpenDate.getTime()).thenThrow(new NoEventsFoundException("An error occurred"));

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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/admin/event/eventlist");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("[{\"id\":1,\"eventName\":\"?\",\"eventDate\":10,\"registrationOpenDate\"}]"));
    }


    @Test
    void testGetAllEvents4() throws Exception {
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
        Time eventCloseTime2 = mock(Time.class);
        when(eventCloseTime2.getTime()).thenReturn(10L);
        Date eventDate2 = mock(Date.class);
        when(eventDate2.getTime()).thenReturn(10L);
        Time eventStartTime2 = mock(Time.class);
        when(eventStartTime2.getTime()).thenReturn(10L);
        Date registrationCloseDate2 = mock(Date.class);
        when(registrationCloseDate2.getTime()).thenReturn(10L);
        Date registrationOpenDate2 = mock(Date.class);
        when(registrationOpenDate2.getTime()).thenReturn(10L);

        Event event2 = new Event();
        event2.setBreakfastPrice(0.5d);
        event2.setDeleteStatus(false);
        event2.setDinnerPrice(0.5d);
        event2.setEventCapacity(0L);
        event2.setEventCloseTime(eventCloseTime2);
        event2.setEventDate(eventDate2);
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Fetching all events");
        event2.setEventStartTime(eventStartTime2);
        event2.setId(2L);
        event2.setLunchPrice(0.5d);
        event2.setRegistrationCloseDate(registrationCloseDate2);
        event2.setRegistrationFee(0.5d);
        event2.setRegistrationOpenDate(registrationOpenDate2);

        ArrayList<Event> eventList = new ArrayList<>();
        eventList.add(event2);
        eventList.add(event);
        when(eventServiceImpl.getAllEvents()).thenReturn(eventList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/admin/event/eventlist");
        MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":2,\"eventName\":\"Fetching all events\",\"eventDate\":10,\"registrationOpenDate\":10,\"registrationCloseDate"
                                        + "\":10,\"eventStartTime\":10,\"eventCloseTime\":10,\"registrationFee\":0.5,\"eventCapacity\":0,\"breakfastPrice"
                                        + "\":0.5,\"lunchPrice\":0.5,\"dinnerPrice\":0.5,\"deleteStatus\":false,\"eventImage\":\"QVhBWEFYQVg=\"},{\"id\":1,"
                                        + "\"eventName\":\"?\",\"eventDate\":10,\"registrationOpenDate\":10,\"registrationCloseDate\":10,\"eventStartTime\""
                                        + ":10,\"eventCloseTime\":10,\"registrationFee\":10.0,\"eventCapacity\":1,\"breakfastPrice\":10.0,\"lunchPrice\""
                                        + ":10.0,\"dinnerPrice\":10.0,\"deleteStatus\":true,\"eventImage\":\"QQFBAUEBQQE=\"}]"));
    }


    @Test
    void testGetEventByEventId() throws Exception {
        when(eventServiceImpl.getEventByEventId(Mockito.<Long>any())).thenReturn("Event By Event Id");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/admin/event/placeholder/eventedit/{eventId}/{needImage}", 1L, 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventController)
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
        when(eventServiceImpl.getEventByEventId(Mockito.<Long>any())).thenReturn(event);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/admin/event/placeholder/eventedit/{eventId}/{needImage}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("image/png"))
                .andExpect(MockMvcResultMatchers.content().string("A\u0001A\u0001A\u0001A\u0001"));
    }


    @Test
    void testGetEventByEventId3() throws Exception {
        when(eventServiceImpl.getEventByEventId(Mockito.<Long>any()))
                .thenThrow(new NoEventsFoundException("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/admin/event/placeholder/eventedit/{eventId}/{needImage}", 1L, 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Internal Server Error"));
    }


    @Test
    void testGetEventByEventId4() throws Exception {
        when(eventServiceImpl.getEventByEventId(Mockito.<Long>any()))
                .thenThrow(new EventNotFoundException("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/admin/event/placeholder/eventedit/{eventId}/{needImage}", 1L, 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("An error occurred"));
    }

    @Test
    void testUpdateEvent() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/admin/event/eventedit/{eventIdToUpdate}", 1L)
                .param("eventData", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(eventController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
    }
}

