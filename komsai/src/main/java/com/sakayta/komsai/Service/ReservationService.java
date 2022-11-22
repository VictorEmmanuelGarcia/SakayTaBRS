package com.sakayta.komsai.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakayta.komsai.Entity.ReservationEntity;
import com.sakayta.komsai.Repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	ReservationRepository reserverepo;
	
	//C - Create or insert a reservation
	public ReservationEntity insertReservation(ReservationEntity reservation) {
		return reserverepo.save(reservation);
	}
	
	//R - Read all records from tbl_
	public List<ReservationEntity> getAllReservations(){
		return reserverepo.findAll();
	}
	
	//R - Read or search a reservation by passenger Id
	public ReservationEntity findByPassengerId(int passengerId) {
		if(reserverepo.findByPassengerId(passengerId)!=null) {
			return reserverepo.findByPassengerId(passengerId);
		}
		else {
			return null;
		}
	}
	
	//U - Update a reservation
	public ReservationEntity putReservation(int reservationId , ReservationEntity newReservationDetails) throws Exception{
		
		ReservationEntity reservation = new ReservationEntity();
		
		try {
			//Steps in updating
			//Step 1 - Search the reservation id
			reservation = reserverepo.findById(reservationId).get(); //findById is a predefined method
			
			//Step 2 - Update the record
			reservation.setReservationDate(newReservationDetails.getReservationDate());
			
			//Step 3 - Save the information and return the value
			return reserverepo.save(reservation);
		}catch(NoSuchElementException next) {
			throw new Exception ("Reservation Id " + reservationId + "does not exist!");		
		}
	}
	
	//D - Delete a reservation
	public String deleteReservation(int reservationId) {
		String msg;
		if(reserverepo.findById(reservationId) != null) {	//Step 1 - find the record
			reserverepo.deleteById(reservationId);			//Step 2 - delete the record
			msg = "Reservation Id " + reservationId + " is succesfully deleted!";
		} else {
			msg = "Reservation Id " + reservationId + " is NOT found!";
		}
		return msg;
	}
}
