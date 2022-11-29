package com.sakayta.komsai.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "passenger_entity")
@SQLDelete(sql = "UPDATE passenger_entity SET deleted = true where passengerId=?")
@Where(clause = "deleted=false")
public class PassengerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passengerId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private boolean deleted = Boolean.FALSE;
	private double points;
	
	@OneToMany(cascade = CascadeType.MERGE)
	private Set<ReservationEntity> reservation;
	
	public PassengerEntity() {}
	
	public PassengerEntity(int passengerId, String firstName, String lastName, String username, String passWord,
			String address, double points, Set<ReservationEntity> reservation, boolean deleted) {
		super();
		this.passengerId = passengerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = passWord;
		this.address = address;
		this.points = points;
		this.reservation = reservation;
		this.setDeleted(deleted);
	}

	public int getPassengerId() {
		return passengerId;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double getPoints() {
		return points;
	}
	
	public void setPoints(double points) {
		this.points = points;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
}
