package com.sakayta.komsai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakayta.komsai.Entity.PassengerEntity;

public interface PassengerRepository extends JpaRepository<PassengerEntity, Integer> {
	PassengerEntity findByUserName(String userN);
	}
