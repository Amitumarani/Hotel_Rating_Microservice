package com.lcwd.hotel.HotelService.service;

import java.util.List;

import com.lcwd.hotel.HotelService.entity.Hotel;

public interface HotelService {
	
	public Hotel createHotelReview(Hotel hotel);
	
	public Hotel updateHotelReview(Hotel hotel);
	
	public List<Hotel> getAllReview();
	
	public Hotel getindividualHotelReview(int hotelId);

	public void deleteHotelReview(int hotelId);

}
