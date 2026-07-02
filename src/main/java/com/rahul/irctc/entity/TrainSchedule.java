package com.rahul.irctc.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "train_schedule")

public class TrainSchedule {
    private GenerationType strategy;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train  train;
    private LocalDate journeyDate;
    private Integer availableSeats;
    private String status;
}
