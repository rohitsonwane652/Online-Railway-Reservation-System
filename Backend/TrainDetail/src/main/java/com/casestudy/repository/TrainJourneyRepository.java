package com.casestudy.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.TrainJourney;

public interface TrainJourneyRepository extends MongoRepository<TrainJourney, Integer> {
	TrainJourney findByTrainId(int trainId);
	List<TrainJourney> findByTrainDate(Date date);
}
