package com.lcwd.user.service.UserService.externalService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcwd.user.service.UserService.dto.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	@GetMapping("rating/user")
	List<Rating> getRating(@RequestParam int userId);

}
