package com.hotel_booking.hotel_booking.Services;

import java.util.List;

import com.hotel_booking.hotel_booking.Entities.Booking;

public interface BookingService {
	Booking createBooking(Booking booking);
	List<Booking> getBooking();
	Booking findById(Long booking_id);
	Booking updateBooking(Long booking_id, Booking booking);
	String deleteBooking(Long booking_id);
//	String assignBookingToHotel(Long hotel_id, Long booking_id);
//	String assignBookingToUser(Long user_id, Long booking_id);
	
}
