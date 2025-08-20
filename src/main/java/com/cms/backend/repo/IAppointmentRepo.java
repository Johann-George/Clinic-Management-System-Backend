package com.cms.backend.repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.backend.model.Appointment;

public interface IAppointmentRepo extends JpaRepository<Appointment, Integer>{
	
	int countByAppointmentDate(LocalDate date);
	Appointment findByTokenNo(String tokenNo);

}
