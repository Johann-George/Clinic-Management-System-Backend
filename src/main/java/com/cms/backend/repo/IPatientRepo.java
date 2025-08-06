package com.cms.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.backend.model.Patient;

@Repository
public interface IPatientRepo extends JpaRepository<Patient, Integer> {
	
	Patient findByUserUsername(String username);
	Patient findByUserUserId(Integer userId);

}
