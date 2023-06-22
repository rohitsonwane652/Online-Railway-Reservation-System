package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.TrainTicket;

@Repository
public interface TicketRepository extends MongoRepository<TrainTicket, Integer> {

}
