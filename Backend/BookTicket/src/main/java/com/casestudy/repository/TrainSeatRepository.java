package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.TrainSeat;


@Repository
public interface TrainSeatRepository extends MongoRepository<TrainSeat, Integer> {

}
