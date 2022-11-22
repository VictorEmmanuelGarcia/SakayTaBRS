package com.sakayta.komsai.Controller;

import java.util.Date;
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

import com.sakayta.komsai.Entity.ScheduleEntity;
import com.sakayta.komsai.Service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService schedService;
	
	// Creates a schedule
	@PostMapping("/postSchedule")
	public ScheduleEntity createSchedule(@RequestBody ScheduleEntity schedule) {
		return schedService.createSchedule(schedule);
	}
	
	// Reads a schedule(s)
	@GetMapping("/getAllSchedules")
	public List <ScheduleEntity> getAllSchedules() {
		return schedService.getAllSchedules();
	}
	
	@GetMapping("/getScheduleByDate")
	public ScheduleEntity getScheduleByDate(Date date) {
		return schedService.findByScheduleDate(date);
	}
	
	@GetMapping("/getScheduleByEndDestination")
	public ScheduleEntity getScheduleByEndDestination(String endDestination) {
		return schedService.findByEndDestination(endDestination);
	}
	
	// Updates an existing schedule
	@PutMapping("/putSchedule")
	public ScheduleEntity updateSchedule(@RequestParam int scheduleId, @RequestBody ScheduleEntity newScheduleDetails) throws Exception {
		return schedService.updateSchedule(scheduleId, newScheduleDetails);
	}
	
	// Deletes an existing schedule
	@DeleteMapping("/deleteSchedule/{id}")
	public String deleteSchedule(@PathVariable int id) {
		return schedService.deleteSchedule(id);
	}
}
