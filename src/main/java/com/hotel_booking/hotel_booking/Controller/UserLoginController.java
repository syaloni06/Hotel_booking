package com.hotel_booking.hotel_booking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_booking.hotel_booking.Entities.UserLogin;
import com.hotel_booking.hotel_booking.Services.UserLoginService;


@RestController
@RequestMapping("/api/user_login")
public class UserLoginController {
	
	@Autowired
	UserLoginService userLoginService;
	
	@PostMapping("/signup")
	public String createUserAccount(@RequestBody UserLogin userLogin) {
		return userLoginService.signup(userLogin);
	}
	
	@PostMapping("/login")
	public String checkLogin(@RequestBody UserLogin userLogin) {
		return userLoginService.checkLogin(userLogin.getEmail_id(),userLogin.getPassword());
	}
	
	@GetMapping("/search")
	public ResponseEntity<String> login(@RequestParam("query") String query){
		return ResponseEntity.ok(userLoginService.login(query));
	}

}
