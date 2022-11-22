package com.sakayta.komsai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sakayta.komsai.Entity.BusEntity;

@Repository
public interface BusRepository extends JpaRepository<BusEntity, Integer>{
	//user-defined query
	BusEntity findByDestination(String destination);
	BusEntity findByNumberCompanyBus(String numberCompanyBus);
}
