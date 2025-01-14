package com.hotelservice.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelservice.hotelservice.models.Hotels;
import com.hotelservice.hotelservice.service.HotelService;

@RestController
@RequestMapping("/hotelservice")
public class HotelController {
	@Autowired
	HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotels> saveHotel(@RequestBody Hotels hotel){
		return ResponseEntity.ok(hotelService.createHotel(hotel));	
	}
	
	@GetMapping
	public ResponseEntity<List<Hotels>> getHotesl(){
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
}
