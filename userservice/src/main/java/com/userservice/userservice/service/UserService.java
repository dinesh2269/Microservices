package com.userservice.userservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.userservice.model.Ratings;
import com.userservice.userservice.model.Users;
import com.userservice.userservice.repository.UsersRepo;

@Service
public class UserService {
	@Autowired
	UsersRepo userRepository;
	@Autowired
	RestTemplate restTemplate;
	
	// Find user by ID
    public Optional<Users> findById(String userId) {
        return userRepository.findById(userId);
    }

    // Find all users
    public List<Users> findAll() {
    	List<Users> usersList= userRepository.findAll();
    	usersList.stream().map((user)->{
    		String url = "http://RATING-SERVICE/ratings/"+user.getUserId() ;

//    		Ratings rating=restTemplate.exchange(url, get, null, null, null)
    		Ratings[] userRatings=restTemplate.getForObject(url, Ratings[].class);
    		List<Ratings> ratings=List.of(userRatings);
    		user.setRatings(ratings);
    		return user;
    	}).collect(Collectors.toList());
    	
    	return usersList;
    }

    // Create or update a user
    public Users createOrUpdateUser(Users user) {
    	user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    // Delete a user by ID
    public void deleteUser(String userId) {
    	userRepository.deleteById(userId);
    }
}
