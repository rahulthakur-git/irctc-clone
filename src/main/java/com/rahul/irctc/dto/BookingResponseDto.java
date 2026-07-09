package com.rahul.irctc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingResponseDto {
    private String pnr;

    private String passengerName;

    private String trainNumber;

    private String trainName;

    private String source;

    private String destination;

    private LocalDate journeyDate;

    private Integer bookedSeats;

    private String bookingStatus;

    private LocalDateTime bookingDate;

}
