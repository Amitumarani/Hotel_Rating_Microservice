package com.lcwd.rating.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lcwd.rating.ratingservice.entity.HotelRating;

public interface HotelRepository extends JpaRepository<HotelRating, Integer>{
	
	@Query("from HotelRating where userId=:userId")
	List<HotelRating> getByUserId(int userId);
	
	@Query("from HotelRating where hotelId=:hotelId")
	List<HotelRating> getByHotelId(int hotelId);
	
}
