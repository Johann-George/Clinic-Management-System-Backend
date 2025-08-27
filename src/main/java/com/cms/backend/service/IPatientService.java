package com.cms.backend.service;

import com.cms.backend.dto.PatientRequestDto;
import com.cms.backend.model.Patient;

public interface IPatientService {
	
	void addPatient(PatientRequestDto patient);
	Patient getPatientByName(String username);

}
