package com.lcwd.hotel.HotelService.exception;

public class HotelNotFoundException extends RuntimeException {

	public HotelNotFoundException() {
		super();
	}

	public HotelNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public HotelNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public HotelNotFoundException(String message) {
		super(message);
	}

	public HotelNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
