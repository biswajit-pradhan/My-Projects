package com.adminservice.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.adminservice.entity.Event;
import com.adminservice.exceptions.EventNotFoundException;
import com.adminservice.respository.EventRepository;

@ContextConfiguration(classes = {EventServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EventServiceImplTest {
    @MockBean
    private EventRepository eventRepository;

    @Autowired
    private EventServiceImpl eventServiceImpl;


    @Test
    void testAddEvent() throws IOException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        when(eventRepository.save(Mockito.<Event>any())).thenReturn(event);

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Event Name");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));
        assertEquals("Event data and image uploaded successfully", eventServiceImpl.addEvent(event2,
                new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
        verify(eventRepository).save(Mockito.<Event>any());
        assertEquals(12, event2.getEventImage().length);
    }

    @Test
    void testUpdateEvent() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        Optional<Event> ofResult = Optional.of(event);

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Event Name");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));
        when(eventRepository.save(Mockito.<Event>any())).thenReturn(event2);
        when(eventRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Event event3 = new Event();
        event3.setBreakfastPrice(10.0d);
        event3.setDeleteStatus(true);
        event3.setDinnerPrice(10.0d);
        event3.setEventCapacity(1L);
        event3.setEventCloseTime(mock(Time.class));
        event3.setEventDate(mock(Date.class));
        event3.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event3.setEventName("Event Name");
        event3.setEventStartTime(mock(Time.class));
        event3.setId(1L);
        event3.setLunchPrice(10.0d);
        event3.setRegistrationCloseDate(mock(Date.class));
        event3.setRegistrationFee(10.0d);
        event3.setRegistrationOpenDate(mock(Date.class));
        assertEquals("Event data updated successfully", eventServiceImpl.updateEvent(1L, event3));
        verify(eventRepository).save(Mockito.<Event>any());
        verify(eventRepository).findById(Mockito.<Long>any());
    }


    @Test
    void testUpdateEvent2() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        Optional<Event> ofResult = Optional.of(event);
        when(eventRepository.save(Mockito.<Event>any())).thenThrow(new EventNotFoundException("An error occurred"));
        when(eventRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Event Name");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));
        assertThrows(EventNotFoundException.class, () -> eventServiceImpl.updateEvent(1L, event2));
        verify(eventRepository).save(Mockito.<Event>any());
        verify(eventRepository).findById(Mockito.<Long>any());
    }


    @Test
    void testUpdateEvent4() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        when(eventRepository.save(Mockito.<Event>any())).thenReturn(event);
        when(eventRepository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Event Name");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));
        assertEquals("No event found with this ID", eventServiceImpl.updateEvent(1L, event2));
        verify(eventRepository).findById(Mockito.<Long>any());
    }


    @Test
    void testDeleteEventById() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        Optional<Event> ofResult = Optional.of(event);

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Event Name");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));
        when(eventRepository.save(Mockito.<Event>any())).thenReturn(event2);
        when(eventRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertEquals("Event deleted successfully", eventServiceImpl.deleteEventById(1L));
        verify(eventRepository).save(Mockito.<Event>any());
        verify(eventRepository).findById(Mockito.<Long>any());
    }


    @Test
    void testDeleteEventById2() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        Optional<Event> ofResult = Optional.of(event);
        when(eventRepository.save(Mockito.<Event>any())).thenThrow(new EventNotFoundException("An error occurred"));
        when(eventRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(EventNotFoundException.class, () -> eventServiceImpl.deleteEventById(1L));
        verify(eventRepository).save(Mockito.<Event>any());
        verify(eventRepository).findById(Mockito.<Long>any());
    }


    @Test
    void testDeleteEventById3() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        when(eventRepository.save(Mockito.<Event>any())).thenReturn(event);
        when(eventRepository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        assertThrows(EventNotFoundException.class, () -> eventServiceImpl.deleteEventById(1L));
        verify(eventRepository).findById(Mockito.<Long>any());
    }
}

