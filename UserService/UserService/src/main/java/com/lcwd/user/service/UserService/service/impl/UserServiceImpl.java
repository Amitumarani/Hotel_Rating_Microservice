package com.lcwd.user.service.UserService.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.UserService.dto.Hotel;
import com.lcwd.user.service.UserService.dto.Rating;
import com.lcwd.user.service.UserService.dto.User;
import com.lcwd.user.service.UserService.exception.UserNotFoundException;
import com.lcwd.user.service.UserService.externalService.HotelService;
import com.lcwd.user.service.UserService.externalService.RatingService;
import com.lcwd.user.service.UserService.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;
	
	

	@Override
	public User saveUser(User user) {
		 return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser(){
		List<User> userList= userRepository.findAll();
		List<User> returnUserList = new ArrayList<>();
		for(User user:userList) {
			getRatingDetails(user);
			returnUserList.add(user); 
		}
		return returnUserList;
	}

	@Override
	public User getUser(int userId) {
		Optional<User> opUser = userRepository.findById(userId);
		List<Rating> listRating = new ArrayList<>();
		if(opUser.isPresent()) {
			User user = opUser.get();
			//getRatingDetails(user);
			List<Rating> ratingList = ratingService.getRating(user.getUserId());
			user.setRating(ratingList);
			
			for(Rating rating:user.getRating()){
		     //Hotel hotel = getHotelDetails(rating.getHotelId());
				Hotel hotel = hotelService.getHotel(rating.getHotelId());
				rating.setHotel(hotel);
				listRating.add(rating);
			}
			user.setRating(listRating);
			return user;
		}else {
			throw new UserNotFoundException("User not found with userId "+userId);
		}
	}

//	private Hotel getHotelDetails(int hotelId) {
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.set(HttpHeaders.CONTENT_TYPE , "application/json");
//	    HttpEntity<Hotel> httpEntity = new HttpEntity<>(httpHeaders);
//	    ResponseEntity<Hotel> hotelResponse = restTemplate.exchange("http://HOTEL-SERVICE/hotels/"+hotelId, HttpMethod.GET, httpEntity, Hotel.class);
//		return hotelResponse.getBody();
//	}

	private void getRatingDetails(User user) {
	    HttpHeaders httpheaders = new HttpHeaders();
	    httpheaders.set(httpheaders.CONTENT_TYPE, "application/json");
	    HttpEntity<Rating> httpEntity = new HttpEntity<>(httpheaders);
	    ResponseEntity<List<Rating>> ratingResponse = restTemplate.exchange("http://RATING-SERVICE/rating/user?userId="+user.getUserId(), HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Rating>>() {});
        List<Rating> ratingList = ratingResponse.getBody();
        user.setRating(ratingList);
	}

}
