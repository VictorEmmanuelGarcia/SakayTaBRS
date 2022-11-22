package com.sakayta.komsai.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class ScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scheduleId;
	
	@ManyToMany
	private BusEntity bus;
	
	private String startLocation;
	private String endDestination;
	private String departureTime;
	private String arrivalTime;
	private Date scheduleDate;
	
	
	public ScheduleEntity() {}


	public ScheduleEntity(int scheduleId, BusEntity bus, String startLocation, String endDestination,
			String departureTime, String arrivalTime, Date scheduleDate) {
		super();
		this.scheduleId = scheduleId;
		this.bus = bus;
		this.startLocation = startLocation;
		this.endDestination = endDestination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.scheduleDate = scheduleDate;
	}


	public int getScheduleId() {
		return scheduleId;
	}


	public BusEntity getBus() {
		return bus;
	}


	public void setBus(BusEntity bus) {
		this.bus = bus;
	}


	public String getStartLocation() {
		return startLocation;
	}


	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}


	public String getEndDestination() {
		return endDestination;
	}


	public void setEndDestination(String endDestination) {
		this.endDestination = endDestination;
	}


	public String getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public Date getScheduleDate() {
		return scheduleDate;
	}


	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
	public String getStartEndDestination() {
		return startLocation +" "+ endDestination;
	}
	

}
