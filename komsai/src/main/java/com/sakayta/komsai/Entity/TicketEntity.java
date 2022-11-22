package com.sakayta.komsai.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TicketEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	private String ticketType;

	@OneToOne
	ReservationEntity reservation;
	
	//@OneToOne
	//PaymentEntity payment;
	
	public TicketEntity() {}

	public TicketEntity(int ticketId, String ticketType, ReservationEntity reservation) {
		super();
		this.ticketId = ticketId;
		this.ticketType = ticketType;
		this.reservation = reservation;
	}


	public int getTicketId() {
		return ticketId;
	}

	public ReservationEntity getReservation() {
		return reservation;
	}

	public void setReservation(ReservationEntity reservation) {
		this.reservation = reservation;
	}
	
	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
}
