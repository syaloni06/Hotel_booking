package com.hotel_booking.hotel_booking.ServiceImpl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel_booking.hotel_booking.Entities.UserLogin;
import com.hotel_booking.hotel_booking.Repositories.UserLoginRepository;
import com.hotel_booking.hotel_booking.Services.UserLoginService;
@Service
public class UserLoginServiceImpl implements UserLoginService{
	
	@Autowired
	UserLoginRepository userLoginRepository;

	@Override // to create the user account table
	public String signup(UserLogin userLogin) {
		userLoginRepository.save(userLogin);
		return "Your accont have been created";
	}

	@Override // to check the login credentials
	public String login(String email_id, String password) {
		
		try {
			UserLogin ul = userLoginRepository.findById(email_id).get();
			if(password.equals(ul.getPassword())) {
				return "You have logged in successfully.";
			}
			else {
				return "Incorrect Password";
			}	
		}
			catch(NoSuchElementException e){
				e.getMessage();
			}
			
		return "Incorrect user_id, Please register Yourself";
	}



}
