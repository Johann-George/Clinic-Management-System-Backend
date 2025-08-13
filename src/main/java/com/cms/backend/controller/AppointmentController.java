package com.cms.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cms.backend.dto.AppointmentRequest;
import com.cms.backend.service.IAppointmentService;

@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {
	
	private final IAppointmentService appointmentService;
	
	@Autowired
	public AppointmentController(IAppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@PostMapping("/book")
	public void bookAppointment(@RequestBody AppointmentRequest appointmentRequest) {
		appointmentService.bookAppointment(appointmentRequest);
	}
	
}
