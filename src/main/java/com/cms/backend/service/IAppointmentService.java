package com.cms.backend.service;

import com.cms.backend.dto.AppointmentRequest;

public interface IAppointmentService {

	void bookAppointment(AppointmentRequest appointmentRequest);
	
}
