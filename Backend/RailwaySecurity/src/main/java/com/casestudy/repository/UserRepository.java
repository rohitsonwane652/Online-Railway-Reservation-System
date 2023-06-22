package com.casestudy.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.UserData;

@Repository
public interface UserRepository extends MongoRepository<UserData, Long> {
	Optional<UserData> findByEmail(String email);
}
