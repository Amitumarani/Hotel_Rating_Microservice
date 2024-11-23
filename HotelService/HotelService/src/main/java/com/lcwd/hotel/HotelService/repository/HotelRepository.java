package com.lcwd.hotel.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.hotel.HotelService.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
