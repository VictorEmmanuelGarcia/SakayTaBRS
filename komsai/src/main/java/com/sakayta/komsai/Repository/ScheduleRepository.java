package com.sakayta.komsai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sakayta.komsai.Entity.ScheduleEntity;

@Repository
public interface ScheduleRepository extends JpaRepository <ScheduleEntity, Integer>{
	ScheduleEntity findByScheduleId(int scheduleId);
}
