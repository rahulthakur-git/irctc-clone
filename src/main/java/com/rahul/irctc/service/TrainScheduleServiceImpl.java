package com.rahul.irctc.service;

import com.rahul.irctc.dto.TrainSearchResponseDto;
import com.rahul.irctc.entity.Train;
import com.rahul.irctc.entity.TrainSchedule;
import com.rahul.irctc.repository.TrainRepository;
import com.rahul.irctc.repository.TrainScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class TrainScheduleServiceImpl implements TrainScheduleService{

    private final TrainScheduleRepository trainScheduleRepository;
    public TrainScheduleServiceImpl(TrainRepository trainRepository, TrainScheduleRepository trainScheduleRepository) {
        this.trainScheduleRepository = trainScheduleRepository;

    }

    @Override
    public void generateSchedules(Train train) {
        List<TrainSchedule> schedule = new ArrayList<>();
        for(int i = 1; i<=90; i++) {

            LocalDate journeyDate = LocalDate.now().plusDays(i);
            if (train.getRunningDays().contains(journeyDate.getDayOfWeek())) {
                TrainSchedule trainSchedule = new TrainSchedule();

                trainSchedule.setTrain(train);
                trainSchedule.setJourneyDate(journeyDate);
                trainSchedule.setAvailableSeats(train.getTotalSeats());
                trainSchedule.setStatus("AVAILABLE");

                schedule.add(trainSchedule);


            }

        }
        trainScheduleRepository.saveAll(schedule);

    }

    @Override
    public List<TrainSearchResponseDto> searchTrains(String source,
                                                     String destination,
                                                     LocalDate journeyDate) {

        List<TrainSchedule> schedules = trainScheduleRepository.findByJourneyDateAndTrain_SourceAndTrain_Destination(journeyDate,source,destination);
        return schedules.stream().map(schedule->{
            TrainSearchResponseDto dto = new TrainSearchResponseDto();
            dto.setTrainNumber(schedule.getTrain().getTrainNumber());
            dto.setTrainName(schedule.getTrain().getTrainName());
            dto.setSource(schedule.getTrain().getSource());
            dto.setDestination(schedule.getTrain().getDestination());
            dto.setDepartureTime(schedule.getTrain().getDepartureTime());
            dto.setArrivalTime(schedule.getTrain().getArrivalTime());
            dto.setJourneyDate(schedule.getJourneyDate());
            dto.setAvailableSeats(schedule.getAvailableSeats());
            dto.setStatus(schedule.getStatus());
            return dto;
        })
                .collect(Collectors.toList());
    }

    }

