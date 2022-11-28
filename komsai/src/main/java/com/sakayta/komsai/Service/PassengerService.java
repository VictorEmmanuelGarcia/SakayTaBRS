package com.sakayta.komsai.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakayta.komsai.Entity.PassengerEntity;
import com.sakayta.komsai.Repository.PassengerRepository;

@Service
public class PassengerService {
	@Autowired
	PassengerRepository prepo;
	
	//Check if user already exists
	public boolean UserExists(String username) {
		PassengerEntity passenger = prepo.findByUsername(username);
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
	public List<PassengerEntity> getAllPassenger(){
		return prepo.findAll();
	}
	
	public PassengerEntity findByUsername(String username) {
		if(prepo.findByUsername(username) != null) {
			return prepo.findByUsername(username);
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
			passenger.setUserName(newPassengerDetails.getUserName());
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
