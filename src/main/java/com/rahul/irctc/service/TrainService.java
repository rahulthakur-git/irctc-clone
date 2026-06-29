package com.rahul.irctc.service;

import com.rahul.irctc.entity.Train;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TrainService {
    Train addTrain(Train train);
    List<Train> getAllTrains();

    Optional<Train> getTrainById(Long id);
    List<Train> searchTrains(String source, String destination);
    Train updateTrain(Long id, Train train);

     ResponseEntity<String> deleteTrain(Long id);
}
