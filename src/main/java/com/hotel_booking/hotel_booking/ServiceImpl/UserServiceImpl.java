package com.hotel_booking.hotel_booking.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel_booking.hotel_booking.Entities.User;
import com.hotel_booking.hotel_booking.Repositories.HotelRepository;
import com.hotel_booking.hotel_booking.Repositories.UserRepository;
import com.hotel_booking.hotel_booking.Services.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	HotelRepository hotelRepository;

	@Override // to create the user table
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override // to find the details of user
	public List<User> getUser() {
		return userRepository.findAll();
	}

	@Override // to find the details of user by id
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override // to update the details of user by id
	public User updateUser(Long id, User user) {
		User u = userRepository.findById(id).get();
		u.setUser_name(user.getUser_name());
		u.setAddress(user.getAddress());
		u.setIdentityProof(user.getIdentityProof());
		return userRepository.save(u);
	}

	@Override // to delete the hotel details by id
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "Your record has been deleted!";
	}

//	@Override
//	public String assignUserToHotel(Long hotel_id, Long user_id) {
//		User u = userRepository.findById(user_id).get();
//		Hotel h = hotelRepository.findById(hotel_id).get();
//		u.setHotel(h);
//		userRepository.save(u);
//		return "Your hotel has been booked";
//	}
	

}
