package com.rahul.irctc.controller;
import com.rahul.irctc.entity.TrainSchedule;
import com.rahul.irctc.service.TrainScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")

public class TrainScheduleController {
    private final TrainScheduleService trainScheduleService;

    public TrainScheduleController(TrainScheduleService trainScheduleService) {
        this.trainScheduleService = trainScheduleService;
    }
    @GetMapping("/search")
    public List<TrainSchedule> searchTrain(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam LocalDate journeyDate
            ){
        return trainScheduleService.searchTrains(source,destination,journeyDate);
    }
}
