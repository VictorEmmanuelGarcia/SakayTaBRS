package com.sakayta.komsai.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_schedule")
public class ScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scheduleId;
	
	@ManyToMany
	private int busId;
	
	private String startLocation;
	private String endDestination;
	private String departureTime;
	private String arrivalTime;
	private Date scheduleDate;
	
	
	public ScheduleEntity() {}
	
 	public ScheduleEntity(int scheduleId, int busId, String startLocation, String endDestination, String departureTime,
			String arrivalTime, Date scheduleDate) {
		super();
		this.scheduleId = scheduleId;
		this.busId = busId;
		this.startLocation = startLocation;
		this.endDestination = endDestination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.scheduleDate = scheduleDate;
	}

	public int getScheduleId() {
		return scheduleId;
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
}
