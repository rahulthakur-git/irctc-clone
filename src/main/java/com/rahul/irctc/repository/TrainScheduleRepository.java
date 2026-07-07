package com.rahul.irctc.repository;

import com.rahul.irctc.entity.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;

public interface TrainScheduleRepository extends JpaRepository<TrainSchedule,Long>{


    List<TrainSchedule> findByJourneyDateAndTrain_SourceAndTrain_Destination(
            LocalDate journeyDate,
            String source,
            String destination
    );
}
