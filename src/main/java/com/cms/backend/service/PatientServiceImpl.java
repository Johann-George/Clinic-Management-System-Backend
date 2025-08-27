package com.cms.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.backend.dto.PatientRequestDto;
import com.cms.backend.dto.UserDto;
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
	public void addPatient(PatientRequestDto patientDto) {
		UserDto userDto = patientDto.getUser();
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setRole(Role.PATIENT);
		User savedUser = userRepo.save(user);
		Patient patient = new Patient();
		patient.setName(patientDto.getName());
		patient.setAddress(patientDto.getAddress());
		patient.setDob(patientDto.getDob());
		patient.setGender(patientDto.getGender());
		patient.setContactNo(patientDto.getContactNo());
		patient.setUser(savedUser);
		patientRepo.save(patient);
	}

	@Override
	public Patient getPatientByName(String username) {
		return patientRepo.findByUserUsername(username);
	}

}
