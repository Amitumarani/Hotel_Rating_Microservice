package com.lcwd.rating.ratingservice.entity;

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
@Table(name="hotelrating")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelRating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ratingid")
	private int ratingId;
	
	@Column(name="userid")
	private int userId;
	
	@Column(name="hotelid")
	private int hotelId;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="feedback")
	private String feedback;

}
