package com.rahul.irctc.repository;

import com.rahul.irctc.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train,Long>{
}
