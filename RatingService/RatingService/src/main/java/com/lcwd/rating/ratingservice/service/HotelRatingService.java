package com.lcwd.rating.ratingservice.service;

import java.util.List;

import com.lcwd.rating.ratingservice.entity.HotelRating;

public interface HotelRatingService {
	
	public HotelRating createRating(HotelRating hotelRating);
	
	public HotelRating updateRating(HotelRating hotelRating);
	
	public void deleteRating(int ratingId);
	
	public HotelRating getRating(int  ratingId);
	
	public List<HotelRating> getRatingByUserId(int userId);
	
	public List<HotelRating> getRatingByHotelId(int hotelId);

}
