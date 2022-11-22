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

import com.sakayta.komsai.Entity.TicketEntity;
import com.sakayta.komsai.Service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	TicketService ticketserv;
	
	@GetMapping("/print")
	public String printTicketInfo() {
		return "Ticket Information";
	}
	
	@PostMapping("/postTicket")
	public TicketEntity insertTicket(@RequestBody TicketEntity ticket) {
		return ticketserv.insertTicket(ticket);
	}
	
	@GetMapping("/getAllTickets")
	public List<TicketEntity> getAllTickets(){
		return ticketserv.getAllTickets();
	}
	
	@GetMapping("/getByTicketType")
	public TicketEntity findByTicketType(@RequestParam String ticketType) {
		return ticketserv.findByTicketType(ticketType);
	}
	
	@PutMapping("/putTicket")
	public TicketEntity putTicket(@RequestParam int id, @RequestBody TicketEntity newTicketDetails) throws Exception {
		return ticketserv.putTicket(id, newTicketDetails);
	}
	
	@DeleteMapping("/deleteTicket/{id}")
	public String deleteReservation(@PathVariable int id) {
		return ticketserv.deleteTicket(id);
	}
}