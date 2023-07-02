package com.casestudy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.casestudy.model.TrainTicket;

@Repository
public interface TicketRepository extends MongoRepository<TrainTicket, Integer> {
	List<TrainTicket> findByUsername(String userEmail);
}
