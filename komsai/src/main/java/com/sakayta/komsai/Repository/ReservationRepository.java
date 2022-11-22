package com.sakayta.komsai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sakayta.komsai.Entity.ReservationEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer>{
	
	//di pa sure
	ReservationEntity findByPassengerId(int passengerId);
}
