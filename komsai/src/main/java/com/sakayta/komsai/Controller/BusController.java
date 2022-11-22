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

import com.sakayta.komsai.Entity.BusEntity;
import com.sakayta.komsai.Service.BusService;

@RestController
@RequestMapping("/bus")
public class BusController {

	@Autowired
	BusService bservice;
	
	@PostMapping("/postBus")
	public BusEntity insertPassenger(@RequestBody BusEntity bus) {
		return bservice.insertBus(bus);
	}
	
	@GetMapping("/getByBusCompanyNumber")
	public BusEntity findByNumberCompanyBus(@RequestParam String numberCompanyBus) {
		return bservice.findByNumberCompanyBus(numberCompanyBus);
	}
	
	@GetMapping("/getByDestination")
	public BusEntity findByDestination(@RequestParam String destination) {
		return bservice.findByDestination(destination);
	}
	
	@GetMapping("/getAllBus")
	public List<BusEntity> getAllBus(){
		return bservice.getAllBus();
	}
	
	@PutMapping("/putBus")
	public BusEntity putCourse(@RequestParam int busId, @RequestBody BusEntity newBusEntity) throws Exception{
		return bservice.putBus(busId, newBusEntity);
	}
	
	@DeleteMapping("/deleteBus/{busId}")
	public String deleteCourse(@PathVariable int busId) {
		return bservice.deleteBus(busId);
	}
}
