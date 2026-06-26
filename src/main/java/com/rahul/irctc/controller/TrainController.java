package com.rahul.irctc.controller;

import com.rahul.irctc.entity.Train;
import com.rahul.irctc.service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trains")
public class TrainController {
    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }
    @PostMapping
    public Train addTrain(@RequestBody Train train){
        return trainService.addTrain(train);
    }
    @GetMapping
    public List<Train> getAllTrains(){
        return trainService.getAllTrains();
    }
    @GetMapping("/{id}")
    public Optional<Train> getTrainById(@PathVariable Long id){
        return trainService.getTrainById(id);
    }
}
