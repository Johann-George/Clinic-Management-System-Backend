package com.cms.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.backend.dto.PatientRequestDto;
import com.cms.backend.model.Patient;
import com.cms.backend.service.IPatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {
	
	private final IPatientService patientService;
	
	@Autowired
	public PatientController(IPatientService patientService) {
		this.patientService = patientService;
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<Patient> getPatientByUsername(@PathVariable String username) {
		Patient patient = patientService.getPatientByName(username);
	    return ResponseEntity.ok(patient);
	}

}
