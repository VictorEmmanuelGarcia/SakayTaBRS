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
	private int busSeats;
	private String busCompany;
	private String numberCompanyBus;
	private String destination;
	
	public BusEntity() {}

	public BusEntity(int busId, int busSeats, String busCompany, String numberCompanyBus, String destination) {
		super();
		this.busId = busId;
		this.busSeats = busSeats;
		this.busCompany = busCompany;
		this.numberCompanyBus = numberCompanyBus;
		this.destination = destination;
	}

	public int getBusId() {
		return busId;
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
	
	public String getNumberCompanyBus() {
		return numberCompanyBus;
	}

	public void setNumberCompanyBus(String numberCompanyBus) {
		this.numberCompanyBus = numberCompanyBus;
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
