package com.ratingservice.ratingservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingservice.ratingservice.models.Ratings;
import com.ratingservice.ratingservice.repository.RatingsRepo;

@Service
public class RatingsService {
	@Autowired
	RatingsRepo ratingsRepo;
	
	public Ratings createRating(Ratings rating){
		rating.setRatingId(UUID.randomUUID().toString());
		return ratingsRepo.save(rating);
	}
	public List<Ratings> getAllRatings(){
		return ratingsRepo.findAll();
	}
	public List<Ratings> getRatingByUserId(String userId) {
		return ratingsRepo.getRatingsByUserId(userId);
	}
}
