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
	
	
}
