package com.sakayta.komsai.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakayta.komsai.Entity.TicketEntity;
import com.sakayta.komsai.Repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	TicketRepository ticketrepo;
	
	public TicketEntity insertTicket(TicketEntity reservation) {
		return ticketrepo.save(reservation);
	}
	
	public List<TicketEntity> getAllTickets(){
		return ticketrepo.findAll();
	}
	
	public TicketEntity findByTicketType(String ticketType) {
		if(ticketrepo.findByTicketType(ticketType)!=null) {
			return ticketrepo.findByTicketType(ticketType);
		}
		else {
			return null;
		}
	}
	
	public TicketEntity putTicket(int ticketId , TicketEntity newTicketDetails) throws Exception{
		
		TicketEntity ticket = new TicketEntity();
		
		try {
			ticket = ticketrepo.findById(ticketId).get();
			
			ticket.setTicketType(newTicketDetails.getTicketType());
			
			return ticketrepo.save(ticket);
		}catch(NoSuchElementException next) {
			throw new Exception ("Ticket Id " + ticketId + "does not exist!");		
		}
	}
	
	public String deleteTicket(int ticketId) {
		String msg;
		if(ticketrepo.findById(ticketId) != null) {
			ticketrepo.deleteById(ticketId);	
			msg = "Ticket Id " + ticketId + " is succesfully deleted!";
		} else {
			msg = "Ticket Id " + ticketId + " is NOT found!";
		}
		return msg;
	}
}
