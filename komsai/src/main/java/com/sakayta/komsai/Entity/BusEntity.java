package com.sakayta.komsai.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BusEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busId;
	private int busNumber;
	private int busSeats;
	private String busCompany;
	
	public int getBusId() {
		return busId;
	}
	public int getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}
	public int getBusSeats() {
		return busSeats;
	}
	public void setBusSeats(int busSeats) {
		this.busSeats = busSeats;
	}
	public String getBusCompany() {
		return busCompany;
	}
	public void setBusCompany(String busCompany) {
		this.busCompany = busCompany;
	}
}
