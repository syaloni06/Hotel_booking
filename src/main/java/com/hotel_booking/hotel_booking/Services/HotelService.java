package com.hotel_booking.hotel_booking.Services;

import java.util.List;

import com.hotel_booking.hotel_booking.Entities.Booking;
import com.hotel_booking.hotel_booking.Entities.Hotel;
import com.hotel_booking.hotel_booking.Entities.User;

public interface HotelService {
	Hotel createHotel(Hotel hotel);
	List<Hotel> getHotel();
	Hotel findById(Long id);
	Hotel updateHotel(Long id, Hotel hotel);
	String deleteHotel(Long id);
	String HotelBooking(User user);
	List<Booking> showBookingDetailsofUser(Long user_id);
}
