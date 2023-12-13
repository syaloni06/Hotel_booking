package com.hotel_booking.hotel_booking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel_booking.hotel_booking.Entities.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long>{

}
