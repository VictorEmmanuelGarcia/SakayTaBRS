package com.sakayta.komsai.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakayta.komsai.Entity.PassengerEntity;
import com.sakayta.komsai.Entity.ScheduleEntity;
import com.sakayta.komsai.Repository.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	ScheduleRepository schedRepository;
	
	//Create
	public ScheduleEntity createSchedule(ScheduleEntity schedule) {
		return schedRepository.save(schedule);
	}
	
	//Read
	public List<ScheduleEntity> getAllSchedules(){
		return schedRepository.findAll();
	}

	public ScheduleEntity findByScheduleDate(Date scheduleDate) {
		
		if(schedRepository.findByScheduleDate(scheduleDate) != null) 
			return schedRepository.findByScheduleDate(scheduleDate);
		else 
			return null;
	}
	public ScheduleEntity findByEndDestination(String endDestination) {
		
		if(schedRepository.findByEndDestination(endDestination) != null)
			return schedRepository.findByEndDestination(endDestination);
		else
			return null;
	}
	
	//Update
	
	//Delete
}
