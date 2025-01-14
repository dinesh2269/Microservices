package com.ratingservice.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingservice.ratingservice.models.Ratings;
import com.ratingservice.ratingservice.service.RatingsService;

@RestController
@RequestMapping("/ratings")
public class RatingsController {
	@Autowired
	RatingsService ratingsService;
	
	@PostMapping
	public ResponseEntity<Ratings> createRating(@RequestBody Ratings rating){
		return ResponseEntity.ok(ratingsService.createRating(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Ratings>> getRatings(){
		return ResponseEntity.ok(ratingsService.getAllRatings());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<Ratings>> getRatingByUserId(@PathVariable String userId){
		System.out.println("hi");
		return ResponseEntity.ok(ratingsService.getRatingByUserId(userId));
	}
	
}
