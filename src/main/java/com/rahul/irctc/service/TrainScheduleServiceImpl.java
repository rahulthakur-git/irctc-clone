package com.rahul.irctc.service;

import com.rahul.irctc.entity.Train;
import com.rahul.irctc.entity.TrainSchedule;
import com.rahul.irctc.repository.TrainRepository;
import com.rahul.irctc.repository.TrainScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public List<TrainSchedule> searchTrains(String source,
                                            String destination,
                                            LocalDate journeyDate) {

        return trainScheduleRepository
                .findByJourneyDateAndTrain_SourceAndTrain_Destination(
                        journeyDate,
                        source,
                        destination
                );
    }

    }


