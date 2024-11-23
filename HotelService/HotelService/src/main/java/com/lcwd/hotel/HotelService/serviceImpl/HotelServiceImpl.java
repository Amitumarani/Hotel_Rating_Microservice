package com.lcwd.hotel.HotelService.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.HotelService.entity.Hotel;
import com.lcwd.hotel.HotelService.exception.HotelNotFoundException;
import com.lcwd.hotel.HotelService.repository.HotelRepository;
import com.lcwd.hotel.HotelService.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	public HotelRepository hotelRepository;

	@Override
	public Hotel createHotelReview(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	@Override
	public Hotel updateHotelReview(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllReview() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getindividualHotelReview(int hotelId) {
		Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
		if(optionalHotel.isPresent()) {
			return optionalHotel.get();
		}else {
			throw new HotelNotFoundException("Hotel not found with ID"+hotelId);
		}
	}

	@Override
	public void deleteHotelReview(int hotelId) {
		hotelRepository.deleteById(hotelId);
	}

}
