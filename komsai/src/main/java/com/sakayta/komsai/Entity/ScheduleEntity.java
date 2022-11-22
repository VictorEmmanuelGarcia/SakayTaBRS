package com.sakayta.komsai.Entity;

import java.util.Date;

public class ScheduleEntity {

	private int scheduleId;
	private int busId;
	private String startLocation;
	private String busDestination;
	private String departureTime;
	private String arrivalTime;
	private Date scheduleDate;
	
	
	public ScheduleEntity() {}
	
 	public ScheduleEntity(int scheduleId, int busId, String startLocation, String busDestination, String departureTime,
			String arrivalTime, Date scheduleDate) {
		super();
		this.scheduleId = scheduleId;
		this.busId = busId;
		this.startLocation = startLocation;
		this.busDestination = busDestination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.scheduleDate = scheduleDate;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getBusDestination() {
		return busDestination;
	}

	public void setBusDestination(String busDestination) {
		this.busDestination = busDestination;
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
}
