package com.cms.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.backend.model.Appointment;

public interface IAppointmentRepo extends JpaRepository<Appointment, Integer>{

}
