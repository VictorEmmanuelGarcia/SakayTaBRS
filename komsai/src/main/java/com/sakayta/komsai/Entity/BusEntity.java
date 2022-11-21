package com.sakayta.komsai.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BusEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busid;
	private int busnumber;
	private int busseats;
	private String buscompany;
	
	public int getBusId() {
		return busid;
	}
	public int getBusNumber() {
		return busnumber;
	}
	public void setBusNumber(int busnumber) {
		this.busnumber = busnumber;
	}
	public int getBusSeats() {
		return busseats;
	}
	public void setBusSeats(int busseats) {
		this.busseats = busseats;
	}
	public String getBusCompany() {
		return buscompany;
	}
	public void setBusCompany(String buscompany) {
		this.buscompany = buscompany;
	}
}
