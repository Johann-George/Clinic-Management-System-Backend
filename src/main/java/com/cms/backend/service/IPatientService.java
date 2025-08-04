package com.cms.backend.service;

import com.cms.backend.model.Patient;

public interface IPatientService {
	
	void addPatient(Patient patient);
	Patient getPatientByName(String username);

}
