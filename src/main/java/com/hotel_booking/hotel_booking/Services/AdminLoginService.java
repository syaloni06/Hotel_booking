package com.hotel_booking.hotel_booking.Services;

import com.hotel_booking.hotel_booking.Entities.AdminLogin;

public interface AdminLoginService {
	public String signup(AdminLogin adminLogin);
	public String login(String admin_email_id, String password);

}
