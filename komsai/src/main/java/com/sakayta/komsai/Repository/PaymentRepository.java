package com.sakayta.komsai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sakayta.komsai.Entity.PassengerEntity;
import com.sakayta.komsai.Entity.PaymentEntity;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer>{
	/*@Query( "SELECT pay FROM passenger_entity pass join pass.payment_entity pg WHERE pass.passenger_id = :passenger_id")
	List<PaymentEntity> findAllByPassengerId(int passengerId);*/
}
