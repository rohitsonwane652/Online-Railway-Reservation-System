package com.casestudy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.TrainStation;

public interface TrainStationRepository extends MongoRepository<TrainStation, Integer> {
	
	List<TrainStation> findByTrainFromAndTrainTo(String trainFrom,String trainTo);
}
