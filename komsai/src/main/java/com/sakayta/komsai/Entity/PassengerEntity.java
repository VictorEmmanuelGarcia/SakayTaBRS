package com.sakayta.komsai.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "passenger_entity")
public class PassengerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passengerId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String address;
	private int points;
	
	@OneToMany(cascade = CascadeType.MERGE)
	private Set<ReservationEntity> reservation;
	
	public PassengerEntity() {}
	
	public PassengerEntity(int passengerId, String firstName, String lastName, String userName, String passWord,
			String address, int points, Set<ReservationEntity> reservation) {
		super();
		this.passengerId = passengerId;
		this.firstname = firstName;
		this.lastname = lastName;
		this.username = userName;
		this.password = passWord;
		this.address = address;
		this.points = points;
		this.reservation = reservation;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public String getFirstName() {
		return firstname;
	}
	
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String userName) {
		this.username = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String passWord) {
		this.password = passWord;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
