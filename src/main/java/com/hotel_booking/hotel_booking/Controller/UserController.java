package com.hotel_booking.hotel_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_booking.hotel_booking.Entities.User;
import com.hotel_booking.hotel_booking.Services.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/show")
	public List<User> getUser(){
		return userService.getUser();
	}
	
	@GetMapping("/find/{id}")
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
	
//	@PostMapping("assign_hotel/{hotel_id}/{user_id}")
//	public String assignBookingToHotel(@PathVariable Long hotel_id, @PathVariable Long user_id) {
//		return userService.assignUserToHotel(hotel_id, user_id);
//	}
}
