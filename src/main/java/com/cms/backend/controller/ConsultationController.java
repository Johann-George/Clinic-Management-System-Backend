package com.cms.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.backend.dto.ConsultationRequestDto;
import com.cms.backend.dto.ValidateAppointmentRequestDto;
import com.cms.backend.dto.ValidateAppointmentResponseDto;
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
	public ResponseEntity<ValidateAppointmentResponseDto> validateAppointment(@RequestBody ValidateAppointmentRequestDto request){
			ValidateAppointmentResponseDto response = consultationService.validateAppointment(request.getTokenNo());
			System.out.println("Appointment ID:"+response.getAppointmentId());
			if(response.getAppointmentId() == null) {
				return ResponseEntity.badRequest().body(response);
			}
			return ResponseEntity.ok(response);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> saveConsultation(@RequestBody ConsultationRequestDto consultationRequestDto){
		System.out.println("Medicines: " + consultationRequestDto.getPrescribedMedicines());
		System.out.println("Lab Tests: " + consultationRequestDto.getPrescribedLabTests());
		String response = consultationService.saveConsultation(consultationRequestDto);
		if(response == null) {
			return ResponseEntity.badRequest().body("Consultation could be saved");
		}
		return ResponseEntity.ok(response);
	}

}
