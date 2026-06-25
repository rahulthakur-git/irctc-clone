package com.rahul.irctc.service;

import com.rahul.irctc.entity.Train;
import com.rahul.irctc.repository.TrainRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainServiceImpl implements TrainService{
    private final TrainRepository trainRepository;

    public TrainServiceImpl(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Override
    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }
}
