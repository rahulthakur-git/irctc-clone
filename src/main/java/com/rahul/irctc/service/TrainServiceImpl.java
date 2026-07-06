package com.rahul.irctc.service;

import com.rahul.irctc.entity.Train;
import com.rahul.irctc.repository.TrainRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainServiceImpl implements TrainService{
    private final TrainRepository trainRepository;
    private final TrainScheduleService trainScheduleService;

    public TrainServiceImpl(TrainRepository trainRepository, TrainScheduleService trainScheduleService) {
        this.trainRepository = trainRepository;
        this.trainScheduleService = trainScheduleService;
    }

    @Override
    public Train addTrain(Train train) {
        Train savedTrain = trainRepository.save(train);
        trainScheduleService.generateSchedules(savedTrain);
        return trainRepository.save(train);
    }

    @Override
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    @Override
    public Optional<Train> getTrainById(Long id) {
        return trainRepository.findById(id);
    }

    @Override
    public List<Train> searchTrains(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }

    @Override
    public Train updateTrain(Long id, Train train) {
        Optional<Train> optionalTrain = trainRepository.findById(id);
        if (optionalTrain.isPresent()){
            Train existingTrain = optionalTrain.get();
            existingTrain.setTrainName(train.getTrainName());
            existingTrain.setTrainNumber(train.getTrainNumber());
            existingTrain.setSource(train.getSource());
            existingTrain.setDestination(train.getDestination());
            existingTrain.setTotalSeats(train.getTotalSeats());

            return trainRepository.save(existingTrain);
        }
        throw new RuntimeException("Train not found ");

    }

    @Override
    public ResponseEntity<String> deleteTrain(Long id) {
        Optional<Train> optionalTrain = trainRepository.findById(id);
        if (optionalTrain.isPresent()){
            trainRepository.deleteById(id);
            return ResponseEntity.ok("Train deleted successfully");
        }
        throw new RuntimeException("Train not found");
    }
}
