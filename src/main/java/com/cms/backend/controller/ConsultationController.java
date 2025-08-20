package com.cms.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.backend.service.IConsultationService;

@RestController
@RequestMapping("api/v1/consultation")
public class ConsultationController {
	
	private final IConsultationService consultationService;
	
	@Autowired
	public ConsultationController(IConsultationService consultationService) {
		this.consultationService = consultationService;
	}
	
	@PostMapping("/validate")
	public ResponseEntity<String> validateAppointment(@RequestBody String tokenNo){
		try {
			String response = consultationService.validateAppointment(tokenNo);
			return ResponseEntity.ok(response);
		}
		catch(IllegalArgumentException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}

}
