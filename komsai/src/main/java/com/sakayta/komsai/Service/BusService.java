package com.sakayta.komsai.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
	public List<BusEntity> getAllBus(){
		return busrepo.findAll();
	}
		
	//R - Read or search bus record by bus number
	public BusEntity findByDestination(String destination) {
		if(busrepo.findByDestination(destination)!=null) {
			return busrepo.findByDestination(destination);
		}
		else {
			return null;
		}
	}
	
	public BusEntity findByNumberCompanyBus(String companyNumber) {
		if(busrepo.findByNumberCompanyBus(companyNumber)!=null) {
			return busrepo.findByNumberCompanyBus(companyNumber);
		}
		else {
			return null;
		}
	}
	//Update
	public BusEntity putBus(@RequestParam int busId, @RequestBody BusEntity newBusEntity) throws Exception{
		BusEntity bus = new BusEntity();
		
		try {
			bus = busrepo.findById(busId).get();
			bus.setBusSeats(newBusEntity.getBusSeats());
			bus.setDestination(newBusEntity.getDestination());
			
			return busrepo.save(bus);
		}catch(NoSuchElementException nex) {
			throw new Exception("Bus ID number "+ busId +" does not exist!");
		}
	}
	
	//Delete
	public String deleteBus(int busId) {
		String msg;
		if(busrepo.findById(busId) != null) {
			busrepo.deleteById(busId);
			msg = "Passenger ID Number "+ busId +" is successfully deleted!";
		}else {
			msg = "Passenger ID Number "+ busId +" is NOT found!";
		}
		return msg;
	}

}