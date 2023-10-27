package com.bookingservice.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bookingservice.entity.BookingData;
import com.bookingservice.repository.BookingDataRepository;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookingDataServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BookingDataServiceImplTest {
    @MockBean
    private BookingDataRepository bookingDataRepository;

    @Autowired
    private BookingDataServiceImpl bookingDataServiceImpl;


    @Test
    void testGetBookingDataByEventAndUserId() {
        when(bookingDataRepository.findAll()).thenReturn(new ArrayList<>());
        assertNull(bookingDataServiceImpl.getBookingDataByEventAndUserId(1L, 1L));
        verify(bookingDataRepository).findAll();
    }

    /**
     * Method under test: {@link BookingDataServiceImpl#getBookingDataByEventAndUserId(Long, Long)}
     */
    @Test
    void testGetBookingDataByEventAndUserId2() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        ArrayList<BookingData> bookingDataList = new ArrayList<>();
        bookingDataList.add(bookingData);
        when(bookingDataRepository.findAll()).thenReturn(bookingDataList);
        assertSame(bookingData, bookingDataServiceImpl.getBookingDataByEventAndUserId(1L, 1L));
        verify(bookingDataRepository).findAll();
    }

    /**
     * Method under test: {@link BookingDataServiceImpl#getBookingDataByEventAndUserId(Long, Long)}
     */
    @Test
    void testGetBookingDataByEventAndUserId3() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(2L);
        bookingData2.setId(2L);
        bookingData2.setNumberOfAdults(0L);
        bookingData2.setNumberOfBreakfast(0L);
        bookingData2.setNumberOfChildren(0L);
        bookingData2.setNumberOfDinner(0L);
        bookingData2.setNumberOfLunch(0L);
        bookingData2.setTotalPrice(0.5d);
        bookingData2.setUserId(2L);

        ArrayList<BookingData> bookingDataList = new ArrayList<>();
        bookingDataList.add(bookingData2);
        bookingDataList.add(bookingData);
        when(bookingDataRepository.findAll()).thenReturn(bookingDataList);
        assertSame(bookingData, bookingDataServiceImpl.getBookingDataByEventAndUserId(1L, 1L));
        verify(bookingDataRepository).findAll();
    }

    /**
     * Method under test: {@link BookingDataServiceImpl#getBookingDataByEventAndUserId(Long, Long)}
     */
    @Test
    void testGetBookingDataByEventAndUserId4() {
        BookingData bookingData = mock(BookingData.class);
        when(bookingData.getUserId()).thenReturn(-1L);
        when(bookingData.getEventId()).thenReturn(1L);
        doNothing().when(bookingData).setBookingDate(Mockito.<Date>any());
        doNothing().when(bookingData).setEventId(Mockito.<Long>any());
        doNothing().when(bookingData).setId(Mockito.<Long>any());
        doNothing().when(bookingData).setNumberOfAdults(Mockito.<Long>any());
        doNothing().when(bookingData).setNumberOfBreakfast(Mockito.<Long>any());
        doNothing().when(bookingData).setNumberOfChildren(Mockito.<Long>any());
        doNothing().when(bookingData).setNumberOfDinner(Mockito.<Long>any());
        doNothing().when(bookingData).setNumberOfLunch(Mockito.<Long>any());
        doNothing().when(bookingData).setTotalPrice(Mockito.<Double>any());
        doNothing().when(bookingData).setUserId(Mockito.<Long>any());
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        ArrayList<BookingData> bookingDataList = new ArrayList<>();
        bookingDataList.add(bookingData);
        when(bookingDataRepository.findAll()).thenReturn(bookingDataList);
        assertNull(bookingDataServiceImpl.getBookingDataByEventAndUserId(1L, 1L));
        verify(bookingDataRepository).findAll();
        verify(bookingData).getEventId();
        verify(bookingData).getUserId();
        verify(bookingData).setBookingDate(Mockito.<Date>any());
        verify(bookingData).setEventId(Mockito.<Long>any());
        verify(bookingData).setId(Mockito.<Long>any());
        verify(bookingData).setNumberOfAdults(Mockito.<Long>any());
        verify(bookingData).setNumberOfBreakfast(Mockito.<Long>any());
        verify(bookingData).setNumberOfChildren(Mockito.<Long>any());
        verify(bookingData).setNumberOfDinner(Mockito.<Long>any());
        verify(bookingData).setNumberOfLunch(Mockito.<Long>any());
        verify(bookingData).setTotalPrice(Mockito.<Double>any());
        verify(bookingData).setUserId(Mockito.<Long>any());
    }

   
  

    /**
     * Method under test: {@link BookingDataServiceImpl#addBookingDataByEventAndUserId(BookingData, Long, Long)}
     */
    @Test
    void testAddBookingDataByEventAndUserId2() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);

        ArrayList<BookingData> bookingDataList = new ArrayList<>();
        bookingDataList.add(bookingData2);
        when(bookingDataRepository.save(Mockito.<BookingData>any())).thenReturn(bookingData);
        when(bookingDataRepository.findAll()).thenReturn(bookingDataList);

        BookingData bookingData3 = new BookingData();
        bookingData3.setBookingDate(mock(Date.class));
        bookingData3.setEventId(1L);
        bookingData3.setId(1L);
        bookingData3.setNumberOfAdults(1L);
        bookingData3.setNumberOfBreakfast(1L);
        bookingData3.setNumberOfChildren(1L);
        bookingData3.setNumberOfDinner(1L);
        bookingData3.setNumberOfLunch(1L);
        bookingData3.setTotalPrice(10.0d);
        bookingData3.setUserId(1L);
        assertEquals("You already registered for this event",
                bookingDataServiceImpl.addBookingDataByEventAndUserId(bookingData3, 1L, 1L));
        verify(bookingDataRepository).findAll();
    }

    /**
     * Method under test: {@link BookingDataServiceImpl#addBookingDataByEventAndUserId(BookingData, Long, Long)}
     */
    @Test
    void testAddBookingDataByEventAndUserId3() {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(mock(Date.class));
        bookingData.setEventId(1L);
        bookingData.setId(1L);
        bookingData.setNumberOfAdults(1L);
        bookingData.setNumberOfBreakfast(1L);
        bookingData.setNumberOfChildren(1L);
        bookingData.setNumberOfDinner(1L);
        bookingData.setNumberOfLunch(1L);
        bookingData.setTotalPrice(10.0d);
        bookingData.setUserId(1L);

        BookingData bookingData2 = new BookingData();
        bookingData2.setBookingDate(mock(Date.class));
        bookingData2.setEventId(1L);
        bookingData2.setId(1L);
        bookingData2.setNumberOfAdults(1L);
        bookingData2.setNumberOfBreakfast(1L);
        bookingData2.setNumberOfChildren(1L);
        bookingData2.setNumberOfDinner(1L);
        bookingData2.setNumberOfLunch(1L);
        bookingData2.setTotalPrice(10.0d);
        bookingData2.setUserId(1L);

        BookingData bookingData3 = new BookingData();
        bookingData3.setBookingDate(mock(Date.class));
        bookingData3.setEventId(2L);
        bookingData3.setId(2L);
        bookingData3.setNumberOfAdults(0L);
        bookingData3.setNumberOfBreakfast(0L);
        bookingData3.setNumberOfChildren(0L);
        bookingData3.setNumberOfDinner(0L);
        bookingData3.setNumberOfLunch(0L);
        bookingData3.setTotalPrice(0.5d);
        bookingData3.setUserId(2L);

        ArrayList<BookingData> bookingDataList = new ArrayList<>();
        bookingDataList.add(bookingData3);
        bookingDataList.add(bookingData2);
        when(bookingDataRepository.save(Mockito.<BookingData>any())).thenReturn(bookingData);
        when(bookingDataRepository.findAll()).thenReturn(bookingDataList);

        BookingData bookingData4 = new BookingData();
        bookingData4.setBookingDate(mock(Date.class));
        bookingData4.setEventId(1L);
        bookingData4.setId(1L);
        bookingData4.setNumberOfAdults(1L);
        bookingData4.setNumberOfBreakfast(1L);
        bookingData4.setNumberOfChildren(1L);
        bookingData4.setNumberOfDinner(1L);
        bookingData4.setNumberOfLunch(1L);
        bookingData4.setTotalPrice(10.0d);
        bookingData4.setUserId(1L);
        assertEquals("You already registered for this event",
                bookingDataServiceImpl.addBookingDataByEventAndUserId(bookingData4, 1L, 1L));
        verify(bookingDataRepository).findAll();
    }
}

