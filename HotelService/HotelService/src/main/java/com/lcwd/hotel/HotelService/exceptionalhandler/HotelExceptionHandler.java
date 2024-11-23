package com.lcwd.hotel.HotelService.exceptionalhandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lcwd.hotel.HotelService.exception.HotelNotFoundException;
import com.lcwd.hotel.HotelService.pojo.HotelException;

@ControllerAdvice
public class HotelExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<HotelException> isHotelExist(HotelNotFoundException  hotelNotFoundException){
		HotelException hotelException = new HotelException();
		hotelException.setErrorMessage("Hotel not present");
		hotelException.setTimeStamp(Timestamp.valueOf(LocalDateTime.now()));
		return ResponseEntity.ok(hotelException);
	}

}
