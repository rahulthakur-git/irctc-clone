package com.rahul.irctc.controller;

import com.rahul.irctc.entity.Train;
import com.rahul.irctc.service.TrainService;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/search")
    public List<Train> searchTrains(@RequestParam String source,@RequestParam String destination){
        return trainService.searchTrains(source,destination);
    }
    @PutMapping("/{id}")
    public Train updateTrain(@PathVariable Long id , @RequestBody Train train){
        return trainService.updateTrain(id, train);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrain(@PathVariable Long id){
        return trainService.deleteTrain(id);
    }
}
