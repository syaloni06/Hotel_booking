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
import com.hotel_booking.hotel_booking.Entities.Hotel;
import com.hotel_booking.hotel_booking.Entities.User;
import com.hotel_booking.hotel_booking.Services.HotelService;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@PostMapping("/create")
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return hotelService.createHotel(hotel);
	}
	
	@GetMapping("/show")
	public List<Hotel> getHotel(){
		return hotelService.getHotel();
	}
	
	@GetMapping("/find/{id}")
	public Hotel findById(@PathVariable Long id) {
		return hotelService.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
		return hotelService.updateHotel(id, hotel);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteHotel(@PathVariable Long id) {
		return hotelService.deleteHotel(id);
	}
	
	@PostMapping("/hotel_book")
	public String hotelBooking(@RequestBody User user) {
		return hotelService.HotelBooking(user);
	}
	
	@GetMapping("/booking_details_user/{user_id}")
	public List<Booking> showBookingDetailsofUser(@PathVariable Long user_id){
		return hotelService.showBookingDetailsofUser(user_id);
		
	}
}
