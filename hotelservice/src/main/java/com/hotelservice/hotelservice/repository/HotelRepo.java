package com.hotelservice.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelservice.hotelservice.models.Hotels;

public interface HotelRepo extends JpaRepository<Hotels, String>{

}
