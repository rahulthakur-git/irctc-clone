package com.rahul.irctc.service;

import com.rahul.irctc.dto.BookingRequestDto;
import com.rahul.irctc.dto.BookingResponseDto;


public interface BookingService {
    BookingResponseDto bookTicket(BookingRequestDto bookingRequestDto);
    BookingResponseDto cancelBooking(String pnr);
}
