package com.hotel_booking.hotel_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_booking.hotel_booking.Entities.Booking;
import com.hotel_booking.hotel_booking.Services.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/create")
	public Booking createBooking(@RequestBody Booking booking) {
		return bookingService.createBooking(booking);
	}
	
	@GetMapping("/show")
	public List<Booking> getBooking(){
		return bookingService.getBooking();
	}
	
	@GetMapping("/find/{booking_id}")
	public Booking findById(@PathVariable Long booking_id) {
		return bookingService.findById(booking_id);
	}
	
	@PutMapping("/update/{booking_id}")
	public Booking updateBooking(@PathVariable Long booking_id, @RequestBody Booking booking) {
		return bookingService.updateBooking(booking_id, booking);
	}
	
	@DeleteMapping("/delete/{booking_id}")
	public String deleteBooking(@PathVariable Long booking_id) {
		return bookingService.deleteBooking(booking_id);
	}
	
//	@PostMapping("assign_hotel/{hotel_id}/{booking_id}")
//	public String assignBookingToHotel(@PathVariable Long hotel_id, @PathVariable Long booking_id) {
//		return bookingService.assignBookingToHotel(hotel_id, booking_id);
//	}
//	
//	@PostMapping("assign_user/{user_id}/{booking_id}")
//	public String assignBookingToUser(@PathVariable Long user_id, @PathVariable Long booking_id) {
//		return bookingService.assignBookingToUser(user_id, booking_id);
//	}
	
}
