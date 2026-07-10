package com.rahul.irctc.controller;

import com.rahul.irctc.dto.BookingRequestDto;
import com.rahul.irctc.dto.BookingResponseDto;
import com.rahul.irctc.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")

public class BookingController {
    private final BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping
    public BookingResponseDto bookTicket(@RequestBody BookingRequestDto bookingRequestDto) {
        return bookingService.bookTicket(bookingRequestDto);
    }
    @PutMapping("/cancel/{pnr}")
    public BookingResponseDto cancelBooking(@PathVariable String pnr){
        return bookingService.cancelBooking(pnr);
    }
}
