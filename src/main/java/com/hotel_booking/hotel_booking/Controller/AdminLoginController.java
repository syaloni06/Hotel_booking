package com.hotel_booking.hotel_booking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_booking.hotel_booking.Entities.AdminLogin;
import com.hotel_booking.hotel_booking.Services.AdminLoginService;

@RestController
@RequestMapping("/api/admin_login")
public class AdminLoginController {
	
	@Autowired
	AdminLoginService adminLoginService;
	
	@PostMapping("/signup")
	public String createAdminAccount(@RequestBody AdminLogin adminLogin) {
		return adminLoginService.signup(adminLogin);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody AdminLogin adminLogin) {
		return adminLoginService.login(adminLogin.getAdmin_email_id(),adminLogin.getPassword());
	}
	
}
