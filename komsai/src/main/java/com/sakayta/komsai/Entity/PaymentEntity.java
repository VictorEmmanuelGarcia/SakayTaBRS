package com.sakayta.komsai.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private double amount;
	private String modeOfPayment;
	
	@ManyToOne
	private PassengerEntity passenger;
	
	@OneToOne
	private ReservationEntity reservation;
	
	public PaymentEntity() {}
	

	public PaymentEntity(int paymentId, double amount, String modeOfPayment, PassengerEntity passenger,
			ReservationEntity reservation) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.modeOfPayment = modeOfPayment;
		this.passenger = passenger;
		this.reservation = reservation;
	}



	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public PassengerEntity getPassenger() {
		return passenger;
	}

	public ReservationEntity getReservation() {
		return reservation;
	}
	
	
}
