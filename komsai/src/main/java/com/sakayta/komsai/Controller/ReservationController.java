package com.sakayta.komsai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sakayta.komsai.Entity.ReservationEntity;
import com.sakayta.komsai.Service.ReservationService;


@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reserveserv;
	
	@GetMapping("/print")
	public String printResInfo() {
		return "Reservation Information";
	}
	
	//Create or insert a reservation
	@PostMapping("/postReservation")
	public ReservationEntity insertReservation(@RequestBody ReservationEntity reservation) {
		return reserveserv.insertReservation(reservation);
	}
	
	//Read all reservation
	@GetMapping("/getAllReservations")
	public List<ReservationEntity> getAllReservations(){
		return reserveserv.getAllReservations();
	}
	
	//Read a reservation by passenger Id
	@GetMapping("/getByScheduleId")
	public ReservationEntity findByPassengerId(@RequestParam int passengerId) {
		return reserveserv.findByPassengerId(passengerId);
	}
	
	//Update a reservation
	@PutMapping("/putReservation")
	public ReservationEntity putReservation(@RequestParam int id, @RequestBody ReservationEntity newReservationDetails) throws Exception {
		return reserveserv.putReservation(id, newReservationDetails);
	}
	
	//Delete a reservation
	@DeleteMapping("/deleteReservation/{id}")
	public String deleteReservation(@PathVariable int id) {
		return reserveserv.deleteReservation(id);
	}
}
