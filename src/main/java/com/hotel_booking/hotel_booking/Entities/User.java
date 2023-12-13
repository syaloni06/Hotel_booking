package com.hotel_booking.hotel_booking.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long user_id;
	private String user_name;
	private String address;
	private String identityProof;
	private Double total_bill;
	
//	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private Hotel hotel;
//	@OneToOne(mappedBy="user")
//	private UserLogin userLogin;
	
	@OneToMany(mappedBy="user")
	@JsonManagedReference
	List<Booking> booking;
}
