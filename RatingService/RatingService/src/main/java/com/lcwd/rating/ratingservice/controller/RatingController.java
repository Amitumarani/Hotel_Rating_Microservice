package com.lcwd.rating.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.ratingservice.entity.HotelRating;
import com.lcwd.rating.ratingservice.service.HotelRatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
    HotelRatingService hotelRatingService;
	
	@PostMapping()
	HotelRating createHotelRating(@RequestBody HotelRating hotelrating) {
		return hotelRatingService.createRating(hotelrating);
	}
	
	@PutMapping()
	HotelRating updateHotelRating(@RequestBody HotelRating hotelrating) {
		return hotelRatingService.updateRating(hotelrating);
	}
	
	@DeleteMapping("/{ratingId}")
	void deleteHotelRating(@PathVariable int ratingId) {
		 hotelRatingService.deleteRating(ratingId);
	}
	
	@GetMapping()
	HotelRating getHotelRating(@RequestParam int ratingId) {
		 return hotelRatingService.getRating(ratingId);
	}
	
	@GetMapping("/hotel")
	List<HotelRating> getHotelRatingusingHotelId(@RequestParam int hotelId) {
		 return hotelRatingService.getRatingByHotelId(hotelId);
	}
	
	@GetMapping("/user")
	List<HotelRating> getHotelRatingusingUserId(@RequestParam int userId) {
		 return hotelRatingService.getRatingByUserId(userId);
	}

}
