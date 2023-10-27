package com.adminservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;

import org.junit.jupiter.api.Test;

class EventTest {

    @Test
    void testCanEqual() {
        assertFalse((new Event()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() throws UnsupportedEncodingException {
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
        assertTrue(event.canEqual(event2));
    }

    @Test
    void testConstructor() throws UnsupportedEncodingException {
        Event actualEvent = new Event();
        actualEvent.setBreakfastPrice(10.0d);
        actualEvent.setDeleteStatus(true);
        actualEvent.setDinnerPrice(10.0d);
        actualEvent.setEventCapacity(1L);
        Time eventCloseTime = mock(Time.class);
        actualEvent.setEventCloseTime(eventCloseTime);
        Date eventDate = mock(Date.class);
        actualEvent.setEventDate(eventDate);
        byte[] eventImage = "AXAXAXAX".getBytes("UTF-8");
        actualEvent.setEventImage(eventImage);
        actualEvent.setEventName("Event Name");
        Time eventStartTime = mock(Time.class);
        actualEvent.setEventStartTime(eventStartTime);
        actualEvent.setId(1L);
        actualEvent.setLunchPrice(10.0d);
        Date registrationCloseDate = mock(Date.class);
        actualEvent.setRegistrationCloseDate(registrationCloseDate);
        actualEvent.setRegistrationFee(10.0d);
        Date registrationOpenDate = mock(Date.class);
        actualEvent.setRegistrationOpenDate(registrationOpenDate);
        actualEvent.toString();
        assertEquals(10.0d, actualEvent.getBreakfastPrice().doubleValue());
        assertTrue(actualEvent.getDeleteStatus());
        assertEquals(10.0d, actualEvent.getDinnerPrice().doubleValue());
        assertEquals(1L, actualEvent.getEventCapacity().longValue());
        assertSame(eventCloseTime, actualEvent.getEventCloseTime());
        assertSame(eventDate, actualEvent.getEventDate());
        assertSame(eventImage, actualEvent.getEventImage());
        assertEquals("Event Name", actualEvent.getEventName());
        assertSame(eventStartTime, actualEvent.getEventStartTime());
        assertEquals(1L, actualEvent.getId().longValue());
        assertEquals(10.0d, actualEvent.getLunchPrice().doubleValue());
        assertSame(registrationCloseDate, actualEvent.getRegistrationCloseDate());
        assertEquals(10.0d, actualEvent.getRegistrationFee().doubleValue());
        assertSame(registrationOpenDate, actualEvent.getRegistrationOpenDate());
    }

  
    @Test
    void testConstructor2() throws UnsupportedEncodingException {
        Date eventDate = mock(Date.class);
        Date registrationOpenDate = mock(Date.class);
        Date registrationCloseDate = mock(Date.class);
        Time eventStartTime = mock(Time.class);
        Time eventCloseTime = mock(Time.class);
        Event actualEvent = new Event(1L, "Event Name", eventDate, registrationOpenDate, registrationCloseDate,
                eventStartTime, eventCloseTime, 10.0d, 1L, 10.0d, 10.0d, 10.0d, true, "AXAXAXAX".getBytes("UTF-8"));
        actualEvent.setBreakfastPrice(10.0d);
        actualEvent.setDeleteStatus(true);
        actualEvent.setDinnerPrice(10.0d);
        actualEvent.setEventCapacity(1L);
        Time eventCloseTime2 = mock(Time.class);
        actualEvent.setEventCloseTime(eventCloseTime2);
        Date eventDate2 = mock(Date.class);
        actualEvent.setEventDate(eventDate2);
        byte[] eventImage = "AXAXAXAX".getBytes("UTF-8");
        actualEvent.setEventImage(eventImage);
        actualEvent.setEventName("Event Name");
        Time eventStartTime2 = mock(Time.class);
        actualEvent.setEventStartTime(eventStartTime2);
        actualEvent.setId(1L);
        actualEvent.setLunchPrice(10.0d);
        Date registrationCloseDate2 = mock(Date.class);
        actualEvent.setRegistrationCloseDate(registrationCloseDate2);
        actualEvent.setRegistrationFee(10.0d);
        Date registrationOpenDate2 = mock(Date.class);
        actualEvent.setRegistrationOpenDate(registrationOpenDate2);
        actualEvent.toString();
        assertEquals(10.0d, actualEvent.getBreakfastPrice().doubleValue());
        assertTrue(actualEvent.getDeleteStatus());
        assertEquals(10.0d, actualEvent.getDinnerPrice().doubleValue());
        assertEquals(1L, actualEvent.getEventCapacity().longValue());
        assertSame(eventCloseTime2, actualEvent.getEventCloseTime());
        assertSame(eventDate2, actualEvent.getEventDate());
        assertSame(eventImage, actualEvent.getEventImage());
        assertEquals("Event Name", actualEvent.getEventName());
        assertSame(eventStartTime2, actualEvent.getEventStartTime());
        assertEquals(1L, actualEvent.getId().longValue());
        assertEquals(10.0d, actualEvent.getLunchPrice().doubleValue());
        assertSame(registrationCloseDate2, actualEvent.getRegistrationCloseDate());
        assertEquals(10.0d, actualEvent.getRegistrationFee().doubleValue());
        assertSame(registrationOpenDate2, actualEvent.getRegistrationOpenDate());
    }


    @Test
    void testEquals() throws UnsupportedEncodingException {
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
        assertNotEquals(event, null);
    }


    @Test
    void testEquals2() throws UnsupportedEncodingException {
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
        assertNotEquals(event, "Different type to Event");
    }


    @Test
    void testEquals3() throws UnsupportedEncodingException {
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
        assertEquals(event, event);
        int expectedHashCodeResult = event.hashCode();
        assertEquals(expectedHashCodeResult, event.hashCode());
    }


    @Test
    void testEquals4() throws UnsupportedEncodingException {
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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals5() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(null);
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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals6() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(0.5d);
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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals7() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(false);
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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals8() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(null);
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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals9() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(null);
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
        assertNotEquals(event, event2);
    }

    @Test
    void testEquals10() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(0.5d);
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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals11() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(3L);
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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals12() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(null);
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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals13() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(null);
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals14() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName(null);
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals15() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("com.bookingservice.entity.Event");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals16() throws UnsupportedEncodingException {
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
        event.setId(2L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals17() throws UnsupportedEncodingException {
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
        event.setId(null);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals18() throws UnsupportedEncodingException {
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
        event.setLunchPrice(null);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

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
        assertNotEquals(event, event2);
    }

    @Test
    void testEquals19() throws UnsupportedEncodingException {
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
        event.setLunchPrice(0.5d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));

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
        assertNotEquals(event, event2);
    }


    @Test
    void testEquals20() throws UnsupportedEncodingException {
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
        event.setRegistrationFee(null);
        event.setRegistrationOpenDate(mock(Date.class));

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
        assertNotEquals(event, event2);
    }

    @Test
    void testEquals21() throws UnsupportedEncodingException {
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
        event.setRegistrationFee(0.5d);
        event.setRegistrationOpenDate(mock(Date.class));

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
        assertNotEquals(event, event2);
    }

    @Test
    void testEquals22() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(null);
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

        Event event2 = new Event();
        event2.setBreakfastPrice(null);
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
        assertNotEquals(event, event2);
    }
}

