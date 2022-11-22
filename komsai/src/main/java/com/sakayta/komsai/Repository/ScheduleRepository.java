package com.sakayta.komsai.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sakayta.komsai.Entity.ScheduleEntity;

@Repository
public interface ScheduleRepository extends JpaRepository <ScheduleEntity, Integer>{
	ScheduleEntity findByScheduleDate(Date scheduleDate);
}
