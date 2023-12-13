package com.hotel_booking.hotel_booking.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel_booking.hotel_booking.Entities.Booking;
import com.hotel_booking.hotel_booking.Repositories.BookingRepository;
import com.hotel_booking.hotel_booking.Services.BookingService;
@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository bookingRepository;

	@Override // to create the booking table
	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override // to find the booking details
	public List<Booking> getBooking() {
		return bookingRepository.findAll();
	}

	@Override // to find the booking details by id
	public Booking findById(Long booking_id) {
		return bookingRepository.findById(booking_id).get();
	}

	@Override // to update the booking details by id
	public Booking updateBooking(Long booking_id, Booking booking) {
		Booking b = bookingRepository.findById(booking_id).get();
		b.setNo_of_rooms(booking.getNo_of_rooms());
		b.setCheckin_date(booking.getCheckin_date());
		b.setCheckout_date(booking.getCheckout_date());
		b.setTotal_price(booking.getTotal_price());
		return bookingRepository.save(b);
	}

	@Override // to delete the booking details by id
	public String deleteBooking(Long booking_id) {
		bookingRepository.deleteById(booking_id);
		return "Your record has been deleted";
	}

//	@Override
//	public String assignBookingToHotel(Long hotel_id, Long booking_id) {
//		Booking b = bookingRepository.findById(booking_id).get();
//		Hotel h = hotelRepository.findById(hotel_id).get();
//		b.setHotel(h);
//		bookingRepository.save(b);
//		return "Your hotel has been booked";
//	}
//
//	@Override
//	public String assignBookingToUser(Long user_id, Long booking_id) {
//		Booking b = bookingRepository.findById(booking_id).get();
//		User u = userRepository.findById(user_id).get();
//		b.setUser(u);
//		bookingRepository.save(b);
//		return "Your booking has been done";
//	}

	
}
