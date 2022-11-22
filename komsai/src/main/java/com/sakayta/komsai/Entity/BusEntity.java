package com.sakayta.komsai.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus_entity")
public class BusEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busid;
	private int busSeats;
	private String busCompany;
	private String numberCompanyBus;
	private String destination;
	
	public BusEntity() {}

	public BusEntity(int busid, int busSeats, String busCompany, String numberCompanyBus, String destination) {
		super();
		this.busid = busid;
		this.busSeats = busSeats;
		this.busCompany = busCompany;
		this.numberCompanyBus = numberCompanyBus;
		this.destination = destination;
	}

	public int getBusid() {
		return busid;
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
