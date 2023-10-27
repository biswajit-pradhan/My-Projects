package com.homeservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.homeservice.entity.Event;
import com.homeservice.exception.EventNotFoundException;
import com.homeservice.repo.EventRepository;
import com.homeservice.utils.ImageUtils;

@SpringBootTest
public class EventServiceImplTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

   



    

    


    @Test
    public void testGetEventByEventIdNonExistingEventId() {
        // Mock data
        Long eventId = 100L;

        // Mock repository
        when(eventRepository.findById(eventId)).thenReturn(Optional.empty());

        // Call service method and verify that it throws the expected exception
        assertThrows(EventNotFoundException.class, () -> eventService.getEventByEventId(eventId));
    }

    // Helper method to create an Event object
    private Event createEvent(Long id, String eventName) {
        Event event = new Event();
        event.setId(id);
        event.setEventName(eventName);
        event.setEventDate(new Date(System.currentTimeMillis()));
        event.setRegistrationOpenDate(new Date(System.currentTimeMillis()));
        event.setRegistrationCloseDate(new Date(System.currentTimeMillis()));
        event.setEventStartTime(new Time(System.currentTimeMillis()));
        event.setEventCloseTime(new Time(System.currentTimeMillis()));
        event.setRegistrationFee(10.0);
        event.setEventCapacity(100L);
        event.setBreakfastPrice(5.0);
        event.setLunchPrice(10.0);
        event.setDinnerPrice(15.0);
        event.setDeleteStatus(Boolean.FALSE);
        event.setEventImage(new byte[]{});

        return event;
    }
}
