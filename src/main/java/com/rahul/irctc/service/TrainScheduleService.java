package com.rahul.irctc.service;

import com.rahul.irctc.dto.TrainSearchResponseDto;
import com.rahul.irctc.entity.Train;
import com.rahul.irctc.entity.TrainSchedule;

import java.time.LocalDate;
import java.util.List;

public interface TrainScheduleService {
    public void generateSchedules(Train train);
    List<TrainSearchResponseDto> searchTrains(String source, String destination, LocalDate journeyDate);
}
