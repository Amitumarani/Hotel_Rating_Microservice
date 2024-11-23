package com.lcwd.hotel.HotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.HotelService.entity.Hotel;
import com.lcwd.hotel.HotelService.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@PostMapping
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return hotelService.createHotelReview(hotel);
	}
	
	@PutMapping
	public Hotel updateHotel(@RequestBody Hotel hotel) {
		return hotelService.updateHotelReview(hotel);
	}
	
	@DeleteMapping("/{hotelId}")
	public void deleteHotel(@PathVariable int hotelId) {
		 hotelService.deleteHotelReview(hotelId);
	}
	
	@GetMapping("/{hotelId}")
	public Hotel getHotel(@PathVariable int  hotelId) {
		return hotelService.getindividualHotelReview(hotelId);
	}
	
	@GetMapping("")
	public List<Hotel> getAllHotels() {
		return hotelService.getAllReview();
	}
	
}
