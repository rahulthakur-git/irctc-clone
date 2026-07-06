package com.rahul.irctc.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;


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
    @OneToMany(mappedBy = "train")
    @JsonManagedReference
    private List<TrainSchedule> schedules;




}
