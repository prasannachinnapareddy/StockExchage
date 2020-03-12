package com.cts.training.stockexchangeservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("user-service")
public interface UserServiceProxy 
{
	 @GetMapping("/allUsers")
	  public ResponseEntity<?> getallusers();
	 
}
