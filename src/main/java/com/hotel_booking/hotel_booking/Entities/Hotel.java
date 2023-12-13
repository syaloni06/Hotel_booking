package com.hotel_booking.hotel_booking.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hotel")
public class Hotel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String hotel_name;
	private String location;
	private String contact_no;
	private Long total_no_of_rooms;
	private Double price;
	
//	@OneToMany(mappedBy="hotel")
//	List<User> user;

}
