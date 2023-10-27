package com.bookingservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BookingManagementTest {

    @Test
    void testCanEqual() {
        assertFalse((new BookingManagement()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertTrue(bookingManagement.canEqual(bookingManagement2));
    }

   
    @Test
    void testConstructor() {
        BookingManagement actualBookingManagement = new BookingManagement();
        actualBookingManagement.setBookingDataId(1L);
        actualBookingManagement.setCancelStatus(true);
        actualBookingManagement.setEventId(1L);
        actualBookingManagement.setId(1L);
        actualBookingManagement.setPaymentDataId(1L);
        actualBookingManagement.setTicketNo(1L);
        actualBookingManagement.setUserId(1L);
        String actualToStringResult = actualBookingManagement.toString();
        assertEquals(1L, actualBookingManagement.getBookingDataId().longValue());
        assertEquals(1L, actualBookingManagement.getEventId().longValue());
        assertEquals(1L, actualBookingManagement.getId().longValue());
        assertEquals(1L, actualBookingManagement.getPaymentDataId().longValue());
        assertEquals(1L, actualBookingManagement.getTicketNo().longValue());
        assertEquals(1L, actualBookingManagement.getUserId().longValue());
        assertTrue(actualBookingManagement.isCancelStatus());
        assertEquals("BookingManagement(id=1, cancelStatus=true, ticketNo=1, userId=1, eventId=1, bookingDataId=1,"
                + " paymentDataId=1)", actualToStringResult);
    }


    @Test
    void testConstructor2() {
        BookingManagement actualBookingManagement = new BookingManagement(1L, true, 1L, 1L, 1L, 1L, 1L);
        actualBookingManagement.setBookingDataId(1L);
        actualBookingManagement.setCancelStatus(true);
        actualBookingManagement.setEventId(1L);
        actualBookingManagement.setId(1L);
        actualBookingManagement.setPaymentDataId(1L);
        actualBookingManagement.setTicketNo(1L);
        actualBookingManagement.setUserId(1L);
        String actualToStringResult = actualBookingManagement.toString();
        assertEquals(1L, actualBookingManagement.getBookingDataId().longValue());
        assertEquals(1L, actualBookingManagement.getEventId().longValue());
        assertEquals(1L, actualBookingManagement.getId().longValue());
        assertEquals(1L, actualBookingManagement.getPaymentDataId().longValue());
        assertEquals(1L, actualBookingManagement.getTicketNo().longValue());
        assertEquals(1L, actualBookingManagement.getUserId().longValue());
        assertTrue(actualBookingManagement.isCancelStatus());
        assertEquals("BookingManagement(id=1, cancelStatus=true, ticketNo=1, userId=1, eventId=1, bookingDataId=1,"
                + " paymentDataId=1)", actualToStringResult);
    }


    @Test
    void testEquals() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);
        assertNotEquals(bookingManagement, null);
    }


    @Test
    void testEquals2() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);
        assertNotEquals(bookingManagement, "Different type to BookingManagement");
    }


    @Test
    void testEquals3() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);
        assertEquals(bookingManagement, bookingManagement);
        int expectedHashCodeResult = bookingManagement.hashCode();
        assertEquals(expectedHashCodeResult, bookingManagement.hashCode());
    }


    @Test
    void testEquals4() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertEquals(bookingManagement, bookingManagement2);
        int expectedHashCodeResult = bookingManagement.hashCode();
        assertEquals(expectedHashCodeResult, bookingManagement2.hashCode());
    }


    @Test
    void testEquals5() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(2L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }


    @Test
    void testEquals6() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(null);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }


    @Test
    void testEquals7() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(false);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }


    @Test
    void testEquals8() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(2L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }


    @Test
    void testEquals9() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(null);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }


    @Test
    void testEquals10() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(2L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }


    @Test
    void testEquals11() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(null);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }


    @Test
    void testEquals12() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(2L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }


    @Test
    void testEquals13() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(null);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }

    @Test
    void testEquals14() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(3L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }


    @Test
    void testEquals15() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(null);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }


    @Test
    void testEquals16() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(2L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }


    @Test
    void testEquals17() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(1L);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(null);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(1L);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertNotEquals(bookingManagement, bookingManagement2);
    }


    @Test
    void testEquals18() {
        BookingManagement bookingManagement = new BookingManagement();
        bookingManagement.setBookingDataId(null);
        bookingManagement.setCancelStatus(true);
        bookingManagement.setEventId(1L);
        bookingManagement.setId(1L);
        bookingManagement.setPaymentDataId(1L);
        bookingManagement.setTicketNo(1L);
        bookingManagement.setUserId(1L);

        BookingManagement bookingManagement2 = new BookingManagement();
        bookingManagement2.setBookingDataId(null);
        bookingManagement2.setCancelStatus(true);
        bookingManagement2.setEventId(1L);
        bookingManagement2.setId(1L);
        bookingManagement2.setPaymentDataId(1L);
        bookingManagement2.setTicketNo(1L);
        bookingManagement2.setUserId(1L);
        assertEquals(bookingManagement, bookingManagement2);
        int expectedHashCodeResult = bookingManagement.hashCode();
        assertEquals(expectedHashCodeResult, bookingManagement2.hashCode());
    }
}

