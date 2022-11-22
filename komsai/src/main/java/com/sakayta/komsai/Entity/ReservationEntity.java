package com.sakayta.komsai.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation_entity")
public class ReservationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;
	
	private String reservationDate;
	
	@ManyToOne
	@JoinColumn(name="passengerId")
	PassengerEntity passenger;
	
	@ManyToOne
	@JoinColumn(name="scheduleId")
	ScheduleEntity schedule;
	
	public ReservationEntity(){}
	
	public ReservationEntity(int reservationId, PassengerEntity passenger, ScheduleEntity schedule, String reservationDate) {
		super();
		this.reservationId = reservationId;
		this.passenger = passenger;
		this.schedule = schedule;
		this.reservationDate = reservationDate;
	}

	public int getReservationId() {
		return reservationId;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public PassengerEntity getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengerEntity passenger) {
		this.passenger = passenger;
	}

	public ScheduleEntity getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleEntity schedule) {
		this.schedule = schedule;
	}
}
