package com.hotel_booking.hotel_booking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotel_booking.hotel_booking.Entities.AdminLogin;


public interface AdminLoginRepository extends JpaRepository<AdminLogin,String>{
	@Query(value="select * from user_login ul where ul.email =(:query)", nativeQuery=true)
	 AdminLogin login(String query);

}
