package com.hotel_booking.hotel_booking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String login(@RequestBody UserLogin userLogin) {
		return userLoginService.login(userLogin.getEmail_id(),userLogin.getPassword());
	}
	
}
