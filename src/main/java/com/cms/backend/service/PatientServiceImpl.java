package com.cms.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.backend.model.Patient;
import com.cms.backend.model.User;
import com.cms.backend.model.User.Role;
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
		User user = patient.getUser();
		if(user == null || user.getUsername() == null || user.getPassword() == null) {
			throw new IllegalArgumentException("Username and password are required");
		}
		user.setRole(Role.PATIENT);
		User savedUser = userRepo.save(user);
		patient.setUser(savedUser);
		patientRepo.save(patient);
	}

	@Override
	public Patient getPatientByName(String username) {
		return patientRepo.findByUserUsername(username);
	}

}
