package com.cms.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.backend.model.Patient;
import com.cms.backend.service.IPatientService;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {
	
	private final IPatientService patientService;
	
	@Autowired
	public PatientController(IPatientService patientService) {
		this.patientService = patientService;
	}
	
	@PostMapping("/register")
	public void addPatient(@RequestBody Patient patient) {
		patientService.addPatient(patient);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<Patient> getPatientByUsername(@PathVariable String username) {
		Patient patient = patientService.getPatientByName(username);
		System.out.println("Found patient: " + patient);
		if (patient != null) {
	        return ResponseEntity.ok(patient);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

}
