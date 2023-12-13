package com.hotel_booking.hotel_booking.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel_booking.hotel_booking.Entities.Booking;
import com.hotel_booking.hotel_booking.Entities.Hotel;
import com.hotel_booking.hotel_booking.Entities.User;
import com.hotel_booking.hotel_booking.Repositories.BookingRepository;
import com.hotel_booking.hotel_booking.Repositories.HotelRepository;
import com.hotel_booking.hotel_booking.Repositories.UserRepository;
import com.hotel_booking.hotel_booking.Services.HotelService;
@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired 
	BookingRepository bookingRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override //to create the hotel table
	public Hotel createHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override //to find the details of hotel
	public List<Hotel> getHotel() {
		return hotelRepository.findAll();
	}

	@Override // to find the details of hotel by id
	public Hotel findById(Long id) {
		return hotelRepository.findById(id).get();
	}

	@Override // to update the details of hotel by id
	public Hotel updateHotel(Long id, Hotel hotel) {
		Hotel h = hotelRepository.findById(id).get();
		h.setHotel_name(hotel.getHotel_name());
		h.setLocation(hotel.getLocation());
		h.setContact_no(hotel.getContact_no());
		h.setTotal_no_of_rooms(hotel.getTotal_no_of_rooms());
		h.setPrice(hotel.getPrice());
		return hotelRepository.save(h);
	}

	@Override // to delete the hotel details by id
	public String deleteHotel(Long id) {
		hotelRepository.deleteById(id);
		return "Your record has been deleted!";
	}

	@Override // to book hotel for user
	public String HotelBooking(User user) {
		List<Booking> booking = user.getBooking();
		Long d = user.getUser_id();
		Double sum = 0.00;
		for(Booking i: booking) {
			Hotel h = hotelRepository.findById(i.getHotel_id()).get();
			User u = userRepository.findById(d).get();
			int no_of_days = i.getCheckout_date().getDayOfMonth()-i.getCheckin_date().getDayOfMonth()+1;
			i.setUser(u);
			try {
				if(h.getTotal_no_of_rooms()<i.getNo_of_rooms()) {
					throw new RuntimeException("Insufficient stock for product: " + h.getHotel_name());
				}
//				sum += i.getNo_of_rooms()*h.getPrice();
				i.setTotal_price(i.getNo_of_rooms()*h.getPrice()*no_of_days);
				sum += i.getTotal_price();
				bookingRepository.save(i);
				h.setTotal_no_of_rooms(h.getTotal_no_of_rooms()-i.getNo_of_rooms());
				hotelRepository.save(h);

			}
			catch(RuntimeException e) {
				e.getMessage();
			}
		}
		user.setTotal_bill(sum);
		userRepository.save(user);
		return "Your booking is successful";
	}

	@Override // to show the booking details of the user
	public List<Booking> showBookingDetailsofUser(Long user_id) {
		User user = userRepository.findById(user_id).get();
		List<Booking> booking = user.getBooking();
		return booking;
		
	}

}
