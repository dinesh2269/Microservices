package com.ratingservice.ratingservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ratingservice.ratingservice.models.Ratings;

public interface RatingsRepo extends MongoRepository<Ratings, String> {
	
	List<Ratings> getRatingsByUserId(String userId);
	
}
