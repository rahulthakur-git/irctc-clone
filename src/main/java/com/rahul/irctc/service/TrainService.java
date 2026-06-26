package com.rahul.irctc.service;

import com.rahul.irctc.entity.Train;

import java.util.List;
import java.util.Optional;

public interface TrainService {
    Train addTrain(Train train);
    List<Train> getAllTrains();

    Optional<Train> getTrainById(Long id);
}
