package com.hotel_booking.hotel_booking.Services;

import com.hotel_booking.hotel_booking.Entities.UserLogin;

public interface UserLoginService {
	public String signup(UserLogin userLogin);
	public String login(String email_id, String password);


}
