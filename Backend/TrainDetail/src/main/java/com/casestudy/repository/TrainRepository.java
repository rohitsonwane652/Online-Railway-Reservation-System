package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.TrainDetail;

public interface TrainRepository extends MongoRepository<TrainDetail, Integer>{

}
