package com.hotel_booking.hotel_booking.ServiceImpl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel_booking.hotel_booking.Entities.AdminLogin;
import com.hotel_booking.hotel_booking.Repositories.AdminLoginRepository;
import com.hotel_booking.hotel_booking.Services.AdminLoginService;
@Service
public class AdminLoginServiceImpl implements AdminLoginService{
	
	@Autowired
	AdminLoginRepository adminLoginRepository;

	@Override // to create admin account table
	public String signup(AdminLogin adminLogin) {
		adminLoginRepository.save(adminLogin);
		return "Your accont have been created";
	}

	@Override // to check the login credentials
	public String checkLogin(String admin_email_id, String password) {
		try {
			AdminLogin al = adminLoginRepository.findById(admin_email_id).get();
			if(password.equals(al.getPassword())) {
				return "You have logged in successfully.";
			}
			else {
				return "Incorrect Password";
			}
		}
		catch(NoSuchElementException e) {
			e.getMessage();
		}
		return "Incorrect user_id, Please register Yourself";
	}

	@Override
	public String login(String query) {
		AdminLogin adminLogin = adminLoginRepository.login(query);
		return "You are welcome";
	}

}
