package com.sakayta.komsai.Service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakayta.komsai.Entity.PassengerEntity;
import com.sakayta.komsai.Repository.PassengerRepository;

@Service
public class PassengerService {
	@Autowired
	PassengerRepository prepo;
	
	@Autowired
	EntityManager entityManager;
	
	//Check if user already exists
	public boolean UserExists(String userName) {
		PassengerEntity passenger = prepo.findByUsername(userName);
		if(passenger == null) {
			return false;
		}
		return true;
	}
	
	//Create
	public PassengerEntity insertPassenger(PassengerEntity passenger) {
		return prepo.save(passenger);
	}
	
	//Read
	public List<PassengerEntity> getAllPassenger(boolean isDeleted){
		Session session = entityManager.unwrap(Session.class);
		Filter filter = session.enableFilter("deletedPassengerFilter");
		filter.setParameter("isDeleted", isDeleted);
		List<PassengerEntity> allPassengers = prepo.findAll();
		session.disableFilter("deletedPassengerFilter");
		return allPassengers;
	}
	
	public PassengerEntity findByUsername(String userName) {
		if(prepo.findByUsername(userName) != null) {
			return prepo.findByUsername(userName);
		}else {
			return null;
		}
	}
	
	
	//Update
	public PassengerEntity putPassenger(int passengerId, PassengerEntity newPassengerDetails) throws Exception{
		PassengerEntity passenger = new PassengerEntity();
		
		try {
			passenger = prepo.findById(passengerId).get();
			passenger.setFirstName(newPassengerDetails.getFirstName());
			passenger.setLastName(newPassengerDetails.getLastName());
			passenger.setUsername(newPassengerDetails.getUsername());
			passenger.setPassword(newPassengerDetails.getPassword());
			
			return prepo.save(passenger);
		
		}catch(NoSuchElementException nex) {
			throw new Exception("ID number "+ passengerId +" does not exist!");
		}
	}
	
	//Delete
	//Not final yet!
	public String deletePassenger(int passengerId) {
		String msg;
		if(prepo.findById(passengerId) != null) {
			prepo.deleteById(passengerId);
			msg = "Passenger ID Number "+ passengerId +" is successfully deleted!";
		}else {
			msg = "Passenger ID Number "+ passengerId +" is NOT found!";
		}
		return msg;
	}

}
