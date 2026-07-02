package com.rahul.irctc.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "Trains")
@Data
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String trainName;
    private String trainNumber;
    private String trainType;
    private String source;
    private String destination;
    private Integer totalSeats;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> runningDays;
    private List<TrainSchedule> schedule;




}
