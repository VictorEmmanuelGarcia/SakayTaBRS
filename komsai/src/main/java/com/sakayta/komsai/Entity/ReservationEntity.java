package com.sakayta.komsai.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation_entity")
public class ReservationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;
	private Date reservationDate;
	
	@ManyToOne
	private PassengerEntity passenger;
	
	/*@ManyToOne
	private ScheduleEntity schedule;*/
	
	public ReservationEntity(){}
	
	public ReservationEntity(int reservationId, Date reservationDate) {
		super();
		this.reservationId = reservationId;
		this.reservationDate = reservationDate;
	}
	
	public int getReservationId() {
		return reservationId;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
}
