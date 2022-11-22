package com.sakayta.komsai.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakayta.komsai.Entity.ScheduleEntity;
import com.sakayta.komsai.Repository.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	ScheduleRepository schedRepository;
	
	//Creates a schedule
	public ScheduleEntity createSchedule(ScheduleEntity schedule) {
		return schedRepository.save(schedule);
	}
	
	//Reads a schedule(s)
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
	
	//Update an existing schedule by Id
	public ScheduleEntity updateSchedule(int scheduleId, ScheduleEntity newScheduleDetails) throws Exception{
		ScheduleEntity schedule = new ScheduleEntity();
		
		try {
			schedule = schedRepository.findById(scheduleId).get();
			schedule.setStartLocation(newScheduleDetails.getStartLocation());
			schedule.setEndDestination(newScheduleDetails.getEndDestination());
			schedule.setArrivalTime(newScheduleDetails.getArrivalTime());
			schedule.setDepartureTime(newScheduleDetails.getDepartureTime());
			schedule.setScheduleDate(newScheduleDetails.getScheduleDate());
			
			return schedRepository.save(schedule);
		
		}catch(NoSuchElementException nex) {
			throw new Exception("ID number "+ scheduleId +" does not exist!");
		}
	}
	
	//Deletes an existing schedule
	public String deleteSchedule(int scheduleId) {
		
		String msg;
		if(schedRepository.findById(scheduleId) != null) {
			schedRepository.deleteById(scheduleId);
			msg = "Schedule ID Number "+ scheduleId +" is successfully deleted!";
		}else {
			msg = "Schedule ID Number "+ scheduleId +" is NOT found!";
		}
		return msg;
	}
}
