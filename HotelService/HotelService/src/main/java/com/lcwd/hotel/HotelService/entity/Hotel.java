package com.lcwd.hotel.HotelService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
	
	@Id
	@Column(name="hotelid")
	@GeneratedValue(strategy=GenerationType.IDENTITY	)
	private int id;
	
	@Column(name="hotelname")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@Column(name="about")
	private String about;

}
