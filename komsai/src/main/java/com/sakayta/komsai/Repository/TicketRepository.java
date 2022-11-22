package com.sakayta.komsai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakayta.komsai.Entity.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer>{

		TicketEntity findByTicketType(String ticketType);
}
