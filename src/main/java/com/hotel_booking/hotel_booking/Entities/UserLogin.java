package com.hotel_booking.hotel_booking.Entities;



import jakarta.persistence.Entity;
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
@Table(name="user_login")
public class UserLogin {
	@Id
	private String email_id;
	private String password;
	
//	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private User user;
}
