package com.rahul.irctc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Table(name = "train_schedule")
@Data

public class TrainSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "train_id")
    @JsonBackReference
    private Train  train;
    private LocalDate journeyDate;
    private Integer availableSeats;
    private String status;
}
