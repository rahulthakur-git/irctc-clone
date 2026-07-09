package com.rahul.irctc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "booking")
@NoArgsConstructor
@AllArgsConstructor

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passengerName;
    private String passengerEmail;
    private String passengerPhone;
    private Integer numberOfSeats;
    private String pnr;
    private String bookingStatus;
    private LocalDateTime bookingDate;
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private TrainSchedule trainSchedule;
}

