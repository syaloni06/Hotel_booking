package com.hotel_booking.hotel_booking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel_booking.hotel_booking.Entities.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin,String>{
	 
}
