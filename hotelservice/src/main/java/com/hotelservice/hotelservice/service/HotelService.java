package com.hotelservice.hotelservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelservice.hotelservice.models.Hotels;
import com.hotelservice.hotelservice.repository.HotelRepo;

@Service
public class HotelService {
	@Autowired
	HotelRepo hotelRepo;
	
	// Method to create a new hotel
    public Hotels createHotel(Hotels hotel) {
    	hotel.setId(UUID.randomUUID().toString());
        return hotelRepo.save(hotel);
    }

    // Method to get all hotels
    public List<Hotels> getAllHotels() {
        return hotelRepo.findAll();
    }

    // Method to get a hotel by ID
    public Optional<Hotels> getHotelById(String id) {
        return hotelRepo.findById(id);
    }

    // Method to update an existing hotel
    public Hotels updateHotel(String id, Hotels hotelDetails) {
        return hotelRepo.findById(id).map(hotel -> {
            hotel.setName(hotelDetails.getName());
            hotel.setLocation(hotelDetails.getLocation());
            hotel.setAbout(hotelDetails.getAbout());
            return hotelRepo.save(hotel);
        }).orElseThrow(() -> new RuntimeException("Hotel not found with id " + id));
    }

    // Method to delete a hotel by ID
    public void deleteHotel(String id) {
        hotelRepo.deleteById(id);
    }
}
