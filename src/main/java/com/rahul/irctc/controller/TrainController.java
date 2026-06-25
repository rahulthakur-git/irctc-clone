package com.rahul.irctc.controller;

import com.rahul.irctc.entity.Train;
import com.rahul.irctc.service.TrainService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trains")
public class TrainController {
    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }
    public Train addTrain(@RequestBody Train train){
        return trainService.addTrain(train);
    }
}
