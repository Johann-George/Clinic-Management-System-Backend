package com.cms.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.backend.model.Appointment;
import com.cms.backend.model.Consultation;

@Repository
public interface IConsultationRepo extends JpaRepository<Consultation, Integer>{

}
