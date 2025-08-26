package com.cms.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cms.backend.dto.AppointmentRequest;
import com.cms.backend.dto.AppointmentResponseDto;
import com.cms.backend.model.Appointment;
import com.cms.backend.service.IAppointmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {
	
	private final IAppointmentService appointmentService;
	
	@Autowired
	public AppointmentController(IAppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@PostMapping("/book")
	public ResponseEntity<AppointmentResponseDto> bookAppointment(@Valid @RequestBody AppointmentRequest appointmentRequest) {
		Appointment savedAppointment = appointmentService.bookAppointment(appointmentRequest);
		AppointmentResponseDto responseDto = new AppointmentResponseDto(savedAppointment.getTokenNo(),"Appointment booked successfully");
		return ResponseEntity.ok(responseDto);
	}
	
}
