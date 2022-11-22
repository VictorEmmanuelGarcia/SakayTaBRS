package com.sakayta.komsai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sakayta.komsai.Entity.PaymentEntity;
import com.sakayta.komsai.Entity.ReservationEntity;
import com.sakayta.komsai.Entity.ScheduleEntity;
import com.sakayta.komsai.Service.PaymentService;
import com.sakayta.komsai.Service.ScheduleService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService pserv;
	
	// Creates a payment
	@PostMapping("/postPayment")
	public PaymentEntity createSchedule(@RequestBody PaymentEntity payment) {
		return pserv.insertPayment(payment);
	}
	
	// Read all payments
	@GetMapping("/getAllPayments")
	public List <PaymentEntity> getAllPayments() {
		return pserv.getAllPayments();
	}
	//Update a payment
	@PutMapping("/putPayment")
	public PaymentEntity putPayment(@RequestParam int id, @RequestBody PaymentEntity newPaymentDetails) throws Exception {
		return pserv.putPayment(id, newPaymentDetails);
	}
	//Delete a payment
	@DeleteMapping("/deletePayment/{id}")
	public String deletePayment(@PathVariable int id) {
		return pserv.deletePayment(id);
	}
}
