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
	
	//Create
	public PassengerEntity insertPassenger(PassengerEntity passenger) {
		return prepo.save(passenger);
	}
	
	//Read
	public List<PassengerEntity> getAllPassenger(){
		return prepo.findAll();
	}
	
	public PassengerEntity findByUsername(String userN) {
		if(prepo.findByUserName(userN) != null) {
			return prepo.findByUserName(userN);
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
	public String deleteStudent(int id) {
		String msg;
		if(prepo.findById(id) != null) {
			prepo.deleteById(id);
			msg = "Passenger ID Number "+ id +" is successfully deleted!";
		}else {
			msg = "Passenger ID Number "+ id +" is NOT found!";
		}
		return msg;
	}

}
