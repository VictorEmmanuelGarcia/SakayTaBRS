package com.sakayta.komsai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sakayta.komsai.Entity.PassengerEntity;
import com.sakayta.komsai.Service.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
	@Autowired
	PassengerService pservice;
	
	@PostMapping("/postPassenger")
	public PassengerEntity insertPassenger(@RequestBody PassengerEntity passenger) throws Exception{
		if(pservice.UserExists(passenger.getUsername())){
			throw new Exception("Username already taken");
		}
		return pservice.insertPassenger(passenger);
	}
	
	@GetMapping("/getUsername")
	public PassengerEntity findByUsername(@RequestParam String username) {
		return pservice.findByUsername(username);
	}
	
	@GetMapping("/getAllPassenger")
	public List<PassengerEntity> getAllPassenger(@RequestParam(value = "isDeleted", required = false, defaultValue= "false") boolean isDeleted){
		return pservice.getAllPassenger(isDeleted);
	}
	
	@PutMapping("/putPassenger/{passengerId}")
	public PassengerEntity putCourse(@PathVariable int passengerId, @RequestBody PassengerEntity newPassengerEntity) throws Exception{
		return pservice.putPassenger(passengerId, newPassengerEntity);
	}
	
	@DeleteMapping("/deletePassenger/{passengerId}")
	public String deletePassenger(@PathVariable int passengerId) {
		return pservice.deletePassenger(passengerId);
	}

}
