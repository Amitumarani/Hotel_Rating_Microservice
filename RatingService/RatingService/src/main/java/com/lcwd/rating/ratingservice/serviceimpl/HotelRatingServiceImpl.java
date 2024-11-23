package com.lcwd.rating.ratingservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.ratingservice.entity.HotelRating;
import com.lcwd.rating.ratingservice.repository.HotelRepository;
import com.lcwd.rating.ratingservice.service.HotelRatingService;

@Service
public class HotelRatingServiceImpl implements HotelRatingService {
	
	@Autowired 
	HotelRepository hotelRepository;

	@Override
	public HotelRating createRating(HotelRating hotelRating) {
		return hotelRepository.save(hotelRating); 
	}

	@Override
	public HotelRating updateRating(HotelRating hotelRating) {
		return hotelRepository.save(hotelRating); 
	}

	@Override
	public void deleteRating(int ratingId) {
		hotelRepository.deleteById(ratingId);
	}

	@Override
	public HotelRating getRating(int ratingId) {
		Optional<HotelRating> optional = hotelRepository.findById(ratingId);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	@Override
	public List<HotelRating> getRatingByUserId(int userId) {
		return hotelRepository.getByUserId(userId);
	}

	@Override
	public List<HotelRating> getRatingByHotelId(int hotelId) {
		return hotelRepository.getByHotelId(hotelId);
	}

}
