package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.TrainInfo;

public interface TrainRepository extends MongoRepository<TrainInfo, Integer> {
	TrainInfo findByTrainNo(int trainNo);
}
