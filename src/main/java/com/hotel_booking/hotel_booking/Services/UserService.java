package com.hotel_booking.hotel_booking.Services;

import java.util.List;

import com.hotel_booking.hotel_booking.Entities.User;

public interface UserService {
	User createUser(User user);
	List<User> getUser();
	User findById(Long id);
	User updateUser(Long id, User user);
	String deleteUser(Long id);
//	String assignUserToHotel(Long hotel_id, Long user_id);
}
