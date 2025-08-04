package com.cms.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.backend.model.Patient;
import com.cms.backend.model.User;
import com.cms.backend.repo.IPatientRepo;
import com.cms.backend.repo.IUserRepo;

@Service
public class PatientServiceImpl implements IPatientService {
	
	private final IPatientRepo patientRepo;
	private final IUserRepo userRepo;
	
	@Autowired
	public PatientServiceImpl(IPatientRepo patientRepo, IUserRepo userRepo) {
		this.patientRepo = patientRepo;
		this.userRepo = userRepo;
	}

	@Override
	public void addPatient(Patient patient) {
		if (patient.getUser() == null || patient.getUser().getUserId() == null) {
	        throw new IllegalArgumentException("User ID is required.");
	    }
		Integer userId = patient.getUser().getUserId();
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
		patient.setUser(user);
		patientRepo.save(patient);
	}

	@Override
	public Patient getPatientByName(String username) {
		return patientRepo.findByUserUsername(username);
	}

}
