package com.lcwd.user.service.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.UserService.dto.User;
import com.lcwd.user.service.UserService.service.impl.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
	  List<User> user =userService.getAllUser();
	  return ResponseEntity.ok(user);
		
	}
	int retryCount=1;
	
	/**
	 * Not able to implement 
	CircuitBreaker
	Retry
	RateLimiter 
	because of dependency issue
	 */
	
	@GetMapping("/{userId}")
	//@CircuitBreaker(name="ratingHotelBreaker", fallbackMethod="ratingHotelFallBack")
	//@Retry(name="ratingHotelretry", fallbackMethod="ratingHotelFallBack")
	@RateLimiter(name="ratingHotelrateLimiter", fallbackMethod="ratingHotelFallBack")
    public ResponseEntity<User> getUser(@PathVariable int userId){
		System.out.println("Retry count is "+retryCount);
		retryCount++;
    	User user =userService.getUser(userId);
  	    return ResponseEntity.ok(user);
		
	}
    
	@PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
		User saveduser =userService.saveUser(user);
  	    return ResponseEntity.ok(saveduser);
	}
	
	public ResponseEntity<User> ratingHotelFallBack(int userId,Exception ex){
		User user = new User();
		user.setUserId(1);
		user.setName("DummyHotel");
		user.setAbout("Dummy About");
		user.setEmail("Dummy@gmail.com");
        return new 	ResponseEntity<>(user,HttpStatus.OK);
		
	}
	

}
