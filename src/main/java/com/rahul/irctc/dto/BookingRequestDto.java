package com.rahul.irctc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookingRequestDto {
    private Long scheduleId;
    private String passengerName;
    private String passengerEmail;
    private String passengerPhone;
    private Integer numberOfSeats;

}
