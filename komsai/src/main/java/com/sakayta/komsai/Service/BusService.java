package com.sakayta.komsai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sakayta.komsai.Entity.BusEntity;
import com.sakayta.komsai.Repository.BusRepository;

@Service
public class BusService {

	@Autowired
	BusRepository busrepo;
	
	//C - Create or insert a bus record
	public BusEntity insertBus(BusEntity bus) {
		return busrepo.save(bus);
	}
		
	//R - Read all records from tbl_bus
	public List<BusEntity> getAllBuses(){
		return busrepo.findAll();
	}
		
	//R - Read or search bus record by bus number
	public BusEntity findByBusNumber(String busNumber) {
		if(busrepo.findByBusNumber(busNumber)!=null) {
			return busrepo.findByBusNumber(busNumber);
		}
		else {
			return null;
		}
	}	
}