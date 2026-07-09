package com.rahul.irctc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TrainSearchResponseDto {
    private String trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalDate journeyDate;
    private Integer availableSeats;
    private String status;
}
