package com.rahul.irctc.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Trains")
@Data
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String trainName;
    private String trainNumber;
    private String source;
    private String destination;
    private Integer totalSeats;
    private Integer availableSeats;

}
