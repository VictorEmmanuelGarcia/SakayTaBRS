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
	public PassengerEntity insertPassenger(@RequestBody PassengerEntity passenger) {
		return pservice.insertPassenger(passenger);
	}
	
	@GetMapping("/getUsername")
	public PassengerEntity findByUsername(@RequestParam String username) {
		return pservice.findByUsername(username);
	}
	
	@GetMapping("/getAllPassenger")
	public List<PassengerEntity> getAllPassenger(){
		return pservice.getAllPassenger();
	}
	
	@PutMapping("/putPassenger")
	public PassengerEntity putCourse(@RequestParam int passengerid, @RequestBody PassengerEntity newPassengerEntity) throws Exception{
		return pservice.putPassenger(passengerid, newPassengerEntity);
	}
	
	@DeleteMapping("/deletePassenger/{passengerid}")
	public String deleteCourse(@PathVariable int passengerid) {
		return pservice.deletePassenger(passengerid);
	}

}
