package com.lcwd.hotel.HotelService.pojo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelException {
	
	private Timestamp timeStamp;
	private String errorMessage;
	
}
