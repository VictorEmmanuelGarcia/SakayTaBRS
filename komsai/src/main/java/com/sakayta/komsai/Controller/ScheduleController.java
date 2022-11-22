package com.sakayta.komsai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakayta.komsai.Entity.ScheduleEntity;
import com.sakayta.komsai.Service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService schedService;
	
	// Create
	@PostMapping("/postSchedule")
	public ScheduleEntity createSchedule(@RequestBody ScheduleEntity schedule) {
		return schedService.createSchedule(schedule);
	}
	
	// Read
	@GetMapping("/getAllSchedules")
	public List <ScheduleEntity> getAllSchedules() {
		return schedService.getAllSchedules();
	}
	
	
	// Update
	
	// Delete
	
}
