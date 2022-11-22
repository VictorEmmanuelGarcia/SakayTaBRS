package com.sakayta.komsai.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakayta.komsai.Entity.PassengerEntity;
import com.sakayta.komsai.Entity.PaymentEntity;
import com.sakayta.komsai.Entity.ReservationEntity;
import com.sakayta.komsai.Repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository prepo;
	
	///Create or insert a record
	public PaymentEntity insertPayment(PaymentEntity payment) {
		return prepo.save(payment);
	}
	
	//Read a record
	public List<PaymentEntity> getAllPayments(){
		return prepo.findAll();
	}
	
	//Read or search record
	/*public List<PaymentEntity> findAllByPassengerId(int passengerId) {
		if(prepo.findAllByPassengerId(passengerId)!= null)
			return prepo.findAllByPassengerId(passengerId);
		else
			return null;
	}*/
	
	public PaymentEntity putPayment(int paymentId , PaymentEntity newPaymentDetails) throws Exception{
		
		PaymentEntity payment = new PaymentEntity();
		
		try {
			//Steps in updating
			//Step 1 - Search the payment id
			payment = prepo.findById(paymentId).get(); //findById is a predefined method
			
			//Step 2 - Update the record
			payment.setAmount(newPaymentDetails.getAmount());
			payment.setModeOfPayment(newPaymentDetails.getModeOfPayment());
			
			//Step 3 - Save the information and return the value
			return prepo.save(payment);
		}catch(NoSuchElementException next) {
			throw new Exception ("Payment Id " + paymentId + "does not exist!");		
		}
	}
	//D - Delete a reservation
	public String deletePayment(int paymentId) {
		String msg;
		if(prepo.findById(paymentId) != null) {	//Step 1 - find the record
			prepo.deleteById(paymentId);			//Step 2 - delete the record
			msg = "Payment Id " + paymentId + " is succesfully deleted!";
		} else {
			msg = "Payment Id " + paymentId + " is NOT found!";
		}
		return msg;
	}
}
