package com.rahul.irctc.repository;

import com.rahul.irctc.entity.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainScheduleRepository extends JpaRepository<TrainSchedule,Long>{
}
